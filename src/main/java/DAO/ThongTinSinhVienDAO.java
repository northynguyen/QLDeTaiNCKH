package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ThoiGianNCKH;
import Models.ThongTinSinhVien;
import Util.HandleExeption;
import Util.JDBCUtil;

public class ThongTinSinhVienDAO {
	private static final String TAO_THONG_TIN_SINH_VIEN = "INSERT INTO `qldetainckh`.`thongtinsinhvien` (`MSSV`, `HoTen`, `GioiTinh`, `MaKhoa`, `SDT`, `Email`, `DiaChi`) \r\n"
			+ "VALUES (?, N?, N?, N?, ?, ?, N?);";
	private static final String KIEM_TRA_MSSV_SINH_VIEN = "select * from thongtinsinhvien where MSSV = ?";
	private static final String KIEM_TRA_EMAIL_SINH_VIEN = "select * from thongtinsinhvien where Email = ?";
	private static final String LAY_TOAN_BO_SINH_VIEN = "select * from thongtinsinhvien";
	private static final String XOA_THONG_TIN_SINH_VIEN = "DELETE FROM `qldetainckh`.`thongtinsinhvien` WHERE (`MSSV` = ?);";
	private static final String SUA_THONG_TIN_SINH_VIEN = "UPDATE `qldetainckh`.`thongtinsinhvien` "
			+ "SET `HoTen` = N?, `GioiTinh` = N?, `MaKhoa` = ?, `SDT` = ?, `Email` =?, `DiaChi` = N? "
			+ "WHERE (`MSSV` = ?);\r\n";
	
	public boolean TaoSinhVien(String MSSV, String HoTen, String GioiTinh, String MaKhoa, String SDT, String Email, String DiaChi) {
		boolean rowUpdate = false;
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(TAO_THONG_TIN_SINH_VIEN);) {			
			preparedStatement.setString(1, MSSV);
	        preparedStatement.setString(2, HoTen);
	        preparedStatement.setString(3, GioiTinh);
	        preparedStatement.setString(4, MaKhoa);
	        preparedStatement.setString(5, SDT);
	        preparedStatement.setString(6, Email);
	        preparedStatement.setString(7, DiaChi);
	        rowUpdate = preparedStatement.executeUpdate() > 0;						     
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
		return rowUpdate;
	}
	

    public ThongTinSinhVien KiemTraMSSinhVien(String MSSV) throws ClassNotFoundException {
    	ThongTinSinhVien thongTinSinhVien = new ThongTinSinhVien();
        
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(KIEM_TRA_MSSV_SINH_VIEN)) {
            preparedStatement.setString(1, MSSV);
            ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()) {
        	   thongTinSinhVien.setMSSV(rs.getString(1));
        	   thongTinSinhVien.setHoTen(rs.getString(2));
        	   thongTinSinhVien.setGioiTinh(rs.getString(4));
        	   thongTinSinhVien.setMaKhoa(rs.getString(5));
        	   thongTinSinhVien.setSDT(rs.getString(6));
        	   thongTinSinhVien.setEmail(rs.getString(7));
        	   thongTinSinhVien.setDiaChi(rs.getString(8));
            }
           else {
        	   thongTinSinhVien = null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinSinhVien;
    }
    public ThongTinSinhVien KiemTraEmailSinhVien(String Email) throws ClassNotFoundException {
    	ThongTinSinhVien thongTinSinhVien = new ThongTinSinhVien();
        
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(KIEM_TRA_EMAIL_SINH_VIEN)) {
            preparedStatement.setString(1, Email);
            ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()) {
        	   thongTinSinhVien.setMSSV(rs.getString(1));
        	   thongTinSinhVien.setHoTen(rs.getString(2));
        	   thongTinSinhVien.setGioiTinh(rs.getString(4));
        	   thongTinSinhVien.setMaKhoa(rs.getString(5));
        	   thongTinSinhVien.setSDT(rs.getString(6));
        	   thongTinSinhVien.setEmail(rs.getString(7));
        	   thongTinSinhVien.setDiaChi(rs.getString(8));
            }
           else {
        	   thongTinSinhVien = null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinSinhVien;
    }
    public boolean XoaSinhVien(String MSSV)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(XOA_THONG_TIN_SINH_VIEN);
        	preparedStatement.setString(1, MSSV);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
    public boolean SuaSinhVien(String MSSV, String HoTen, String GioiTinh, String MaKhoa, String SDT, String Email, String DiaChi)
	{
		boolean rowUpdate=false;
		try {
        	Connection connection = JDBCUtil.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(SUA_THONG_TIN_SINH_VIEN);       	
	        preparedStatement.setString(1, HoTen);
	        preparedStatement.setString(2, GioiTinh);
	        preparedStatement.setString(3, MaKhoa);
	        preparedStatement.setString(4, SDT);
	        preparedStatement.setString(5, Email);
	        preparedStatement.setString(6, DiaChi);
	        preparedStatement.setString(7, MSSV);
        	rowUpdate = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }
        return rowUpdate;
	}
    public List<ThongTinSinhVien> LayToanBoSinhVien() {
		List<ThongTinSinhVien> listsinhvien = new ArrayList<>();	
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_TOAN_BO_SINH_VIEN);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ThongTinSinhVien sinhvien = new ThongTinSinhVien();
				sinhvien.setMSSV(rs.getString(1));
				sinhvien.setHoTen(rs.getString(2));
				sinhvien.setGioiTinh(rs.getString(3));
				sinhvien.setMaKhoa(rs.getString(4));
				sinhvien.setSDT(rs.getString(5));
				sinhvien.setEmail(rs.getString(6));
				sinhvien.setDiaChi(rs.getString(7));
				listsinhvien.add(sinhvien);
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return listsinhvien;
	}
	
}
