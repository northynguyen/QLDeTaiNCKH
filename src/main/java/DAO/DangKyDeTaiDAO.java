package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.DangKyDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DangKyDeTaiDAO {
	private static final String INSERT_DKDTfromCN_SQL = "INSERT INTO qldetainckh.dangkydetai" + "  (MaDeTai,MaChuNhiem,TrangThai,MaThoiGian) VALUES " +
	        " (?, ?, ?,?);";
	public void dkDeTai(DangKyDeTai dk) throws SQLException {
	    // try-with-resource statement will auto close the connection.
	    try {
	    	Connection connection = JDBCUtil.getConnection(); 
	    	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DKDTfromCN_SQL);
	        preparedStatement.setInt(1, dk.getMaDeTai());
	        preparedStatement.setString(2, dk.getMaChuNhiem());
	        preparedStatement.setString(3, dk.getTrangThai());
	        preparedStatement.setInt(4, dk.getMaThoiGian());
	        preparedStatement.executeUpdate();
	        connection.close();
	    } catch (SQLException e) {
	        HandleExeption.printSQLException(e);
	    }
	}
}
