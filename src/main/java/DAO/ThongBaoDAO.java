package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Models.ThongBao;
import Models.ThongTinTaiKhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThongBaoDAO {
	private static final String LAY_THONG_BAO = "select * from ThongBao where MaNguoiNhan = ?";
	private static final String LAY_NGUOI_NHAN = "select * from ThongTinTaiKhoan where ROLE = N'Chủ Nhiệm'";
	private static final String TAO_THONG_BAO = "insert into `qldetainckh`.`thongbao` (`TenThongBao`, `NgayThongBao`, `MaNguoiNhan`, `MaNguoiGui`, `NoiDung`) VALUES (N?, ?, ?, ?, N?);";
	        
	
	public void TaoThongBao(String TenThongBao, Date NgayThongBao, String MaNguoiNhan, String MaNguoiGui, String NoiDung) {
		try (Connection connection = JDBCUtil.getConnection();
			     PreparedStatement preparedStatement = connection.prepareStatement(TAO_THONG_BAO);) {
			     preparedStatement.setString(1, TenThongBao);
			     preparedStatement.setDate(2, NgayThongBao);
			     preparedStatement.setString(3, MaNguoiNhan);
			     preparedStatement.setString(4, MaNguoiGui);
			     preparedStatement.setString(5, NoiDung);
			     System.out.println(preparedStatement);
			     preparedStatement.executeUpdate();		    
		     } catch (SQLException exception) {
		         HandleExeption.printSQLException(exception);
		     }
	}
	
	
	public List<ThongBao> LayThongBao(String MaNguoiNhan) {
	    List < ThongBao > ListthongBao = new ArrayList < > ();        
	    try (Connection connection = JDBCUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_THONG_BAO);) {
		     preparedStatement.setString(1, MaNguoiNhan);
		     ResultSet rs = preparedStatement.executeQuery();
		
		     while (rs.next()) {               
		    	 ThongBao thongbao = new ThongBao();
		    	 thongbao.setMaThongBao(rs.getInt(1));
		    	 thongbao.setTenThongBao(rs.getString(2));
		    	 thongbao.setNgayThongBao(rs.getDate(3));
		    	 thongbao.setMaNguoiNhan(rs.getString(4));
		    	 thongbao.setMaNguoiGui(rs.getString(5));
		    	 thongbao.setNoiDung(rs.getString(6));
		         ListthongBao.add(thongbao);
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
     return ListthongBao;
 }
	
	public List<ThongTinTaiKhoan> LayNguoiNhan() {
	    List < ThongTinTaiKhoan > ListThongTinNguoiNhan = new ArrayList < > ();        
	    try (Connection connection = JDBCUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_NGUOI_NHAN);) {
		     ResultSet rs = preparedStatement.executeQuery();
		
		     while (rs.next()) {               
		    	 ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan();
		    	 thongTinTaiKhoan.setMaTaiKhoan(rs.getString(1));
	        	   thongTinTaiKhoan.setRole(rs.getString(3));
	        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
	        	   thongTinTaiKhoan.setRole(rs.getString(3));
	        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
	        	   thongTinTaiKhoan.setGioiTinh(rs.getString(5));
	        	   thongTinTaiKhoan.setMaKhoa(rs.getString(6));
	        	   thongTinTaiKhoan.setSDT(rs.getString(7));
	        	   thongTinTaiKhoan.setEmail(rs.getString(8));
	        	   thongTinTaiKhoan.setDiaChi(rs.getString(9));
	        	   ListThongTinNguoiNhan.add(thongTinTaiKhoan);
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
     return ListThongTinNguoiNhan;
 }
}
