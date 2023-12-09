package Models;

import java.sql.Date;

public class DangKyDeTai {
	private int MaDon;
	private int MaDeTai;
	private String MaChuNhiem;
	private Date NgayDuyet;
	private String MaNguoiDuyet;
	private byte[] FileQuyetDinh;
	private int MaThoiGian;
	private String TrangThai;
	private String GhiChu;

	public DangKyDeTai(int maDon, int maDeTai, String maChuNhiem, Date ngayDuyet, String maNguoiDuyet,
			byte[] fileQuyetDinh, int maThoiGian, String trangThai, String ghiChu) {
		super();
		MaDon = maDon;
		MaDeTai = maDeTai;
		MaChuNhiem = maChuNhiem;
		NgayDuyet = ngayDuyet;
		MaNguoiDuyet = maNguoiDuyet;
		FileQuyetDinh = fileQuyetDinh;
		MaThoiGian = maThoiGian;
		TrangThai = trangThai;
		GhiChu = ghiChu;
	}

	public DangKyDeTai(int maDeTai, String maChuNhiem, int maThoiGian, String trangThai) {
		super();
		MaDeTai = maDeTai;
		MaChuNhiem = maChuNhiem;
		MaThoiGian = maThoiGian;
		TrangThai = trangThai;
	}

	public DangKyDeTai() {
		super();
	}

	public int getMaDon() {
		return MaDon;
	}

	public void setMaDon(int maDon) {
		MaDon = maDon;
	}

	public int getMaDeTai() {
		return MaDeTai;
	}

	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}

	public String getMaChuNhiem() {
		return MaChuNhiem;
	}

	public void setMaChuNhiem(String maChuNhiem) {
		MaChuNhiem = maChuNhiem;
	}

	public Date getNgayDuyet() {
		return NgayDuyet;
	}

	public void setNgayDuyet(Date ngayDuyet) {
		NgayDuyet = ngayDuyet;
	}

	public String getMaNguoiDuyet() {
		return MaNguoiDuyet;
	}

	public void setMaNguoiDuyet(String maNguoiDuyet) {
		MaNguoiDuyet = maNguoiDuyet;
	}

	public byte[] getFileQuyetDinh() {
		return FileQuyetDinh;
	}

	public void setFileQuyetDinh(byte[] fileQuyetDinh) {
		FileQuyetDinh = fileQuyetDinh;
	}

	public int getMaThoiGian() {
		return MaThoiGian;
	}

	public void setMaThoiGian(int maThoiGian) {
		MaThoiGian = maThoiGian;
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