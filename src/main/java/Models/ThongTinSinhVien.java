package Models;

public class ThongTinSinhVien {
	private String MSSV;
	private String HoTen;
	private String GioiTinh;
	private String MaKhoa;
	private String SDT;
	private String Email;
	private String DiaChi;
	public ThongTinSinhVien(String mSSV, String hoTen, String gioiTinh, String maKhoa, String sDT, String email,
			String diaChi) {
		super();
		MSSV = mSSV;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		MaKhoa = maKhoa;
		SDT = sDT;
		Email = email;
		DiaChi = diaChi;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
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
	public ThongTinSinhVien() {
		super();
	}
	
	
}
