package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.mysql.jdbc.Blob;

import Models.DeTai;
import Models.DeXuatDeTai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThemDeTaiDAO {
	private static final String THEM_DE_TAI = "INSERT INTO `nckh`.`detai` (`TenDeTai`, `KinhPhi`, `FileMoTa`,`TrangThai`) VALUES (?,?,?,'Chưa duyệt');\r\n"
			+ "";
	

	public boolean ThemDeTai(String tenDeTai, String kinhPhi, byte[] fileMoTaDeTai) throws SQLException {
		boolean rowUpdated;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(THEM_DE_TAI);) {
			statement.setString(1, tenDeTai);
			statement.setString(2, kinhPhi);
			statement.setBytes(3, fileMoTaDeTai);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
