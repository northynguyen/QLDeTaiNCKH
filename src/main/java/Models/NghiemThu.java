package Models;

import java.sql.Date;

public class NghiemThu {
	private int MaNghiemThu;
	private int MaDeTai;
	private String MaNguoiNghiemThu;
	private Date NgayNghiemThu;
	private byte[] TaiLieuNghiemThu;
	private byte[] FileBaoCao;
	private int DiemSo;
	private String GhiChu;
	public int getMaNghiemThu() {
		return MaNghiemThu;
	}
	public void setMaNghiemThu(int maNghiemThu) {
		MaNghiemThu = maNghiemThu;
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
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
	public byte[] getFileBaoCao() {
		return FileBaoCao;
	}
	public void setFileBaoCao(byte[] fileBaoCao) {
		FileBaoCao = fileBaoCao;
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
	public NghiemThu(int maNghiemThu, int maDeTai, String maNguoiNghiemThu, Date ngayNghiemThu, byte[] taiLieuNghiemThu,
			byte[] fileBaoCao, int diemSo, String ghiChu) {
		super();
		MaNghiemThu = maNghiemThu;
		MaDeTai = maDeTai;
		MaNguoiNghiemThu = maNguoiNghiemThu;
		NgayNghiemThu = ngayNghiemThu;
		TaiLieuNghiemThu = taiLieuNghiemThu;
		FileBaoCao = fileBaoCao;
		DiemSo = diemSo;
		GhiChu = ghiChu;
	}
}
