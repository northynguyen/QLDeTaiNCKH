package Models;

import java.sql.Timestamp;

public class NopDeTai {
	private int MaNopDeTai;
	private int MaDeTai;
	private String MaNguoiNop;
	private byte[] FileBaoCao;
	private Timestamp ThoiGianNop;
	private int MaThoiGian;
	private String GhiChu;
	private String TrangThai;
	public NopDeTai(int maNopDeTai, int maDeTai, String maNguoiNop, byte[] fileBaoCao, Timestamp thoiGianNop,
			int maThoiGian, String ghiChu, String trangThai) {
		super();
		MaNopDeTai = maNopDeTai;
		MaDeTai = maDeTai;
		MaNguoiNop = maNguoiNop;
		FileBaoCao = fileBaoCao;
		ThoiGianNop = thoiGianNop;
		MaThoiGian = maThoiGian;
		GhiChu = ghiChu;
		TrangThai = trangThai;
	}
	public NopDeTai() {
		super();
	}
	public int getMaNopDeTai() {
		return MaNopDeTai;
	}
	public void setMaNopDeTai(int maNopDeTai) {
		MaNopDeTai = maNopDeTai;
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getMaNguoiNop() {
		return MaNguoiNop;
	}
	public void setMaNguoiNop(String maNguoiNop) {
		MaNguoiNop = maNguoiNop;
	}
	public byte[] getFileBaoCao() {
		return FileBaoCao;
	}
	public void setFileBaoCao(byte[] fileBaoCao) {
		FileBaoCao = fileBaoCao;
	}
	public Timestamp getThoiGianNop() {
		return ThoiGianNop;
	}
	public void setThoiGianNop(Timestamp thoiGianNop) {
		ThoiGianNop = thoiGianNop;
	}
	public int getMaThoiGian() {
		return MaThoiGian;
	}
	public void setMaThoiGian(int maThoiGian) {
		MaThoiGian = maThoiGian;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	
}
