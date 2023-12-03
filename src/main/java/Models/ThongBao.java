package Models;
import java.sql.Date;

public class ThongBao {
	private int MaThongBao;
	private String TenThongBao;
	private Date NgayThongBao;
	private String MaNguoiNhan;
	private String MaNguoiGui;
	private String NoiDung;
	public ThongBao(int maThongBao, String tenThongBao, Date ngayThongBao, String maNguoiNhan, String maNguoiGui,
			String noiDung) {
		super();
		MaThongBao = maThongBao;
		TenThongBao = tenThongBao;
		NgayThongBao = ngayThongBao;
		MaNguoiNhan = maNguoiNhan;
		MaNguoiGui = maNguoiGui;
		NoiDung = noiDung;
	}
	public int getMaThongBao() {
		return MaThongBao;
	}
	public void setMaThongBao(int maThongBao) {
		MaThongBao = maThongBao;
	}
	public String getTenThongBao() {
		return TenThongBao;
	}
	public void setTenThongBao(String tenThongBao) {
		TenThongBao = tenThongBao;
	}
	public Date getNgayThongBao() {
		return NgayThongBao;
	}
	public void setNgayThongBao(Date ngayThongBao) {
		NgayThongBao = ngayThongBao;
	}
	public String getMaNguoiNhan() {
		return MaNguoiNhan;
	}
	public void setMaNguoiNhan(String maNguoiNhan) {
		MaNguoiNhan = maNguoiNhan;
	}
	public String getMaNguoiGui() {
		return MaNguoiGui;
	}
	public void setMaNguoiGui(String maNguoiGui) {
		MaNguoiGui = maNguoiGui;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public ThongBao() {
		super();
	}
	
	
}
