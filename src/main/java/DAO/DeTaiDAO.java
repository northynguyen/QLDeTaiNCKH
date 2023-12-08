package DAO;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Models.DangKyDeTai;
import Models.DeTai;
import Models.Khoa;
import Models.NopDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeTaiDAO {
	private static final String NOP_DE_TAI = "INSERT INTO `qldetainckh`.`nopdetai` (`MaDeTai`, `MaNguoiNop`, `FileBaoCao`, `ThoiGianNop`, `MaThoiGian`,`GhiChu`, `TrangThai`)\r\n"
			+ " VALUES (?, ?, ?, ?, ?, N?, N?);";
	private static final String CAP_NHAT_NOP_DE_TAI = "UPDATE `qldetainckh`.`nopdetai` \r\n"
			+ "SET `FileBaoCao` = ?, `ThoiGianNop` = ?, `GhiChu` = N? \r\n"
			+ "WHERE (`MaNopDeTai` = ?);";
	private static final String CAP_NHAT_NOP_DE_TAI_KHONG_CO_FILE = "UPDATE `qldetainckh`.`nopdetai` \r\n"
			+ "SET `ThoiGianNop` = ?, `GhiChu` = N? \r\n"
			+ "WHERE (`MaNopDeTai` = ?);";
	private static final String DUYET_DE_TAI = "SELECT * FROM qldetainckh.dangkydetai where MaDon = ?";
	private static final String LAY_DANG_KY_DE_TAI_BANG_MA = "SELECT * FROM qldetainckh.dangkydetai where MaDon = ?";
	private static final String LAY_NOP_DE_TAI_BANG_MA_VA_THOI_GIAN = "SELECT * FROM qldetainckh.nopdetai\r\n"
			+ "where MaDeTai =? and MaThoiGian = ?;";
	private static final String LAY_DE_TAI_BANG_MA = "SELECT * FROM qldetainckh.detai where MaDeTai = ?";
	
	public void NopDeTai(int MaDeTai, String MaNguoiNop, byte[] FileBaoCao, int MaThoiGian, String GhiChu, String TrangThai) {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(NOP_DE_TAI);) {
			
			preparedStatement.setInt(1, MaDeTai);
	        preparedStatement.setString(2, MaNguoiNop);	    
	        preparedStatement.setBytes(3, FileBaoCao);
	        Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
	        preparedStatement.setTimestamp(4, thoiGianNop);	 
	        preparedStatement.setInt(5, MaThoiGian);
	        preparedStatement.setString(6, GhiChu);
	        preparedStatement.setString(7, TrangThai);	 
			preparedStatement.executeUpdate();
						     
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
	}
	public void CapNhatNopDeTai(int MaNopDeTai, byte[] FileBaoCao, String GhiChu) {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT_NOP_DE_TAI);) {
			  
	        preparedStatement.setBytes(1, FileBaoCao);
	        Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
	        preparedStatement.setTimestamp(2, thoiGianNop);	 
	        preparedStatement.setString(3, GhiChu);	 
	        preparedStatement.setInt(4, MaNopDeTai);
			preparedStatement.executeUpdate();
						     
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
	}
	
	public void CapNhatNopDeTaiKhongCoFile(int MaNopDeTai, String GhiChu) {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT_NOP_DE_TAI_KHONG_CO_FILE);) {
			  
	        Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
	        preparedStatement.setTimestamp(1, thoiGianNop);	 
	        preparedStatement.setString(2, GhiChu);	 
	        preparedStatement.setInt(3, MaNopDeTai);
			preparedStatement.executeUpdate();
						     
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
	}
	public DangKyDeTai LayDangKyDeTaiBangMa(int MaDon) {
		DangKyDeTai dangkydetai = new DangKyDeTai();        
	    try (Connection connection = JDBCUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_DANG_KY_DE_TAI_BANG_MA);) {
	    	 preparedStatement.setInt(1, MaDon);
		     ResultSet rs = preparedStatement.executeQuery();
		
		     while (rs.next()) {               		    	 
		    	 dangkydetai.setMaDon(rs.getInt(1));
		    	 dangkydetai.setMaDeTai(rs.getInt(2));
		    	 dangkydetai.setMaChuNhiem(rs.getString(3));
		    	 dangkydetai.setNgayDuyet(rs.getDate(4));
		    	 dangkydetai.setMaNguoiDuyet(rs.getString(5));
		    	 dangkydetai.setFileQuyetDinh(rs.getBytes(6));
		    	 dangkydetai.setMaThoiGian(rs.getInt(7));
		    	 dangkydetai.setTrangThai(rs.getString(8));
		    	 dangkydetai.setGhiChu(rs.getString(9));
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
     return dangkydetai;
	}     
	public NopDeTai LayNopDeTai(int MaDeTai, int MaThoiGian) {
		NopDeTai nopdetai = new NopDeTai();        
	    try (Connection connection = JDBCUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_NOP_DE_TAI_BANG_MA_VA_THOI_GIAN);) {
	    	 preparedStatement.setInt(1, MaDeTai);
	    	 preparedStatement.setInt(2, MaThoiGian);
		     ResultSet rs = preparedStatement.executeQuery();
		
		     while (rs.next()) {               		    	 
		    	 nopdetai.setMaNopDeTai(rs.getInt(1));
		    	 nopdetai.setMaDeTai(rs.getInt(2));
		    	 nopdetai.setMaNguoiNop(rs.getString(3));
		    	 nopdetai.setFileBaoCao(rs.getBytes(4));
		    	 nopdetai.setThoiGianNop(rs.getTimestamp(5));	    	 
		    	 nopdetai.setMaThoiGian(rs.getInt(6));		    	 
		    	 nopdetai.setGhiChu(rs.getString(7));
		    	 nopdetai.setTrangThai(rs.getString(8));
		    	 return nopdetai;
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
     return null;
	}     
	public DeTai LayDeTaiBangMa(int MaDeTai) {
    	DeTai detai = new DeTai();        
 	    try (Connection connection = JDBCUtil.getConnection();
 		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_DE_TAI_BANG_MA);) {
 	    	 preparedStatement.setInt(1, MaDeTai);
 		     ResultSet rs = preparedStatement.executeQuery();
 		
 		     while (rs.next()) {               		    	 
 		    	detai.setMaDeTai(rs.getInt(1));
 		    	detai.setTenDeTai(rs.getString(2));
 		    	detai.setKinhPhi(rs.getInt(3));
 		    	detai.setFileMoTaDeTai(rs.getBytes(4));
 		    	detai.setTrangThai(rs.getString(5));

 		     }
 	     } catch (SQLException exception) {
 	         HandleExeption.printSQLException(exception);
 	     }
      return detai;
     }
}
