package Table;

import java.util.ArrayList;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Customer;
import Model.Employee;

public class TableCustomer extends AbstractTableModel {
	private String[] columnNames = {"Mã Khách Hàng", "Tên Khách Hàng", "Điện Thoại", "Giới Tính", "Ngày Sinh"};
	private List<Customer> customer;
	
	public TableCustomer() {
		customer = new ArrayList<Customer>();
	}
	
	public void setData(List<Customer> customer) {
		this.customer = customer;
		//Mõi khi dữ liệu của tableModel đc cập nhật qua setData thì tableModel sẽ thông báo cho table trong View cập nhật lại
		fireTableDataChanged();
	}
	
	

	@Override
	public int getRowCount() {
		
		   return customer.size();
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Customer khachhang = customer.get(rowIndex);
		//Lấy cấy dối tượng khachs hang tại vị trí rowIndex
		//Sau đó dùng switch để xác định columnIndex cần lấy
		switch(columnIndex)
		{
		case 0:
			return khachhang.getMaKH();
			
		case 1:
			return khachhang.getTenKH();
		case 2:
			return khachhang.getDienThoai();
		case 3:
			return khachhang.getGioitinh();
		case 4:
			return khachhang.getNgaySinh();
		}
		return null;
	}
}
