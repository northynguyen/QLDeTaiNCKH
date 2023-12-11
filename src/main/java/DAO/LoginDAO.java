package DAO;
import Models.Khoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ThongTinTaiKhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class LoginDAO {
	private static final String LAY_KHOA = "SELECT * FROM qldetainckh.khoa";
	private static final String TAO_THONG_TIN_TAI_KHOAN = "INSERT INTO `qldetainckh`.`thongtintaikhoan` (`MaTK`, `MatKhau`, `Role`, `HoTen`, `GioiTinh`, `MaKhoa`, `SDT`, `Email`, `DiaChi`) \r\n"
			+ "VALUES (?, ?, N?, N?, N?, N?, ?, ?, N?);";
	private static final String KIEM_TRA_TAI_KHOAN = "select * from thongtintaikhoan where MaTK = ?";
	private static final String KIEM_TRA_EMAIL = "select * from thongtintaikhoan where Email = ?";
	private static final String TAO_KHOA = "INSERT INTO `qldetainckh`.`khoa` (`MaKhoa`, `TenKhoa`) VALUES (?, N?)";
	
	public void TaoTaiKhoan(String MaTK, String MatKhau, String Role, String HoTen, 
	String GioiTinh, String MaKhoa, String SDT, String Email, String DiaChi) {
		try (Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(TAO_THONG_TIN_TAI_KHOAN);) {
			
			preparedStatement.setString(1, MaTK);
	        preparedStatement.setString(2, MatKhau);
	        preparedStatement.setString(3, Role);
	        preparedStatement.setString(4, HoTen);
	        preparedStatement.setString(5, GioiTinh);
	        preparedStatement.setString(6, MaKhoa);
	        preparedStatement.setString(7, SDT);
	        preparedStatement.setString(8, Email);
	        preparedStatement.setString(9, DiaChi);
			preparedStatement.executeUpdate();
						     
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
	}
	
	public List<Khoa> LayKhoa() {
	    List < Khoa > ListKhoa = new ArrayList < > ();        
	    try (Connection connection = JDBCUtil.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(LAY_KHOA);) {
		     ResultSet rs = preparedStatement.executeQuery();
		
		     while (rs.next()) {               
		    	 Khoa khoa = new Khoa();
		    	 khoa.setMaKhoa(rs.getString(1));
		    	 khoa.setTenKhoa(rs.getString(2));
		    	 ListKhoa.add(khoa);
		     }
	     } catch (SQLException exception) {
	         HandleExeption.printSQLException(exception);
	     }
     return ListKhoa;
	}
	
    public ThongTinTaiKhoan validate(String TaiKhoan, String password) throws ClassNotFoundException {
    	ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan();
        
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select * from ThongTinTaiKhoan where MaTK = ? and MatKhau = ? ")) {
            preparedStatement.setString(1, TaiKhoan);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()) {
        	   thongTinTaiKhoan.setMaTaiKhoan(rs.getString(1));
        	   thongTinTaiKhoan.setRole(rs.getString(3));
        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
        	   thongTinTaiKhoan.setRole(rs.getString(3));
        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
        	   thongTinTaiKhoan.setGioiTinh(rs.getString(5));
        	   thongTinTaiKhoan.setMaKhoa(rs.getString(6));
        	   thongTinTaiKhoan.setSDT(rs.getString(7));
        	   thongTinTaiKhoan.setEmail(rs.getString(8));
        	   thongTinTaiKhoan.setDiaChi(rs.getString(9));
            }
           else {
        	   thongTinTaiKhoan = null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinTaiKhoan;
    }
    public void ChangePassword(String newPass, String email) throws ClassNotFoundException {

        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("update account set password = ? where email = ?")) {
            preparedStatement.setString(1, newPass);
            preparedStatement.setString(2, email);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ThongTinTaiKhoan KiemTraTaiKhoan(String TaiKhoan) throws ClassNotFoundException {
    	ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan();
        
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(KIEM_TRA_TAI_KHOAN)) {
            preparedStatement.setString(1, TaiKhoan);
            ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()) {
        	   thongTinTaiKhoan.setMaTaiKhoan(rs.getString(1));
        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
        	   thongTinTaiKhoan.setRole(rs.getString(3));
        	   thongTinTaiKhoan.setGioiTinh(rs.getString(5));
        	   thongTinTaiKhoan.setMaKhoa(rs.getString(6));
        	   thongTinTaiKhoan.setSDT(rs.getString(7));
        	   thongTinTaiKhoan.setEmail(rs.getString(8));
        	   thongTinTaiKhoan.setDiaChi(rs.getString(9));
            }
           else {
        	   thongTinTaiKhoan = null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinTaiKhoan;
    }
    public ThongTinTaiKhoan KiemTraEmail(String Email) throws ClassNotFoundException {
    	ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan();
        
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(KIEM_TRA_EMAIL)) {
            preparedStatement.setString(1, Email);
            ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()) {
        	   thongTinTaiKhoan.setMaTaiKhoan(rs.getString(1));
        	   thongTinTaiKhoan.setHoTen(rs.getString(4));
        	   thongTinTaiKhoan.setRole(rs.getString(3));
        	   thongTinTaiKhoan.setGioiTinh(rs.getString(5));
        	   thongTinTaiKhoan.setMaKhoa(rs.getString(6));
        	   thongTinTaiKhoan.setSDT(rs.getString(7));
        	   thongTinTaiKhoan.setEmail(rs.getString(8));
        	   thongTinTaiKhoan.setDiaChi(rs.getString(9));
            }
           else {
        	   thongTinTaiKhoan = null;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinTaiKhoan;
    }
}