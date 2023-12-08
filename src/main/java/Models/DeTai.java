package Models;

public class DeTai {
	private int MaDeTai;
	private String TenDeTai;
	private int KinhPhi;
	private byte[] FileMoTaDeTai;
	private String TrangThai;
	public DeTai(int maDeTai, String tenDeTai, int kinhPhi, byte[] fileMoTaDeTai, String trangThai) {
		super();
		MaDeTai = maDeTai;
		TenDeTai = tenDeTai;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		TrangThai = trangThai;
	}
	public DeTai() {
		super();
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}
	public DeTai(String tenDeTai, int kinhPhi, byte[] fileMoTaDeTai, String trangThai) {
		super();
		TenDeTai = tenDeTai;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
		TrangThai = trangThai;
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
	
}
