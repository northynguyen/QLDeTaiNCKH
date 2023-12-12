package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DeXuatDeTai;
import Models.Duyet;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DuyetDeXuatDAO {
	private static final String Select_DDX_SQL =  "SELECT dexuatdetai.MaDeXuatDeTai , thongtintaikhoan.HoTen, dexuatdetai.TenDeTai,  dexuatdetai.KinhPhi, dexuatdetai.FileMoTaDeTai, dexuatdetai.TrangThai \r\n"
			+ "FROM dexuatdetai\r\n"
			+ "JOIN thongtintaikhoan ON dexuatdetai.MaChuNhiem = thongtintaikhoan.MaTK\r\n"
			+ "WHERE dexuatdetai.TrangThai = 'Chưa duyệt';";
	private static final String TuChoi_DTT ="UPDATE qldetainckh.dexuatdetai SET TrangThai = ?, GhiChu = ? WHERE (MaDeXuatDeTai = ?);";
	private static final String DeXuatFromCN_ID="SELECT MaDeXuatDeTai, TenDeTai, NgayDeXuat, KinhPhi, FileMoTaDeTai, GhiChu, TrangThai FROM qldetainckh.dexuatdetai\r\n"
			+ "where MaChuNhiem = ?;";
	public List <Duyet> selectAllDeTaiDuyet()
	{
		List <Duyet> duyet= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(Select_DDX_SQL);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int maDon = rs.getInt("MaDeXuatDeTai");
            	String tenDeTai = rs.getString("TenDeTai");
                String tenChuNhiem = rs.getString("HoTen");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTaDeTai");
                duyet.add(new Duyet(maDon, tenDeTai,tenChuNhiem, kinhPhi, fileMoTa));
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return duyet;
	}
	public boolean TuChoi(int maDeXuat, String lyDo)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(TuChoi_DTT);
        	preparedStatement.setString(1, "Từ chối");
        	preparedStatement.setString(2, lyDo);
            preparedStatement.setInt(3, maDeXuat);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
	public List <DeXuatDeTai> selectAllDeTaiCN(String MaChuNhiem)
	{
		List <DeXuatDeTai> dexuat_ID= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(DeXuatFromCN_ID);
            preparedStatement.setString(1, MaChuNhiem);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int maDon = rs.getInt("MaDeXuatDeTai");
            	String tenDeTai = rs.getString("TenDeTai");
                Date ngaydexuat = rs.getDate("NgayDeXuat");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTaDeTai");
                String ghichu= rs.getString("GhiChu");
                String trangthai =  rs.getString("TrangThai");
                dexuat_ID.add(new DeXuatDeTai(maDon, tenDeTai,ngaydexuat, kinhPhi, fileMoTa,ghichu,trangthai));
                System.out.println(maDon);
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return dexuat_ID;
	}
}