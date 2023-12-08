package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DeTai;
import Models.DuyetDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DuyetDeTaiDAO {
	private static final String Select_DDT_SQL = "SELECT detai.TenDeTai, thongtintaikhoan.HoTen AS TenChuNhiem, detai.KinhPhi, detai.FileMoTa\r\n"
			+ "FROM detai\r\n"
			+ "JOIN dangkydetai ON detai.MaDeTai = dangkydetai.MaDeTai\r\n"
			+ "JOIN thongtintaikhoan ON dangkydetai.MaChuNhiem = thongtintaikhoan.MaTK\r\n"
			+ "WHERE dangkydetai.TrangThai = 'Chưa duyệt';";
	public List <DuyetDeTai> selectAllDeTaiDuyet()
	{
		List <DuyetDeTai> duyet= new ArrayList < > ();
		try  {
        	Connection connection = JDBCUtil.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(Select_DDT_SQL);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String tenDeTai = rs.getString("TenDeTai");
                String tenChuNhiem = rs.getString("TenChuNhiem");
                int kinhPhi = rs.getInt("KinhPhi");
                byte[] fileMoTa = rs.getBytes("FileMoTa");
                duyet.add(new DuyetDeTai(tenDeTai,tenChuNhiem, kinhPhi, fileMoTa));
            }
            connection.close();
        } catch (SQLException exception) {
        	HandleExeption.printSQLException(exception);
        }
		return duyet;
	}
}
