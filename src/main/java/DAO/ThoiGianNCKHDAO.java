package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.ThoiGianNCKH;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThoiGianNCKHDAO {
	//private static final String SELECT_ALL_ThoiGianNCKH = "select * from qldetainckh.thoigiannckh";
	private static final String LAY_THOI_GIAN = "SELECT * FROM qldetainckh.thoigiannckh";
	private static final String TAO_THONG_TIN_TAI_KHOAN = "INSERT INTO `qldetainckh`.`thongtintaikhoan` (`MaTK`, `MatKhau`, `Role`, `HoTen`, `GioiTinh`, `MaKhoa`, `SDT`, `Email`, `DiaChi`) \r\n"
			+ "VALUES (?, ?, N?, N?, N?, N?, ?, ?, N?);";
	private static final String LAY_THOI_GIAN_BANG_MA = "SELECT * FROM qldetainckh.thoigiannckh where MaThoiGianNCKH = ?";
	public ThoiGianNCKH LayThoiGianDK (int MaThoiGian) {
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
	public ThoiGianNCKH LayThoiGian() {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LAY_THOI_GIAN);) {
			ResultSet rs = preparedStatement.executeQuery();
			java.util.Date curDay = new java.util.Date();
	        Date NgayHienTai = new Date(curDay.getTime());
			while (rs.next()) {    
				 if (NgayHienTai.after(rs.getDate(2)) && NgayHienTai.before(rs.getDate(3))) {
					 ThoiGianNCKH thoiGian = new ThoiGianNCKH();
					 return thoiGian;
				 }
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
		return null;
	}
}
