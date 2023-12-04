package Models;

import java.sql.Date;

public class ThongTinTaiKhoan {
	private String MaTaiKhoan;
	private String MatKhau;
	private String Role;
	private String HoTen;
	private String GioiTinh;
	private String MaKhoa;
	private String SDT;
	private String Email;
	private String DiaChi;
	public ThongTinTaiKhoan(String maTaiKhoan, String matKhau, String role, String hoTen, String gioiTinh, String maKhoa,
			String sDT, String email, String diaChi) {
		super();
		MaTaiKhoan = maTaiKhoan;
		MatKhau = matKhau;
		Role = role;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		MaKhoa = maKhoa;
		SDT = sDT;
		Email = email;
		DiaChi = diaChi;
	}
	public ThongTinTaiKhoan() {
		super();
	}
	public String getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(String string) {
		MaTaiKhoan = string;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
}
