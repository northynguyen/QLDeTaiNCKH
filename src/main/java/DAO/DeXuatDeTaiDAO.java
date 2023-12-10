package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.mysql.jdbc.Blob;

import Models.DeXuatDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeXuatDeTaiDAO {
	private static final String THEM_DE_XUAT = "INSERT INTO `nckh`.`dexuatdetai` (`MaChuNhiem`, `TenDeTai`, `NgayDeXuat`, `KinhPhi`, `FileMoTaDeTai`,`TrangThai`) VALUES (?, ?, ?, ?,?, 'Chưa duyệt');\r\n"
			+ "";
	private static final String LAY_DE_XUAT_BYID = "SELECT * FROM nckh.dexuatdetai where MaDeXuatDeTai= ?;";
	private static final String CHINH_SUA_DE_XUAT = "UPDATE `nckh`.`dexuatdetai` SET `TenDeTai` = ?, `NgayDeXuat` = ?, `KinhPhi` = ?,`FileMoTaDeTai`=?  WHERE (`MaDeXuatDeTai` = ?);\r\n"
			+ "";

	  public boolean ThemDeXuat(String maChuNhiem, String tenDeTai,Date ngayDeXuat,String kinhPhi,byte[] fileMoTaDeTai) throws SQLException {
	        boolean rowUpdated;
	        try (Connection conn = JDBCUtil.getConnection();
	                PreparedStatement statement = conn.prepareStatement(THEM_DE_XUAT);) {
	            statement.setString(1, maChuNhiem);
	            statement.setString(2, tenDeTai);
	            statement.setDate(3, ngayDeXuat);
	            statement.setString(4, kinhPhi);
	            statement.setBytes(5, fileMoTaDeTai);
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    } 
	  public boolean ChinhSuaDeXuat(String tenDeTai,Date ngayDeXuat,String kinhPhi,byte[] fileMoTaDeTai,String maMaDeXuatDeTai) throws SQLException {
	        boolean rowUpdated;
	        try (Connection conn = JDBCUtil.getConnection();
	                PreparedStatement statement = conn.prepareStatement(CHINH_SUA_DE_XUAT);) {
	            statement.setString(1, tenDeTai);
	            statement.setDate(2, ngayDeXuat);
	            statement.setString(3, kinhPhi);
	            statement.setBytes(4, fileMoTaDeTai);
	            statement.setString(5, maMaDeXuatDeTai);
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    } 
	  public DeXuatDeTai LayDeXuat_ByID(String maMaDeXuatDeTai) throws SQLException {
		  	DeXuatDeTai dx = null;
	        try (Connection conn = JDBCUtil.getConnection();
	                PreparedStatement statement = conn.prepareStatement(LAY_DE_XUAT_BYID);) {
	            statement.setString(1, maMaDeXuatDeTai);
	            
	            ResultSet rs = statement.executeQuery();

            	
	            while (rs.next()) {
	            	int MaDeXuatDeTai =rs.getInt(1);
	            	String MaChuNhiem=rs.getString(2);
	            	String TenDeTai=rs.getString(3);
	            	Date ngayDeXuat=rs.getDate(4);
	            	int KinhPhi=rs.getInt(5);
	            	byte[] FileMoTaDeTai=rs.getBytes(6);
	            	String TrangThai=rs.getString(7);
	            	String GhiChu=rs.getString(8);
	            	
	            	
	                dx=new DeXuatDeTai(MaDeXuatDeTai, MaChuNhiem, TenDeTai,KinhPhi,FileMoTaDeTai, ngayDeXuat);
	                
	            }
	        }
	        return dx;
	    } 
	  
}
