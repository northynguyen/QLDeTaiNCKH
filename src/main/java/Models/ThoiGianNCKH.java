package Models;

import java.sql.Date;

public class ThoiGianNCKH {
	private int MaThoiGianNCKH;
	private Date NgayMoDK;
	private Date NgayKetThucDK;
	private Date NgayNopDeTai;
	public ThoiGianNCKH(int maThoiGianNCKH, Date ngayMoDK, Date ngayKetThucDK, Date ngayNopDeTai) {
		super();
		MaThoiGianNCKH = maThoiGianNCKH;
		NgayMoDK = ngayMoDK;
		NgayKetThucDK = ngayKetThucDK;
		NgayNopDeTai = ngayNopDeTai;
	}
	public ThoiGianNCKH() {
		super();
	}
	public int getMaThoiGianNCKH() {
		return MaThoiGianNCKH;
	}
	public void setMaThoiGianNCKH(int maThoiGianNCKH) {
		MaThoiGianNCKH = maThoiGianNCKH;
	}
	public Date getNgayMoDK() {
		return NgayMoDK;
	}
	public void setNgayMoDK(Date ngayMoDK) {
		NgayMoDK = ngayMoDK;
	}
	public Date getNgayKetThucDK() {
		return NgayKetThucDK;
	}
	public void setNgayKetThucDK(Date ngayKetThucDK) {
		NgayKetThucDK = ngayKetThucDK;
	}
	public Date getNgayNopDeTai() {
		return NgayNopDeTai;
	}
	public void setNgayNopDeTai(Date ngayNopDeTai) {
		NgayNopDeTai = ngayNopDeTai;
	}
	
}
