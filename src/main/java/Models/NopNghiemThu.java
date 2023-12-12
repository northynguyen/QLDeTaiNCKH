package Models;

import java.sql.Date;
import java.sql.Timestamp;

public class NopNghiemThu {
	private int MaNopDeTai;
	private int MaDeTai;
	private byte[] FileBaoCao;
	private int MaThoiGian;
	private int MaNghiemThu;
	private Date NgayNghiemThu;
	private byte[] HoSoLienQuan;
	private int DiemSo;
	private String GhiChu;
	public NopNghiemThu(int maNopDeTai, int maDeTai, byte[] fileBaoCao, int maThoiGian, int maNghiemThu,
			Date ngayNghiemThu, byte[] hoSoLienQuan, int diemSo, String ghiChu) {
		super();
		MaNopDeTai = maNopDeTai;
		MaDeTai = maDeTai;
		FileBaoCao = fileBaoCao;
		MaThoiGian = maThoiGian;
		MaNghiemThu = maNghiemThu;
		NgayNghiemThu = ngayNghiemThu;
		HoSoLienQuan = hoSoLienQuan;
		DiemSo = diemSo;
		GhiChu = ghiChu;
	}
	public NopNghiemThu() {
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
	public byte[] getFileBaoCao() {
		return FileBaoCao;
	}
	public void setFileBaoCao(byte[] fileBaoCao) {
		FileBaoCao = fileBaoCao;
	}
	public int getMaThoiGian() {
		return MaThoiGian;
	}
	public void setMaThoiGian(int maThoiGian) {
		MaThoiGian = maThoiGian;
	}
	public int getMaNghiemThu() {
		return MaNghiemThu;
	}
	public void setMaNghiemThu(int maNghiemThu) {
		MaNghiemThu = maNghiemThu;
	}
	public Date getNgayNghiemThu() {
		return NgayNghiemThu;
	}
	public void setNgayNghiemThu(Date ngayNghiemThu) {
		NgayNghiemThu = ngayNghiemThu;
	}
	public byte[] getHoSoLienQuan() {
		return HoSoLienQuan;
	}
	public void setHoSoLienQuan(byte[] hoSoLienQuan) {
		HoSoLienQuan = hoSoLienQuan;
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
	
	

}
