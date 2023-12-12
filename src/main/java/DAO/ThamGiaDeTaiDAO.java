package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKyDeTai;
import Models.Duyet;
import Models.ThamGiaDeTai;
import Models.ThoiGianNCKH;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThamGiaDeTaiDAO {
	private static final String thamgiadetai = "SELECT ts.MSSV, ts.HoTen, tgdt.VaiTro\r\n"
			+ "FROM thongtinsinhvien ts\r\n"
			+ "JOIN thamgiadetai tgdt ON ts.MSSV = tgdt.MSSV\r\n"
			+ "WHERE tgdt.MaDeTai = ? and tgdt.MaThoiGian= ?;";
	private static final String SV_trong = "SELECT thongtinsinhvien.MSSV, HoTen\r\n"
			+ "FROM thongtinsinhvien\r\n"
			+ "LEFT JOIN thamgiadetai ON thongtinsinhvien.MSSV = thamgiadetai.MSSV\r\n"
			+ "WHERE thamgiadetai.MSSV IS NULL OR thamgiadetai.MaThoiGian <> ? ;";
	private static final String maThoiGianTgdt ="Select MaThoiGian from dangkydetai where MaDon = ?";
	private static final String ThemThamGiaDeTai="INSERT INTO qldetainckh.thamgiadetai (MaDeTai, MSSV, VaiTro, MaThoiGian) VALUES (?,?,?,?);";
	public List <ThamGiaDeTai> ThamGiaDeTai_MaDeTai(int madetai, int madon)
	{
		List <ThamGiaDeTai> tgdt = new ArrayList<>();
		    try {
		    	Connection connection = JDBCUtil.getConnection(); 
		    	PreparedStatement preparedStatement1 = connection.prepareStatement(maThoiGianTgdt);
		    	preparedStatement1.setInt(1, madon);
		    	ResultSet rs1 = preparedStatement1.executeQuery();
		    	int matg = -1;
		    	while (rs1.next()) {
	            	matg = rs1.getInt(1);
	            }
		    	
		    	PreparedStatement preparedStatement = connection.prepareStatement(thamgiadetai);
		        preparedStatement.setInt(1, madetai);
		        preparedStatement.setInt(2, matg);
		        ResultSet rs = preparedStatement.executeQuery();
		        while (rs.next()) {
	            	String MSSV = rs.getString("MSSV");
	            	String hoten = rs.getString("HoTen");
	                String vaitro = rs.getString("VaiTro");	               
	                tgdt.add(new ThamGiaDeTai(MSSV,hoten,vaitro));
	            }
	            connection.close();
	        } catch (SQLException exception) {
	        	HandleExeption.printSQLException(exception);
	        }
		    return tgdt;
	}

	public List <ThamGiaDeTai> SV_Trong()
	{
		List <ThamGiaDeTai> tgdt = new ArrayList<>();
		    try {
		    	Connection connection = JDBCUtil.getConnection(); 
		    	ThoiGianNCKHDAO tgDAO= new ThoiGianNCKHDAO();
		    	ThoiGianNCKH tg = new ThoiGianNCKH();
		    	tg = tgDAO.LayThoiGian();
		    	PreparedStatement preparedStatement = connection.prepareStatement(SV_trong);
		        preparedStatement.setInt(1, tg.getMaThoiGianNCKH());
		        ResultSet rs = preparedStatement.executeQuery();
		        while (rs.next()) {
	            	String MSSV = rs.getString("MSSV");
	            	String hoten = rs.getString("HoTen");               
	                tgdt.add(new ThamGiaDeTai(MSSV,hoten));
	            }
	            connection.close();
	        } catch (SQLException exception) {
	        	HandleExeption.printSQLException(exception);
	        }
		    return tgdt;		   
	}
	public void ThemSVThamGia(ThamGiaDeTai sv) throws SQLException {
	    // try-with-resource statement will auto close the connection.
	    try {
	    	Connection connection = JDBCUtil.getConnection(); 
	    	PreparedStatement preparedStatement = connection.prepareStatement(ThemThamGiaDeTai);
	        preparedStatement.setInt(1, sv.getMaDeTai());
	        preparedStatement.setString(2, sv.getMSSV());
	        preparedStatement.setString(3, sv.getVaiTro());
	        preparedStatement.setInt(4, sv.getMaThoiGianNCKH());
	        preparedStatement.executeUpdate();
	        connection.close();
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }
	}
}
