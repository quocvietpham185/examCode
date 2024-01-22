package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import JDBCUtil.DatabaseConnector;
import Model.FoodItem;

public class FoodItemDAO {
	private Connection connection;
	public FoodItemDAO() {
		connection = DatabaseConnector.getConnection();
	}
	public FoodItemDAO(Connection connection) {
		this.connection = connection;
	}
	public static FoodItemDAO getInstance() {
		return new FoodItemDAO();
	}

	public boolean insert(FoodItem t) {
		try {
			String sql = "INSERT INTO fooditem (`Mã món ăn`, `Tên món ăn`,  `Giá`, `Loại món`) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMamonan());
			preparedStatement.setString(2, t.getTenmon());
			preparedStatement.setFloat(3, t.getGia());
			preparedStatement.setString(4, t.getLoaimon());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
		}
	

	public boolean update(FoodItem t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE fooditem SET `Tên món ăn` = ?,  `Giá` = ?, `Loại món` = ? WHERE `Mã món ăn` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(4, t.getMamonan());
			preparedStatement.setString(1, t.getTenmon());
			preparedStatement.setFloat(2, t.getGia());
			preparedStatement.setString(3, t.getLoaimon());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(FoodItem t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM fooditem WHERE `Mã món ăn` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMamonan());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<FoodItem> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<FoodItem> mathang = new ArrayList<FoodItem>();
		try {
			Statement PreparedStatement = connection.createStatement();
			String sql = "SELECT * FROM fooditem";
			ResultSet resultSet = PreparedStatement.executeQuery(sql);
			while(resultSet.next())
			{
				int maMonAn = resultSet.getInt("Mã món ăn");
				String tenMonAn = resultSet.getString("Tên món ăn");
				float Gia = resultSet.getFloat("Giá");
				String LoaiMon = resultSet.getString("Loại món");				
				FoodItem Mathang = new FoodItem(maMonAn, tenMonAn, Gia, LoaiMon);
				mathang.add(Mathang);
			}
			PreparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mathang;
	}
	public FoodItem selectById(FoodItem t) {
		FoodItem mathang = new FoodItem(0, null, 0, null);
		
		try {
			String sql = "SELECT * FROM fooditem WHERE `Mã món ăn` = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setLong(1, t.getMamonan());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int maMonAn = resultSet.getInt("Mã món ăn");
				String tenMonAn = resultSet.getString("Tên món ăn");
				Float Gia = resultSet.getFloat("Giá");
				String LoaiMon = resultSet.getString("Loại món");
				mathang = new FoodItem(maMonAn, tenMonAn, Gia, LoaiMon);

			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mathang;
	}

	
	public ArrayList<FoodItem> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<FoodItem> Mathang = new ArrayList<FoodItem>();
		try {
			String sql = "SELECT *FROM fooditem WHERE " + condition;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int maMonAn = resultSet.getInt("Mã món ăn");
				String tenMonAn = resultSet.getString("Tên món ăn");
				Float Gia = resultSet.getFloat("Giá");
				String LoaiMon = resultSet.getString("Loại món");
				FoodItem mathang = new FoodItem(maMonAn, tenMonAn, Gia, LoaiMon);
				Mathang.add(mathang);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Mathang;
	}



}
