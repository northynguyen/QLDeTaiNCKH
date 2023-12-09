package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKyDeTai;
import Models.DeTai;
import Models.ThamGiaDeTai;
import Models.ThanhVienThamGiaDeTai;
import Models.ThongTinTaiKhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeTaiDaDangKyDAO {
	private static final String DE_TAI_DA_DK = "SELECT * FROM nckh.dangkydetai where TrangThai='Đã duyệt';\r\n" + "";
	private static final String DE_TAI_BY_MADT = "SELECT * FROM nckh.detai WHERE MaDeTai=?";
	private static final String CHU_NHIEM_BY_MACN = "SELECT * FROM nckh.thongtintaikhoan WHERE Role='Chủ nhiệm' and MaTK=?";
private static final String THANH_VIEN_NC_BY_MADTMATG = "SELECT  B.HoTen , A.VaiTro,A.MSSV FROM nckh.thamgiadetai A inner JOIN nckh.thongtinsinhvien B on A.MSSV=B.MSSV \r\n"
		+ "where MaDeTai=? and MaThoiGian=?";

	private static final String DE_TAI_DA_DK_BY_MADON = "SELECT * FROM nckh.dangkydetai where TrangThai='Đã duyệt' and MaDon=?;\r\n"
			+ "";

	public List<DangKyDeTai> XemDeTaiDaDK() throws SQLException {
		List<DangKyDeTai> ddk = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(DE_TAI_DA_DK);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int maDon = rs.getInt(1);
				int maDeTai = rs.getInt(2);
				String maChuNhiem = rs.getString(3);
				Date ngayDuyet = rs.getDate(4);
				String maNguoiDuyet = rs.getString(5);
				byte[] fileQuyetDinh = rs.getBytes(6);
				int maThoiGian = rs.getInt(7);
				String trangThai = rs.getString(8);
				String ghiChu = rs.getString(9);
				ddk.add(new DangKyDeTai(maDon, maDeTai, maChuNhiem, ngayDuyet, maNguoiDuyet, fileQuyetDinh, maThoiGian,
						trangThai, ghiChu));

			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return ddk;
	}

	public DeTai LayDeTai_MaDT(int maDT) throws SQLException {
		DeTai dt = null;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(DE_TAI_BY_MADT);) {
			preparedStatement.setInt(1, maDT);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int MaDeTai = rs.getInt(1);
				String TenDeTai = rs.getString(2);
				int KinhPhi = rs.getInt(3);
				byte[] FileMoTaDeTai = rs.getBytes(4);
				String TrangThai = "Đã đăng ký";

				dt = new DeTai(MaDeTai, TenDeTai, KinhPhi, FileMoTaDeTai, TrangThai);
			}
		} catch (

		SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return dt;
	}

	public List<ThanhVienThamGiaDeTai> LayThanhVien_MaDT_MaTG(int maDT, int maTG) throws SQLException {
		List<ThanhVienThamGiaDeTai> tg = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(THANH_VIEN_NC_BY_MADTMATG);) {
			preparedStatement.setInt(1, maDT);
			preparedStatement.setInt(2, maTG);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				String Hoten = rs.getString(1);
				String VaiTro = rs.getString(2);
				String MSSV = rs.getString(3);
			
				tg.add(new ThanhVienThamGiaDeTai(Hoten, MSSV,VaiTro));
			}
		} catch (

		SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return tg;
	}
	public ThongTinTaiKhoan LayChuNhiem_MaCN(String maCN) throws SQLException {
		ThongTinTaiKhoan cn = null;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(CHU_NHIEM_BY_MACN);) {
			preparedStatement.setString(1, maCN);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int MaTaiKhoan = rs.getInt(1);
				String MatKhau = rs.getString(2);
				String Role = rs.getString(3);
				String HoTen = rs.getString(4);
				String GioiTinh = rs.getString(5);
				String MaKhoa = rs.getString(6);
				String SDT = rs.getString(7);
				String Email = rs.getString(8);
				String DiaChi = rs.getString(9);

				cn = new ThongTinTaiKhoan(MaTaiKhoan, MatKhau, Role, HoTen, GioiTinh, MaKhoa, SDT, Email, DiaChi);
			}
		} catch (

		SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return cn;
	}

	public DangKyDeTai LayDeTaiDaDK(String madon) throws SQLException {
		DangKyDeTai ddk = null;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(DE_TAI_DA_DK_BY_MADON);) {
			preparedStatement.setString(1, madon);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int maDon = rs.getInt(1);
				int maDeTai = rs.getInt(2);
				String maChuNhiem = rs.getString(3);
				Date ngayDuyet = rs.getDate(4);
				String maNguoiDuyet = rs.getString(5);
				byte[] fileQuyetDinh = rs.getBytes(6);
				int maThoiGian = rs.getInt(7);
				String trangThai = rs.getString(8);
				String ghiChu = rs.getString(9);
				ddk = new DangKyDeTai(maDon, maDeTai, maChuNhiem, ngayDuyet, maNguoiDuyet, fileQuyetDinh, maThoiGian,
						trangThai, ghiChu);
			}
		} catch (SQLException e) {
			HandleExeption.printSQLException(e);
		}
		return ddk;
	}
}
