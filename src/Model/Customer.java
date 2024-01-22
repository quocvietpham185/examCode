package Model;



import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Objects;

public class Customer extends Models {
	protected int MaKH;
	protected String TenKH, DienThoai, gioitinh;
	protected String ngaysinh;
	
	
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaySinh() {
		return ngaysinh;
	}
	public void setNgaySinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return "Customer [MaKH=" + MaKH + ", TenKH=" + TenKH + ", DienThoai=" + DienThoai + ", gioitinh=" + gioitinh
				+ ", ngaysinh=" + ngaysinh + "]";
	}
	public Customer(int MaKH, String TenKH, String DienThoai, String gioitinh, String ngaysinh ) {
		this.MaKH = MaKH;
		this.TenKH = TenKH;
		this.DienThoai = DienThoai;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}
	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

