package Table;

import java.util.ArrayList;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Employee;

public class TableEmployee extends AbstractTableModel {
	
	private String[] columnNames = {"Mã nhân viên", "Tên nhân viên", "Điện thoại", "Giới tính", "Ngày bắt đầu", "Lương"};
	private List<Employee> employee;
	
	public TableEmployee() {
		employee = new ArrayList<Employee>();
	}

	
	public void setData(List<Employee> employee) {
		this.employee = employee;
		//Mõi khi dữ liệu của tableModel đc cập nhật qua setData thì tableModel sẽ thông báo cho table trong View cập nhật lại
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		
		    if (this.employee != null) {
		        return this.employee.size();
		    } else {
		        return 0; // Hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
		    }
		}

	



	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

public String getColumnName(int column) {
		//Trả về tên cột
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	//Lấy giá trị của 1 ô trong bảng
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Employee nhanvien = employee.get(rowIndex);
		//Lấy cấy dối tượng nhân viên tại vị trí rowIndex
		//Sau đó dùng switch để xác định columnIndex cần lấy
		switch(columnIndex)
		{
		case 0:
			return nhanvien.getMaNV();
			
		case 1:
			return nhanvien.getTenNV();
		case 2:
			return nhanvien.getDienThoai();
		case 3:
			return nhanvien.getGioitinh();
		case 4:
			return nhanvien.getStartDate();
		case 5:
			return nhanvien.getSalary();
		}
		return null;
	}
}
