package Models;

import java.sql.Date;

public class LayDK_CN {
	private int MaDon;
	private int MaDeTai;
	private String TenDeTai;
	private Date Ngayduyet;
	private int KinhPhi;
	private byte[] FileMoTa;
	private String TrangThai;
	
	public LayDK_CN(int maDon, int maDeTai, String tenDeTai, Date ngayduyet, int kinhPhi, byte[] fileMoTa,
			String trangThai) {
		super();
		MaDon = maDon;
		MaDeTai = maDeTai;
		TenDeTai = tenDeTai;
		Ngayduyet = ngayduyet;
		KinhPhi = kinhPhi;
		FileMoTa = fileMoTa;
		TrangThai = trangThai;
	}
	public LayDK_CN() {
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
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public Date getNgayduyet() {
		return Ngayduyet;
	}
	public void setNgayduyet(Date ngayduyet) {
		Ngayduyet = ngayduyet;
	}
	public int getKinhPhi() {
		return KinhPhi;
	}
	public void setKinhPhi(int kinhPhi) {
		KinhPhi = kinhPhi;
	}
	public byte[] getFileMoTa() {
		return FileMoTa;
	}
	public void setFileMoTa(byte[] fileMoTa) {
		FileMoTa = fileMoTa;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}



}
