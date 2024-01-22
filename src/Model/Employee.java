package Model;

import java.sql.Date;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class Employee{
	protected String MaNV;
	protected String  TenNV;
	protected String DienThoai;
	protected String gioitinh;

	protected String startDate;
	protected double salary;
	
	
	public String getMaNV() {
		return MaNV;
	}
	
	

	
	public String getTenNV() {
		return TenNV;
	}
	
	public String getDienThoai() {
		return DienThoai;
	}

	
	public String getStartDate() {
		return startDate;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary= salary;
	}
	public String getGioitinh() {
		// TODO Auto-generated method stub
		
		return gioitinh;
	}
	
	public Employee(String MaNV, String  TenNV, String DienThoai,String gioitinh,String startDate,double salary) {
		this.MaNV = MaNV;
		this.TenNV = TenNV;
		this.DienThoai = DienThoai;
		this.gioitinh=gioitinh;
		this.startDate = startDate;
		this.salary =  salary;
	}
	


	




	@Override
	public String toString() {
		return "Employee [MaNV=" + MaNV + ", TenNV=" + TenNV + ", DienThoai=" + DienThoai 
				+ ", gioitinh=" + gioitinh + ", startDate=" + startDate + ", salary=" + salary + "]";
	}


	public void setMaNV(String maNV) {
		MaNV = maNV;
	}


	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}


	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}


	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	

	
	
	
}
