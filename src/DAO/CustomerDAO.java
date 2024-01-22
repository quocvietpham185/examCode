package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import JDBCUtil.DatabaseConnector;
import Model.Customer;
import Model.Employee;
import Model.Customer;

public class CustomerDAO {
	private Connection connection;
	public CustomerDAO() {
		connection = DatabaseConnector.getConnection();
		
	}
	public CustomerDAO(Connection connection) {
		this.connection = connection;
	}
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}
	
	public boolean insert(Customer t) {
		try {
			String sql = "INSERT INTO customer (`Mã Khách Hàng`, `Tên Khách Hàng`, `Điện Thoại`, `Giới Tính`, `Ngày Sinh`) VALUES (?, ?, ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMaKH());
			preparedStatement.setString(2, t.getTenKH());
			preparedStatement.setString(3, t.getDienThoai());
			preparedStatement.setString(4, t.getGioitinh());
			preparedStatement.setString(5, t.getNgaySinh());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
			}
	
	
	public boolean update(Customer t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE customer SET  `Tên Khách Hàng` = ?,  `Điện Thoại` = ?,  `Giới Tính` = ?, `Ngày Sinh` = ? WHERE `Mã Khách Hàng` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(5, t.getMaKH());
			preparedStatement.setString(1, t.getTenKH());
			preparedStatement.setString(2, t.getDienThoai());
			preparedStatement.setString(3, t.getGioitinh());
			preparedStatement.setString(4, t.getNgaySinh());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM customer WHERE `Mã Khách Hàng` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMaKH());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Customer> Khachhang = new ArrayList<Customer>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT *FROM customer";
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				int MaKH = resultSet.getInt("Mã Khách Hàng");
				String TenKH = resultSet.getString("Tên Khách Hàng");
				String DienThoai = resultSet.getString("Điện Thoại");
				String GioiTinh = resultSet.getString("Giới Tính");
				String NgaySinh = resultSet.getString("Ngày Sinh");
				
				
				Customer khachhang = new Customer(MaKH, TenKH, DienThoai, GioiTinh, NgaySinh);
				Khachhang.add(khachhang);
			}
			stmt.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Khachhang;
	}
	public Customer selectById(Customer t) {
		Customer khachhang = new Customer(0, null, null, null, null);
		try {
			String sql = "SELECT * FROM customer WHERE `Mã Khách Hàng` = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, t.getMaKH());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int MaKH = resultSet.getInt("Mã Khách Hàng");
				
				String TenKH = resultSet.getString("Tên Khách Hàng");
				
				String DienThoai = resultSet.getString("Điện Thoại");
				
				String GioiTinh = resultSet.getString("Giới Tính");
				String NgaySinh = resultSet.getString("Ngày Sinh");
				khachhang = new Customer(MaKH, TenKH,  DienThoai, GioiTinh, NgaySinh);

			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return khachhang;
	}

	
	public ArrayList<Customer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<Customer> khachhangs = new ArrayList<Customer>();
		try {
			String sql = "SELECT *FROM customer WHERE " + condition;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int MaKH = resultSet.getInt("Mã Khách Hàng");
			
				String TenKH = resultSet.getString("Tên Khách Hàng");
				
				String DienThoai = resultSet.getString("Điện Thoại");
				
				String GioiTinh = resultSet.getString("Giới Tính");
				String NgaySinh = resultSet.getString("Ngày Sinh");
				Customer khachhang = new Customer(MaKH, TenKH, DienThoai,  GioiTinh, NgaySinh);
				khachhangs.add(khachhang);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return khachhangs;
	}
	public ArrayList<Customer> selectByTenKH(String TenKH1) {
	    ArrayList<Customer> KhachHang = new ArrayList<Customer>();
	    try {
	        String sql = "SELECT * FROM customer WHERE `Tên Khách Hàng` = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, TenKH1);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()) {
	        	int MaKH = resultSet.getInt("Mã Khách Hàng");
				String TenKH = resultSet.getString("Tên Khách Hàng");
				String DienThoai = resultSet.getString("Điện Thoại");
				String GioiTinh = resultSet.getString("Giới Tính");
				String NgaySinh = resultSet.getString("Ngày Sinh");
				Customer khachhang = new Customer(MaKH, TenKH, DienThoai,  GioiTinh, NgaySinh);
				KhachHang.add(khachhang);
			}
			preparedStatement.close();
			resultSet.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return KhachHang;
	}

}
