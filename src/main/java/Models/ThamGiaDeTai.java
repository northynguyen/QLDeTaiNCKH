package Models;

public class ThamGiaDeTai {
	private int MaThamGiaDeTai;
	private int MaDeTai;
	private String MSSV;
	private String TenSinhVien;
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
	
	public ThamGiaDeTai(int maDeTai, String mSSV, String vaiTro, int maThoiGianNCKH) {
		super();
		MaDeTai = maDeTai;
		MSSV = mSSV;
		VaiTro = vaiTro;
		MaThoiGianNCKH = maThoiGianNCKH;
	}
	public ThamGiaDeTai(String mSSV, String tenSinhVien) {
		super();
		MSSV = mSSV;
		TenSinhVien = tenSinhVien;
	}
	public ThamGiaDeTai(String mSSV, String tenSinhVien, String vaiTro) {
		super();
		MSSV = mSSV;
		TenSinhVien = tenSinhVien;
		VaiTro = vaiTro;
	}
	public int getMaThamGiaDeTai() {
		return MaThamGiaDeTai;
	}
	public String getTenSinhVien() {
		return TenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		TenSinhVien = tenSinhVien;
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