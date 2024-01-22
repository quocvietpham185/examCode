package Controllers;
	import java.awt.event.ActionEvent;

	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.util.List;

	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;

	import DAO.EmployeeDAO;
	import Model.Employee;
	import View.EmployeeView;

public class EmployeeController {
	
	
		private EmployeeView employeeView;
		private EmployeeDAO employeeDAO;
			
		
	

		public  EmployeeController(EmployeeView employeeView) {
			
			this.employeeView = employeeView;
			employeeDAO = new EmployeeDAO();
			
			employeeView.addAddNhanVienListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Employee nhanvien = employeeView.getNhanVienData();
					if(nhanvien!=null)
					{
						boolean success = employeeDAO.insert(nhanvien);
						
						if(success)
						{
							employeeView.showListNhanVien(employeeDAO.selectAll());
							employeeView.showMessage("Thêm thành công");
						}
						else
						{
							employeeView.showMessage("Thêm thất bại");
						}
					}
				}
			});
			
			employeeView.addTableSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					employeeView.fillInputForm();
				}
			});
			
			employeeView.editAddNhanVienListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Employee nhanvien = employeeView.getNhanVienData();
					if(nhanvien!=null)
					{
						boolean success = employeeDAO.update(nhanvien);
						
						if(success)
						{
							employeeView.showListNhanVien(employeeDAO.selectAll());
							employeeView.showMessage("Sửa thành công");
						}
						else
						{
							employeeView.showMessage("Sửa thất bại");
						}
					}
				}
			});
			
			employeeView.deleteAddNhanVienListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Employee nhanvien = employeeView.getNhanVienData();
					if(nhanvien!=null)
					{
						boolean success = employeeDAO.delete(nhanvien);
						
						if(success)
						{
							employeeView.showListNhanVien(employeeDAO.selectAll());
							employeeView.showMessage("Xóa thành công");
						}
						else
						{
							employeeView.showMessage("Xóa thất bại");
						}
					}
				}
			});
			
		

			employeeView.searchAddNhanVienListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        try {
			            String nhanvien = employeeView.findTimKiem();
			            if (nhanvien != null) {
			                ArrayList<Employee> employees = employeeDAO.selectByTenNV(nhanvien);
			                
			                if (employees != null && !employees.isEmpty()) {
			                    // Tìm thấy nhân viên
			                    employeeView.showListNhanVien(employees);
			                    employeeView.showMessage("Đã tìm thấy nhân viên");
			                } else {
			                    // Không tìm thấy nhân viên
			                    employeeView.showListNhanVien(new ArrayList<>());
			                    employeeView.showMessage("Không tìm thấy nhân viên");
			                }
			            }
			        } catch (Exception ex) {
			            // Xử lý ngoại lệ ở đây, ví dụ:
			            ex.printStackTrace();
			            employeeView.showMessage("Có lỗi xảy ra khi tìm kiếm nhân viên");
			        }
			    }
			});
		}
		//Ta không hiển thị giao diện ở View mà ở controller, nên ta viết hàm này
		public void showEmployeeView() {
			
			//Trước khi hiển thị lên thì ta cần đọc cấy thông tin từ database để view vào cấy bảng
			ArrayList<Employee> nhanViens = employeeDAO.selectAll();
			
			//Cập nhật lại dữ liệu cho bảng bằng showListNhanVien ở bên ViewNhanVien
			employeeView.showListNhanVien(nhanViens);
			
			//Hiển thị lên
			employeeView.setVisible(true);
		}
		

	

}

