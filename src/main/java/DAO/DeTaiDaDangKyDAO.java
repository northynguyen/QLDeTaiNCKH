package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKyDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeTaiDaDangKyDAO {
	private static final String DE_TAI_DA_DK = "SELECT * FROM nckh.dangkydetai where TrangThai='Đã duyệt';\r\n"
			+ "";
	private static final String DE_TAI_DA_DK_BY_MADON = "SELECT * FROM nckh.dangkydetai where TrangThai='Đã duyệt' and MaDon=?;\r\n"
			+ "";
	
	  public List<DangKyDeTai>  XemDeTaiDaDK() throws SQLException {
		  List<DangKyDeTai> ddk=new ArrayList<>();
	        try (Connection conn = JDBCUtil.getConnection();
	        		PreparedStatement preparedStatement = conn.prepareStatement(DE_TAI_DA_DK);) {
	        		ResultSet rs = preparedStatement.executeQuery();
	        		 
	             
	                while (rs.next()) {
	                	int maDon = rs.getInt(1);
	                    int maDeTai = rs.getInt(2);
	                    String maChuNhiem = rs.getString(3);
	                    Date ngayDuyet = rs.getDate(4);
	                    String maNguoiDuyet = rs.getString(5);
	                    byte[] fileQuyetDinh =rs.getBytes(6);
	                    String trangThai=rs.getString(7);
	                    String ghiChu=rs.getString(8);
	                    ddk.add(new DangKyDeTai(maDon,maDeTai, maChuNhiem,ngayDuyet,maNguoiDuyet, fileQuyetDinh,trangThai,ghiChu));
	                }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
	            return ddk;
	    } 
	  public DangKyDeTai  LayDeTaiDaDK(String madon) throws SQLException {
		  DangKyDeTai ddk=null;
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
	                    byte[] fileQuyetDinh =rs.getBytes(6);
	                    String trangThai=rs.getString(7);
	                    String ghiChu=rs.getString(8);
	                    ddk= new DangKyDeTai(maDon,maDeTai, maChuNhiem,ngayDuyet,maNguoiDuyet, fileQuyetDinh,trangThai,ghiChu);
	                }
	            } catch (SQLException e) {
	                HandleExeption.printSQLException(e);
	            }
	            return ddk;
	    } 
}
