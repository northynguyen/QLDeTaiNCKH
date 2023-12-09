package Models;

import java.util.Date;

public class DeXuatDeTai {
	private int MaDeXuatDeTai;
	private Date NgayDeXuat;
	private String MaChuNhiem;

	private String TenDeTai;
	private Date NgayDeXuat;
	private int KinhPhi;
	private byte[] FileMoTaDeTai;
	private String TrangThai;
	private String GhiChu;

	public DeXuatDeTai(int maDeXuatDeTai, String maChuNhiem, String tenDeTai, Date ngayDeXuat, int kinhPhi,
			byte[] fileMoTaDeTai,
			String trangThai, String ghiChu) {
		super();
		MaDeXuatDeTai = maDeXuatDeTai;
		MaChuNhiem = maChuNhiem;
		TenDeTai = tenDeTai;
		NgayDeXuat = ngayDeXuat;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		TrangThai = trangThai;
		GhiChu = ghiChu;
	}

	public DeXuatDeTai(int maDeXuatDeTai, String maChuNhiem, String tenDeTai, Date ngayDeXuat, int kinhPhi,
			byte[] fileMoTaDeTai) {
		super();
		MaDeXuatDeTai = maDeXuatDeTai;
		MaChuNhiem = maChuNhiem;
		TenDeTai = tenDeTai;
		NgayDeXuat = ngayDeXuat;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;

	}

	public DeXuatDeTai() {
		super();
	}

	public DeXuatDeTai(int maDeXuatDeTai, String tenDeTai, Date ngayDeXuat, int kinhPhi, byte[] fileMoTaDeTai,
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

	public Date getNgayDeXuat() {
		return NgayDeXuat;
	}

	public void setNgayDeXuat(Date ngayDeXuat) {
		NgayDeXuat = ngayDeXuat;
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

	public Date getNgayDeXuat() {
		return NgayDeXuat;
	}

	public void setNgayDeXuat(Date ngayDeXuat) {
		NgayDeXuat = ngayDeXuat;
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

}
