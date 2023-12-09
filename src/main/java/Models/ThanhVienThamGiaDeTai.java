package Models;

public class ThanhVienThamGiaDeTai {
	private String HoTen;
	private String MSSV;
	private String VaiTro;
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
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
	public ThanhVienThamGiaDeTai(String hoTen, String mSSV, String vaiTro) {
		super();
		HoTen = hoTen;
		MSSV = mSSV;
		VaiTro = vaiTro;
	}
}
