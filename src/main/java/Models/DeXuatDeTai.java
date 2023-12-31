package Models;

import java.sql.Date;

public class DeXuatDeTai {
	private int MaDeXuatDeTai;
	private String MaChuNhiem;
	private String TenDeTai;
	private int KinhPhi;
	private byte[] FileMoTaDeTai;
	private String TrangThai;
	private String GhiChu;
	private Date NgayDeXuat;

	public DeXuatDeTai(int maDeXuatDeTai, String maChuNhiem, String tenDeTai, int kinhPhi, byte[] fileMoTaDeTai,
			Date ngayDeXuat) {
		super();
		MaDeXuatDeTai = maDeXuatDeTai;
		MaChuNhiem = maChuNhiem;
		TenDeTai = tenDeTai;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		NgayDeXuat = ngayDeXuat;
	}
	public DeXuatDeTai(int maDeXuatDeTai,  String tenDeTai, Date ngayDeXuat, int kinhPhi, byte[] fileMoTaDeTai,
			String trangThai, String ghiChu) {
		super();
		MaDeXuatDeTai = maDeXuatDeTai;
		NgayDeXuat = ngayDeXuat;
		TenDeTai = tenDeTai;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		TrangThai = trangThai;
		GhiChu = ghiChu;
	}
	public DeXuatDeTai(int maDeXuatDeTai, String maChuNhiem, String tenDeTai, int kinhPhi, byte[] fileMoTaDeTai,
			String trangThai, String ghiChu, Date ngayDeXuat) {
		super();
		MaDeXuatDeTai = maDeXuatDeTai;
		MaChuNhiem = maChuNhiem;
		TenDeTai = tenDeTai;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		TrangThai = trangThai;
		GhiChu = ghiChu;
		NgayDeXuat = ngayDeXuat;
	}
	public DeXuatDeTai() {
		super();
	}
	public int getMaDeXuatDeTai() {
		return MaDeXuatDeTai;
	}
	public void setMaDeXuatDeTai(int maDeXuatDeTai) {
		MaDeXuatDeTai = maDeXuatDeTai;
	}
	public String getMaChuNhiem() {
		return MaChuNhiem;
	}
	public void setMaChuNhiem(String maChuNhiem) {
		MaChuNhiem = maChuNhiem;
	}
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public int getKinhPhi() {
		return KinhPhi;
	}
	public void setKinhPhi(int kinhPhi) {
		KinhPhi = kinhPhi;
	}
	public byte[] getFileMoTaDeTai() {
		return FileMoTaDeTai;
	}
	public void setFileMoTaDeTai(byte[] fileMoTaDeTai) {
		FileMoTaDeTai = fileMoTaDeTai;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public Date getNgayDeXuat() {
		return NgayDeXuat;
	}
	public void setNgayDeXuat(Date ngayDeXuat) {
		NgayDeXuat = ngayDeXuat;
	}

}