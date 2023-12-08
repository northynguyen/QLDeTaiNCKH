package Models;

public class DuyetDeTai {
	private String TenDeTai;
	private String TenChuNhiem;
	private int KinhPhi;
	private byte[] FileMoTaDeTai;
	public DuyetDeTai(String tenDeTai, String tenChuNhiem, int kinhPhi, byte[] fileMoTaDeTai) {
		super();
		TenDeTai = tenDeTai;
		TenChuNhiem = tenChuNhiem;
		KinhPhi = kinhPhi;
		FileMoTaDeTai = fileMoTaDeTai;
	}
	public DuyetDeTai() {
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

}
