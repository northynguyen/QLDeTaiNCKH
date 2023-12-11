package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeTaiDAO {
	private static final String SELECT_ALL_DETAIs = "select * from qldetainckh.detai";
	private static final String INSERT_DETAI_SQL = "INSERT INTO qldetainckh.detai" + "  (TenDeTai,KinhPhi, FileMoTa, TrangThai) VALUES " +
	        " (?, ?, ?,?);";
	private static final String DELETE_DETAI_SQL = "delete from qldetainckh.detai where MaDeTai = ?;";
    private static final String UPDATE_DETAI_SQL = "update qldetainckh.detai set TenDeTai= ?, KinhPhi =?,FileMoTa = ?,TrangThai=? where MaDeTai = ?;";
//	public DeTai selectDeTai(int MaDeTai)
//	{
//		DeTai detai=null;
//		try  {
//        	Connection connection = JDBCUtil.getConnection();
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAIs);
//            preparedStatement.setLong(1, MaDeTai);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int maDeTai = rs.getInt("MaDeTai");
//                String tenDeTai = rs.getString("TenDeTai");
//                int kinhPhi = rs.getInt("KinhPhi");
//                byte[] fileMoTa = rs.getBytes("FileMoTa");
//                String trangThai = rs.getString("TrangThai");
//                detai = new DeTai(maDeTai, tenDeTai, kinhPhi, fileMoTa, trangThai);
//            }
//        } catch (SQLException exception) {
//        	HandleExeption.printSQLException(exception);
//        }
//		return detai;
//	}

	public List <DeTai> selectAllDeTai()
	{
		List <DeTai> DeTais= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAIs);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maDeTai = rs.getInt("MaDeTai");
                String tenDeTai = rs.getString("TenDeTai");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTa");
                String trangThai = rs.getString("TrangThai");
                DeTais.add(new DeTai(maDeTai, tenDeTai, kinhPhi, fileMoTa, trangThai));
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return DeTais;
	}
	public void themDeTai(DeTai detai) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DETAI_SQL);
            preparedStatement.setString(1, detai.getTenDeTai());
            preparedStatement.setInt(2, detai.getKinhPhi());
            preparedStatement.setBytes(3, detai.getFileMoTaDeTai());
            preparedStatement.setString(4, detai.getTrangThai());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
    }
	public boolean xoaDeTai(int maDeTai) throws SQLException {
		boolean rowDeleted=false;
        // try-with-resource statement will auto close the connection.
        try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DETAI_SQL);
            preparedStatement.setInt(1, maDeTai);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowDeleted;
    }
	public boolean suaDeTai(DeTai detai) throws SQLException {
		boolean rowUpdate=false;
        // try-with-resource statement will auto close the connection.
        try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DETAI_SQL);
        	preparedStatement.setString(1, detai.getTenDeTai());
            preparedStatement.setInt(2, detai.getKinhPhi());
            preparedStatement.setBytes(3, detai.getFileMoTaDeTai());
            preparedStatement.setString(4, detai.getTrangThai());
            preparedStatement.setInt(5, detai.getMaDeTai());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
    }
	
}


