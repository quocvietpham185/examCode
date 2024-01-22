package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class FoodItem  {
	protected int Mamonan;
	protected String Tenmon;
	protected float Gia;
	protected String Loaimon;
	
	public FoodItem() {
		super();
	}
	public int getMamonan() {
		return Mamonan;
	}
	public void setMamonan(int mamonan) {
		this.Mamonan = Mamonan;
	}
	public String getTenmon() {
		return Tenmon;
	}
	public void setTenmon(String tenmon) {
		this.Tenmon = tenmon;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		this.Gia = gia;
	}
	public String getLoaimon() {
		return Loaimon;
	}
	public void setLoaimon(String loaimon) {
		this.Loaimon = loaimon;
	}
	public FoodItem(int Mamonan, String Tenmon, float Gia, String Loaimon) {
		this.Mamonan = Mamonan;
		this.Gia = Gia;
		this.Loaimon = Loaimon;
		this.Tenmon = Tenmon;
	}
	@Override
	public String toString() {
		return "FoodItem [Mamonan=" + Mamonan + ", Tenmon=" + Tenmon + ", Gia=" + Gia + ", Loaimon=" + Loaimon + "]";
	}
	
	
	
	
}