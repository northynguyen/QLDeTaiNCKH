package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.NghiemThu;
import Models.NopDeTai;
import Models.ThamGiaDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class NghiemThuDAO {
	private static final String SHOW_ALL_NOPDT = "SELECT * FROM qldetainckh.nopdetai";
	private static final String NOP_FILE_NGHIEMTHU = "INSERT INTO `qldetainckh`.`nghiemthu` (`MaNopDeTai`, `MaNguoiNghiemThu`, `NgayNghiemThu`, `HoSoLienQuan`, `DiemSo`, `GhiChu`) VALUES (?, ?, ?, ?, ?, ?);"
			+ "";
	private static final String EDIT_FILE_NGHIEMTHU = "UPDATE `qldetainckh`.`nghiemthu` SET `MaNopDeTai` = ?, `MaNguoiNghiemThu` = ?,`NgayNghiemThu` = ?, `HoSoLienQuan` = ?, `DiemSo` = ?, `GhiChu` = ? WHERE (`MaNghiemThu` = ?);\r\n"
			+ "";
	private static final String LAY_NGHIEMTHU_BY_MNDT = "SELECT * FROM qldetainckh.nghiemthu WHERE MaNopDeTai=?;";
	private static final String LAY_NOPDETAI_BY_MNDT = "SELECT * FROM qldetainckh.nopdetai WHERE MaNopDeTai=?";
	private static final String CAP_NHAP_TRANG_THAI_NOP = "UPDATE `qldetainckh`.`nopdetai` SET `TrangThai` = 'Đã nghiệm thu' WHERE (`MaNopDeTai` = ?);\r\n"
			+ "";

	public List<NopDeTai> ShowAllNopDT() throws SQLException {
		List<NopDeTai> all = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(SHOW_ALL_NOPDT);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int maNopDeTai = rs.getInt("MaNopDeTai");
				int maDeTai = rs.getInt("MaDeTai");
				String maNguoiNop = rs.getString("MaNguoiNop");
				byte[] fileBaoCao = rs.getBytes("FileBaoCao");
				Timestamp thoiGianNop = rs.getTimestamp("ThoiGianNop");
				int maThoiGian = rs.getInt("MaThoiGian");
				String ghiChu = rs.getString("GhiChu");
				String trangThai = rs.getString("TrangThai");
				all.add(new NopDeTai(maNopDeTai, maDeTai, maNguoiNop, fileBaoCao, thoiGianNop, maThoiGian, ghiChu,
						trangThai));
				
			}
			conn.close();
		}
		return all;
	}
	public NghiemThu LayNhiemThu_MNDT(String MaNopDeTai) throws SQLException {
		NghiemThu nt = new NghiemThu();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(LAY_NGHIEMTHU_BY_MNDT);) {
			statement.setString(1, MaNopDeTai);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int maNghiemThu = rs.getInt("MaNghiemThu");
				int maNopDeTai = rs.getInt("MaNopDeTai");
				String maNguoiNghiemThu = rs.getString("MaNguoiNghiemThu");
				Date ngayNghiemThu = rs.getDate("NgayNghiemThu");
				byte[] taiLieuNghiemThu = rs.getBytes("HoSoLienQuan");
				int diemSo = rs.getInt("DiemSo");
				String ghiChu = rs.getString("GhiChu");

				nt=new NghiemThu(maNghiemThu,maNopDeTai,maNguoiNghiemThu,ngayNghiemThu,taiLieuNghiemThu,diemSo,ghiChu);
					
				
			}
			conn.close();
		}
		return nt;
	}
	public NopDeTai LayNopDeTai_MNDT(String MaNopDeTai) throws SQLException {
		NopDeTai ndt = new NopDeTai();
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(LAY_NOPDETAI_BY_MNDT);) {
			statement.setString(1, MaNopDeTai);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int maNopDeTai = rs.getInt("MaNopDeTai");
				int maDeTai = rs.getInt("MaDeTai");
				String maNguoiNop = rs.getString("MaNguoiNop");
				byte[] fileBaoCao = rs.getBytes("FileBaoCao");
				Timestamp thoiGianNop = rs.getTimestamp("ThoiGianNop");
				int maThoiGian = rs.getInt("MaThoiGian");
				String ghiChu = rs.getString("GhiChu");
				String trangThai = rs.getString("TrangThai");
				ndt= new NopDeTai(maNopDeTai, maDeTai, maNguoiNop, fileBaoCao, thoiGianNop, maThoiGian, ghiChu,
						trangThai);
				
			}
			conn.close();
		}
		return ndt;
	}
	public boolean ThemNghiemThu(int maNopDeTai, String maNguoiNghiemThu, String formattedDate,
			byte[] taiLieuNghiemThu, String diem, String ghiChu) throws SQLException {
		boolean rowUpdate=false;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(NOP_FILE_NGHIEMTHU);) {
			statement.setInt(1, maNopDeTai);
			statement.setString(2, maNguoiNghiemThu);
			statement.setString(3, formattedDate);
			statement.setBytes(4, taiLieuNghiemThu);
			statement.setString(5, diem);
			statement.setString(6, ghiChu);
			rowUpdate = statement.executeUpdate() > 0;
			conn.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}	
	public boolean EditNghiemThu(int maNghiemThu,int maNopDeTai, String maNguoiNghiemThu, String NgayNghiemThu,
			byte[] taiLieuNghiemThu, String diem, String ghiChu) throws SQLException {
		boolean rowUpdate=false;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(EDIT_FILE_NGHIEMTHU);) {
			statement.setInt(1, maNopDeTai);
			statement.setString(2, maNguoiNghiemThu);
			statement.setString(3, NgayNghiemThu);
			statement.setBytes(4, taiLieuNghiemThu);
			statement.setString(5, diem);
			statement.setString(6, ghiChu);
			statement.setInt(7, maNghiemThu);
			
			rowUpdate = statement.executeUpdate() > 0;
			conn.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public boolean CapNhapNghiemThu_NOP(int maNop) throws SQLException {
		boolean rowUpdate=false;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(CAP_NHAP_TRANG_THAI_NOP);) {
			statement.setInt(1, maNop);
			System.out.print(statement);
			rowUpdate = statement.executeUpdate() > 0;
			conn.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
}
