package Models;

public class ThamGiaDeTai {
	private int MaThamGiaDeTai;
	private int MaDeTai;
	private String MSSV;
	private String VaiTro;
	private int MaThoiGianNCKH;
	public ThamGiaDeTai(int maThamGiaDeTai, int maDeTai, String mSSV, String vaiTro, int maThoiGianNCKH) {
		super();
		MaThamGiaDeTai = maThamGiaDeTai;
		MaDeTai = maDeTai;
		MSSV = mSSV;
		VaiTro = vaiTro;
		MaThoiGianNCKH = maThoiGianNCKH;
	}
	public ThamGiaDeTai() {
		super();
	}
	public int getMaThamGiaDeTai() {
		return MaThamGiaDeTai;
	}
	public void setMaThamGiaDeTai(int maThamGiaDeTai) {
		MaThamGiaDeTai = maThamGiaDeTai;
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getVaiTro() {
		return VaiTro;
	}
	public void setVaiTro(String vaiTro) {
		VaiTro = vaiTro;
	}
	public int getMaThoiGianNCKH() {
		return MaThoiGianNCKH;
	}
	public void setMaThoiGianNCKH(int maThoiGianNCKH) {
		MaThoiGianNCKH = maThoiGianNCKH;
	}
	
}
