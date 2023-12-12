package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Khoa;
import Util.HandleExeption;
import Util.JDBCUtil;
import Models.ThoiGianNCKH;

public class ThoiGianNCKHDAO {
	private static final String LAY_THOI_GIAN = "SELECT * FROM qldetainckh.thoigiannckh";
	private static final String TAO_THONG_TIN_TAI_KHOAN = "INSERT INTO `qldetainckh`.`thongtintaikhoan` (`MaTK`, `MatKhau`, `Role`, `HoTen`, `GioiTinh`, `MaKhoa`, `SDT`, `Email`, `DiaChi`) \r\n"
			+ "VALUES (?, ?, N?, N?, N?, N?, ?, ?, N?);";
	private static final String LAY_THOI_GIAN_BANG_MA = "SELECT * FROM qldetainckh.thoigiannckh where MaThoiGianNCKH = ?";
	private static final String TAO_THOI_GIAN = "INSERT INTO `qldetainckh`.`thoigiannckh` (`NgayMoDK`, `NgayKetThucDK`, `NgayNopDeTai`)"
			+ "VALUES (?, ?, ?);";
	private static final String TAO_KHOA = "INSERT INTO `qldetainckh`.`khoa` (`MaKhoa`, `TenKhoa`) VALUES (?, N?)";
	private static final String XOA_KHOA = "DELETE FROM `qldetainckh`.`khoa` WHERE (`MaKhoa` = ?);";
	private static final String SUA_KHOA = "UPDATE `qldetainckh`.`khoa` SET `TenKhoa` = N? WHERE (`MaKhoa` = ?);";
	private static final String XOA_THOI_GIAN = "DELETE FROM `qldetainckh`.`thoigiannckh` WHERE (`MaThoiGianNCKH` = ?);";
	private static final String SUA_THOI_GIAN  = "UPDATE `qldetainckh`.`thoigiannckh` "
			+ "SET `NgayMoDK` = ?, `NgayKetThucDK` = ?, `NgayNopDeTai` = ? "
			+ "WHERE (`MaThoiGianNCKH` = ?);";
	private static final String CAP_NHAT_TRANG_THAI_DE_TAI  = "UPDATE qldetainckh.detai\r\n"
			+ "	SET TrangThai = N?\r\n"
			+ "	WHERE MaDeTai > 0";
	
	
	public ThoiGianNCKH LayThoiGianDK(int MaThoiGian) {
		ThoiGianNCKH thoigian = new ThoiGianNCKH();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN_BANG_MA);) {
			preparedStatement.setInt(1, MaThoiGian);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				thoigian.setMaThoiGianNCKH(rs.getInt(1));
				thoigian.setNgayMoDK(rs.getDate(2));
				thoigian.setNgayKetThucDK(rs.getDate(3));
				thoigian.setNgayNopDeTai(rs.getDate(4));
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return thoigian;
	}

	public ThoiGianNCKH LayThoiGianHienTai() {
		ThoiGianNCKH thoigian = new ThoiGianNCKH();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			java.util.Date curDay = new java.util.Date();
			Date NgayHienTai = new Date(curDay.getTime());
			while (rs.next()) {
				if (NgayHienTai.after(rs.getDate(2)) && NgayHienTai.before(rs.getDate(4))) {
					thoigian.setMaThoiGianNCKH(rs.getInt(1));
					thoigian.setNgayMoDK(rs.getDate(2));
					thoigian.setNgayKetThucDK(rs.getDate(3));
					thoigian.setNgayNopDeTai(rs.getDate(4));
				}
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return thoigian;
	}
	public boolean CapNhatTrangThaiDeTai(String TrangThai) {
		boolean rowUpdate=false;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT_TRANG_THAI_DE_TAI);) {
			preparedStatement.setString(1, TrangThai);
			rowUpdate = preparedStatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return rowUpdate;
	}
	public boolean SoSanhNgayMo() {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			java.util.Date curDay = new java.util.Date();
			Date NgayHienTai = new Date(curDay.getTime());
			while (rs.next()) {
				if (NgayHienTai.after(rs.getDate(2)) && NgayHienTai.before(rs.getDate(3))) {
					return true;
				}
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return false;
	}
	public boolean SoSanhNgayDong() {
		boolean check = true;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			java.util.Date curDay = new java.util.Date();
			Date NgayHienTai = new Date(curDay.getTime());
			while (rs.next()) {
				if (NgayHienTai.after(rs.getDate(2)) && NgayHienTai.before(rs.getDate(3))) {
					check = false;
				}
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return check;
	}
	
	public List<ThoiGianNCKH> LayToanBoThoiGian() {
		List<ThoiGianNCKH> listthoigian = new ArrayList<>();	
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ThoiGianNCKH thoigian = new ThoiGianNCKH();
				thoigian.setMaThoiGianNCKH(rs.getInt(1));
				thoigian.setNgayMoDK(rs.getDate(2));
				thoigian.setNgayKetThucDK(rs.getDate(3));
				thoigian.setNgayNopDeTai(rs.getDate(4));
				listthoigian.add(thoigian);
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return listthoigian;
	}
	
	public boolean TaoKhoa(String MaKhoa, String TenKhoa)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(TAO_KHOA);
        	preparedStatement.setString(1, MaKhoa);
        	preparedStatement.setString(2, TenKhoa);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public boolean SuaKhoa(String MaKhoa, String TenKhoa)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(SUA_KHOA);
        	preparedStatement.setString(1, TenKhoa);
        	preparedStatement.setString(2, MaKhoa);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public boolean XoaKhoa(String MaKhoa)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(XOA_KHOA);
        	preparedStatement.setString(1, MaKhoa);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	
	public boolean XoaThoiGian(String MaThoiGian)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(XOA_THOI_GIAN);
        	preparedStatement.setString(1, MaThoiGian);
        	System.out.print(preparedStatement);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public boolean SuaThoiGian(String MaThoiGian, Date NgayMoDK, Date NgayKetThucDK, Date NgayNopDeTai)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(SUA_THOI_GIAN);
        	preparedStatement.setDate(1, NgayMoDK);
        	preparedStatement.setDate(2, NgayKetThucDK);
        	preparedStatement.setDate(3, NgayNopDeTai);
        	preparedStatement.setString(4, MaThoiGian);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	
	public boolean TaoThoiGian(Date NgayMoDK, Date NgayKetThucDK, Date NgayNopDeTai)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(TAO_THOI_GIAN);
        	preparedStatement.setDate(1, NgayMoDK);
        	preparedStatement.setDate(2, NgayKetThucDK);
        	preparedStatement.setDate(3, NgayNopDeTai);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public ThoiGianNCKH LayThoiGian() {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			java.util.Date curDay = new java.util.Date();
	        Date NgayHienTai = new Date(curDay.getTime());
			while (rs.next()) {    
				 if (NgayHienTai.after(rs.getDate(2)) && NgayHienTai.before(rs.getDate(3))) {
					 ThoiGianNCKH thoiGian = new ThoiGianNCKH(rs.getInt(1));
					 return thoiGian;

				 }
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
		return null;
	}
	
}
