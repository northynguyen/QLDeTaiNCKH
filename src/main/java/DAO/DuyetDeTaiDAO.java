package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DeTai;
import Models.DeXuatDeTai;
import Models.Duyet;
import Models.LayDK_CN;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DuyetDeTaiDAO {
	private static final String Select_DDT_SQL = "SELECT dangkydetai.MaDon, detai.TenDeTai, thongtintaikhoan.HoTen AS TenChuNhiem, detai.KinhPhi, detai.FileMoTa\r\n"
			+ "FROM detai\r\n"
			+ "JOIN dangkydetai ON detai.MaDeTai = dangkydetai.MaDeTai\r\n"
			+ "JOIN thongtintaikhoan ON dangkydetai.MaChuNhiem = thongtintaikhoan.MaTK\r\n"
			+ "WHERE dangkydetai.TrangThai = 'Chưa duyệt';";
	private static final String TuChoi_DTT ="UPDATE qldetainckh.dangkydetai SET TrangThai = ?, GhiChu = ? WHERE (MaDon = ?);";
	private static final String ShowDKDeTai_CN = "SELECT dangkydetai.MaDeTai, detai.TenDeTai, dangkydetai.NgayDuyet, detai.KinhPhi, detai.FileMoTa, dangkydetai.TrangThai\r\n"
			+ "FROM dangkydetai\r\n"
			+ "JOIN detai ON dangkydetai.MaDeTai = detai.MaDeTai\r\n"
			+ "Where dangkydetai.MaChuNhiem = ?;";
	private static final String LAYDKDETAI_CN ="SELECT dangkydetai.MaDon, dangkydetai.MaDeTai, detai.TenDeTai, dangkydetai.NgayDuyet, detai.KinhPhi, detai.FileMoTa, dangkydetai.TrangThai\r\n"
			+ "FROM dangkydetai\r\n"
			+ "JOIN detai ON dangkydetai.MaDeTai = detai.MaDeTai\r\n"
			+ "WHERE dangkydetai.MaChuNhiem = ?;";
	public List <Duyet> selectAllDeTaiDuyet()
	{
		List <Duyet> duyet= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(Select_DDT_SQL);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int maDon = rs.getInt("MaDon");
            	String tenDeTai = rs.getString("TenDeTai");
                String tenChuNhiem = rs.getString("TenChuNhiem");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTa");
                duyet.add(new Duyet(maDon, tenDeTai,tenChuNhiem, kinhPhi, fileMoTa));
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return duyet;
	}
	public boolean TuChoi(int maDon, String lyDo)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(TuChoi_DTT);
        	preparedStatement.setString(1, "Từ chối");
        	preparedStatement.setString(2, lyDo);
            preparedStatement.setInt(3, maDon);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public List <LayDK_CN> selectAllDeTaiCN(String MaChuNhiem)
	{
		List <LayDK_CN> dexuat_ID= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(LAYDKDETAI_CN);
            preparedStatement.setString(1, MaChuNhiem);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int maDon = rs.getInt("MaDon");
            	int maDeTai = rs.getInt("MaDeTai");
            	String tenDeTai = rs.getString("TenDeTai");
                Date ngayduyet = rs.getDate("NgayDuyet");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTa");
                String trangthai =  rs.getString("TrangThai");
                dexuat_ID.add(new LayDK_CN(maDon,maDeTai, tenDeTai,ngayduyet, kinhPhi, fileMoTa,trangthai));
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return dexuat_ID;
	}
}