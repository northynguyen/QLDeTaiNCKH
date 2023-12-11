package Models;

public class Duyet {
	private int MaDon;
	private String TenDeTai;
	private String TenChuNhiem;
	private int KinhPhi;
	private byte[] FileMoTaDeTai;
	public Duyet() {
		super();
	}
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public String getTenChuNhiem() {
		return TenChuNhiem;
	}
	public void setTenChuNhiem(String tenChuNhiem) {
		TenChuNhiem = tenChuNhiem;
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
	public int getMaDon() {
		return MaDon;
	}
	public void setMaDon(int maDon) {
		MaDon = maDon;
	}
	public Duyet(int maDon, String tenDeTai, String tenChuNhiem, int kinhPhi, byte[] fileMoTaDeTai) {
		super();
		MaDon = maDon;
		TenDeTai = tenDeTai;
		TenChuNhiem = tenChuNhiem;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
	}

}
