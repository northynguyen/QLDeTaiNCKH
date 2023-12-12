package Models;

import java.sql.Date;

public class NghiemThu {
	private int MaNghiemThu;
	private int MaNopDeTai;
	private String MaNguoiNghiemThu;
	private Date NgayNghiemThu;
	private byte[] TaiLieuNghiemThu;
	private int DiemSo;
	private String GhiChu;

	public int getMaNghiemThu() {
		return MaNghiemThu;
	}

	public void setMaNghiemThu(int maNghiemThu) {
		MaNghiemThu = maNghiemThu;
	}

	public int getMaNopDeTai() {
		return MaNopDeTai;
	}

	public void setMaNopDeTai(int maNopDeTai) {
		MaNopDeTai = maNopDeTai;
	}

	public String getMaNguoiNghiemThu() {
		return MaNguoiNghiemThu;
	}

	public void setMaNguoiNghiemThu(String maNguoiNghiemThu) {
		MaNguoiNghiemThu = maNguoiNghiemThu;
	}

	public Date getNgayNghiemThu() {
		return NgayNghiemThu;
	}

	public void setNgayNghiemThu(Date ngayNghiemThu) {
		NgayNghiemThu = ngayNghiemThu;
	}

	public byte[] getTaiLieuNghiemThu() {
		return TaiLieuNghiemThu;
	}

	public void setTaiLieuNghiemThu(byte[] taiLieuNghiemThu) {
		TaiLieuNghiemThu = taiLieuNghiemThu;
	}

	public int getDiemSo() {
		return DiemSo;
	}

	public void setDiemSo(int diemSo) {
		DiemSo = diemSo;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public NghiemThu() {
		super();
	}

	public NghiemThu(int maNghiemThu, int maNopDeTai, String maNguoiNghiemThu, Date ngayNghiemThu,
			byte[] taiLieuNghiemThu, int diemSo, String ghiChu) {
		super();
		MaNghiemThu = maNghiemThu;
		MaNopDeTai = maNopDeTai;
		MaNguoiNghiemThu = maNguoiNghiemThu;
		NgayNghiemThu = ngayNghiemThu;
		TaiLieuNghiemThu = taiLieuNghiemThu;
		DiemSo = diemSo;
		GhiChu = ghiChu;
	}
}
