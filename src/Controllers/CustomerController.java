package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.CustomerDAO;
import Model.Customer;
import Model.Employee;
import View.CustomerView;

public class CustomerController {
	
	private CustomerView customerview;
	private CustomerDAO customerDAO;
	
	public CustomerController(CustomerView customerview) {
		
		this.customerview = customerview;
		customerDAO = new CustomerDAO();
		
		customerview.addAddKhachHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer khachhang = customerview.getKhachHangData();
				if(khachhang!=null)
				{
					boolean success = customerDAO.insert(khachhang);
					
					if(success)
					{
						customerview.showListKhachHang(customerDAO.selectAll());
						customerview.showMessage("Thêm thành công");
					}
					else
					{
						customerview.showMessage("Thêm thất bại");
					}
				}
			}
			
		});
		
		customerview.addTableSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				customerview.fillInputForm();
			}
		});
		customerview.editAddKhachHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer khachhang = customerview.getKhachHangData();
				if(khachhang!=null)
				{
					boolean success = customerDAO.update(khachhang);
					
					if(success)
					{
						customerview.showListKhachHang(customerDAO.selectAll());
						customerview.showMessage("Sửa thành công");
					}
					else
					{
						customerview.showMessage("Sửa thất bại");
					}
				}
			}
		});
		customerview.deleteAddKhachHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer khachhang = customerview.getKhachHangData();
				if(khachhang!=null)
				{
					boolean success = customerDAO.delete(khachhang);
					
					if(success)
					{
						customerview.showListKhachHang(customerDAO.selectAll());
						customerview.showMessage("Xóa thành công");
					}
					else
					{
						customerview.showMessage("Xóa thất bại");
					}
				}
			}
		});
		
	
	customerview.searchAddKhachHangListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    try {
		    String khachhang = customerview.findTimKiem();
	        
	        if (khachhang != null) {
	          
	            ArrayList<Customer> KHang = customerDAO.selectByTenKH(khachhang);
	            if (KHang != null && !KHang.isEmpty()) {
                    // Tìm thấy khách hàng
	            	customerview.showListKhachHang(KHang);
	            	customerview.showMessage("Đã tìm thấy khách hàng");
                } else {
                    // Không tìm thấy khách hàng
                	customerview.showListKhachHang(new ArrayList<>());
                	customerview.showMessage("Không tìm thấy khách hàng");
                }
            }
        } catch (Exception ex) {
            // Xử lý ngoại lệ ở đây, ví dụ:
            ex.printStackTrace();
            customerview.showMessage("Có lỗi xảy ra khi tìm kiếm nhân viên");
        }
	   }
});
}
	
	//Ta không hiển thị giao diện ở View mà ở controller, nên ta viết hàm này
	public void showCustomerView() {
		
		//Trước khi hiển thị lên thì ta cần đọc cấy thông tin từ database để view vào cấy bảng
		List<Customer> Khachhang = customerDAO.selectAll();
		
		//Cập nhật lại dữ liệu cho bảng bằng showListKhachHang ở bên ViewKhachhang
		customerview.showListKhachHang(Khachhang);
		
		//Hiển thị lên
		customerview.setVisible(true);
	}
		
	}
	

