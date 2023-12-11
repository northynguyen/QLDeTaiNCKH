package Models;

public class Khoa {
	private String MaKhoa;
	private String TenKhoa;
	public Khoa(String maKhoa, String tenKhoa) {
		super();
		MaKhoa = maKhoa;
		TenKhoa = tenKhoa;
	}
	public Khoa() {
		super();
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String string) {
		MaKhoa = string;
	}
	public String getTenKhoa() {
		return TenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		TenKhoa = tenKhoa;
	}	
}
