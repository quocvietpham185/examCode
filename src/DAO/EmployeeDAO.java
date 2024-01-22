package DAO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import JDBCUtil.DatabaseConnector;
import Model.Employee;


public class EmployeeDAO {
	private Connection connection;
	public EmployeeDAO() {
		connection = DatabaseConnector.getConnection();
	}
	public EmployeeDAO(Connection connection) {
		this.connection = connection;
	}
	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}
	
	public boolean insert(Employee t) {
		try {
			String sql = "INSERT INTO employee (`Mã nhân viên`, `Tên nhân viên`,  `Điện thoại`, `Giới tính`, `Ngày bắt đầu`, `Lương`) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getMaNV());
			preparedStatement.setString(2, t.getTenNV());
			preparedStatement.setString(3, t.getDienThoai());
			preparedStatement.setString(4, t.getGioitinh());
			preparedStatement.setString(5, t.getStartDate());
			preparedStatement.setDouble(6, t.getSalary());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
		}
	

	public boolean update(Employee t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE employee SET  `Tên nhân viên` = ?,  `Điện thoại` = ?,  `Giới tính` = ?, `Ngày bắt đầu` = ?, `Lương` = ? WHERE `Mã nhân viên` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(6, t.getMaNV());
			preparedStatement.setString(1, t.getTenNV());
			preparedStatement.setString(2, t.getDienThoai());
			preparedStatement.setString(3, t.getGioitinh());
			preparedStatement.setString(4, t.getStartDate());
			preparedStatement.setDouble(5, t.getSalary());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM employee WHERE `Mã nhân viên` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getMaNV());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<Employee> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Employee> nhanviens = new ArrayList<Employee>();
		try {
			Statement PreparedStatement = connection.createStatement();
			String sql = "SELECT *FROM employee";
			ResultSet resultSet = PreparedStatement.executeQuery(sql);
			while(resultSet.next())
			{
				String MaNV = resultSet.getString("Mã nhân viên");
				String TenNV = resultSet.getString("Tên nhân viên");
				String DienThoai = resultSet.getString("Điện thoại");
				String GioiTinh = resultSet.getString("Giới tính");
				String startDate = resultSet.getString("Ngày bắt đầu");
				double salary = resultSet.getDouble("Lương");
				
				Employee nhanvien = new Employee(MaNV, TenNV, DienThoai, GioiTinh, startDate, salary);
				nhanviens.add(nhanvien);
			}
			PreparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nhanviens;
	}
	public Employee selectById(Employee t) {
		Employee nhanvien = new Employee(null, null, null, null, null, 0);
		
		try {
			String sql = "SELECT * FROM employee WHERE `Mã nhân viên` = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, t.getMaNV());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String MaNV = resultSet.getString("Mã nhân viên");
				
				String TenNV = resultSet.getString("Tên nhân viên");
				
				String DienThoai = resultSet.getString("Điện thoại");
				
				String GioiTinh = resultSet.getString("Giới tính");
				String startDate = resultSet.getString("Ngày bắt đầu");
				Double salary = resultSet.getDouble("Lương");
				nhanvien = new Employee(MaNV, TenNV,  DienThoai, GioiTinh, startDate, salary);

			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nhanvien;
	}

	
	public ArrayList<Employee> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<Employee> nhanviens = new ArrayList<Employee>();
		try {
			String sql = "SELECT *FROM employee WHERE " + condition;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String MaNV = resultSet.getString("Mã nhân viên");
			
				String TenNV = resultSet.getString("Tên nhân viên");
				
				String DienThoai = resultSet.getString("Điện thoại");
				
				String GioiTinh = resultSet.getString("Giới tính");
				String startDate = resultSet.getString("Ngày bắt đầu");
				Double salary = resultSet.getDouble("Lương");
				Employee nhanvien = new Employee(MaNV, TenNV, DienThoai,  GioiTinh, startDate, salary);
				nhanviens.add(nhanvien);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nhanviens;
	}
	
	public ArrayList<Employee> selectByTenNV(String TenNV1) {
	    ArrayList<Employee> Nhanvien = new ArrayList<Employee>();
	    try {
	        String  sql = "SELECT * FROM employee WHERE `Tên nhân viên` = '%" + TenNV1+ "%'";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, TenNV1);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            String MaNV = resultSet.getString("Mã nhân viên");
	            String TenNV = resultSet.getString("Tên nhân viên");
	            String DienThoai = resultSet.getString("Điện thoại");
	            String GioiTinh = resultSet.getString("Giới tính");
	            String startDate = resultSet.getString("Ngày bắt đầu");
	            Double salary = resultSet.getDouble("Lương");

	            Employee nhanvien = new Employee(MaNV, TenNV, DienThoai, GioiTinh, startDate, salary);
	            Nhanvien.add(nhanvien);
	        }
	        preparedStatement.close();
	        resultSet.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return Nhanvien;
	}


}
