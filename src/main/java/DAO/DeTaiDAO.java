package DAO;

import java.time.LocalTime;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Models.DangKyDeTai;
import Models.DeTai;
import Models.DeXuatDeTai;
import Models.Khoa;
import Models.NopDeTai;
import Models.NopNghiemThu;
import Util.HandleExeption;
import Util.JDBCUtil;

public class DeTaiDAO {
	private static final String NOP_DE_TAI = "INSERT INTO `qldetainckh`.`nopdetai` (`MaDeTai`, `MaNguoiNop`, `FileBaoCao`, `ThoiGianNop`, `MaThoiGian`,`GhiChu`, `TrangThai`)\r\n"
			+ " VALUES (?, ?, ?, ?, ?, N?, N?);";
	private static final String CAP_NHAT_NOP_DE_TAI = "UPDATE `qldetainckh`.`nopdetai` \r\n"
			+ "SET `FileBaoCao` = ?, `ThoiGianNop` = ?, `GhiChu` = N? \r\n"
			+ "WHERE (`MaNopDeTai` = ?);";
	private static final String CAP_NHAT_NOP_DE_TAI_KHONG_CO_FILE = "UPDATE `qldetainckh`.`nopdetai` \r\n"
			+ "SET `ThoiGianNop` = ?, `GhiChu` = N? \r\n"
			+ "WHERE (`MaNopDeTai` = ?);";
	private static final String DUYET_DE_TAI_DANG_KY = "update qldetainckh.dangkydetai\r\n"
			+ "set NgayDuyet =?, MaNguoiDuyet =?, FileQuyetDinh =?, TrangThai = N?, GhiChu = N?\r\n"
			+ "where MaDon = ?";
	private static final String DUYET_DE_TAI_DE_XUAT = "INSERT INTO `qldetainckh`.`dangkydetai` \r\n"
			+ "(`MaDeTai`, `MaChuNhiem`, `NgayDuyet`, `MaNguoiDuyet`, `FileQuyetDinh`, `MaThoiGian`, `TrangThai`, `GhiChu`) \r\n"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String CAP_NHAT_TRANG_THAI_DE_XUAT = "UPDATE `qldetainckh`.`dexuatdetai` SET `TrangThai` = 'Đã duyệt', `GhiChu` = ? WHERE (`MaDeXuatDeTai` = ?);";
	private static final String LAY_DE_XUAT_DE_TAI_BANG_MA = "SELECT * FROM qldetainckh.dexuatdetai where MaDeXuatDeTai = ?";
	private static final String LAY_DANG_KY_DE_TAI_BANG_MA = "SELECT * FROM qldetainckh.dangkydetai where MaDon = ?";
	private static final String LAY_NOP_DE_TAI_BANG_MA_VA_THOI_GIAN = "SELECT * FROM qldetainckh.nopdetai\r\n"
			+ "where MaDeTai =? and MaThoiGian = ?;";
	private static final String LAY_DE_TAI_BANG_MA = "SELECT * FROM qldetainckh.detai where MaDeTai = ?";
	private static final String THEM_DE_TAI = "INSERT INTO `qldetainckh`.`detai` (`TenDeTai`, `KinhPhi`, `FileMoTa`,`TrangThai`) VALUES (N?,?,?,N?);\r\n";
	private static final String SELECT_ALL_DETAIs = "select * from qldetainckh.detai where TrangThai = N'Trống'";
	private static final String SELECT_ALL_DETAIs1 = "select * from qldetainckh.detai";
	private static final String INSERT_DETAI_SQL = "INSERT INTO qldetainckh.detai"
			+ "  (TenDeTai,KinhPhi, FileMoTa, TrangThai) VALUES " +
			" (?, ?, ?,?);";
	private static final String DELETE_DETAI_SQL = "delete from qldetainckh.detai where MaDeTai = ?;";
	private static final String UPDATE_DETAI_SQL = "update qldetainckh.detai set TenDeTai= ?, KinhPhi =?,FileMoTa = ?,TrangThai=? where MaDeTai = ?;";
	private static final String LAY_NGHIEM_THU_THEO_CHU_NHIEM = "SELECT nopdetai.MaNopDeTai, MaDeTai, FileBaoCao, MaThoiGian, "
			+ "MaNghiemThu, NgayNghiemThu, HoSoLienQuan, DiemSo, nghiemthu.GhiChu\r\n"
			+ "FROM nopdetai inner join nghiemthu \r\n"
			+ "on nopdetai.MaNopDeTai = nghiemthu.MaNopDeTai\r\n"
			+ "where nopdetai.MaNguoiNop = ?";
	public void NopDeTai(int MaDeTai, String MaNguoiNop, byte[] FileBaoCao, int MaThoiGian, String GhiChu,
			String TrangThai) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(NOP_DE_TAI);) {

			preparedStatement.setInt(1, MaDeTai);
			preparedStatement.setString(2, MaNguoiNop);
			preparedStatement.setBytes(3, FileBaoCao);
			Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
			preparedStatement.setTimestamp(4, thoiGianNop);
			preparedStatement.setInt(5, MaThoiGian);
			preparedStatement.setString(6, GhiChu);
			preparedStatement.setString(7, TrangThai);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}

	public void CapNhatNopDeTai(int MaNopDeTai, byte[] FileBaoCao, String GhiChu) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT_NOP_DE_TAI);) {

			preparedStatement.setBytes(1, FileBaoCao);
			Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
			preparedStatement.setTimestamp(2, thoiGianNop);
			preparedStatement.setString(3, GhiChu);
			preparedStatement.setInt(4, MaNopDeTai);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}

	public void CapNhatNopDeTaiKhongCoFile(int MaNopDeTai, String GhiChu) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT_NOP_DE_TAI_KHONG_CO_FILE);) {

			Timestamp thoiGianNop = new Timestamp(System.currentTimeMillis());
			preparedStatement.setTimestamp(1, thoiGianNop);
			preparedStatement.setString(2, GhiChu);
			preparedStatement.setInt(3, MaNopDeTai);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}
	
	public List<NopNghiemThu> LayNopNghiemThu(String MaChuNhiem) {
		List<NopNghiemThu> listnopnghiemthu = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_NGHIEM_THU_THEO_CHU_NHIEM);) {
			preparedStatement.setString(1, MaChuNhiem);
			System.out.print(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				NopNghiemThu nopnghiemthu = new NopNghiemThu();
				nopnghiemthu.setMaNopDeTai(rs.getInt(1));
				nopnghiemthu.setMaDeTai(rs.getInt(2));
				nopnghiemthu.setFileBaoCao(rs.getBytes(3));
				nopnghiemthu.setMaThoiGian(rs.getInt(4));
				nopnghiemthu.setMaNghiemThu(rs.getInt(5));
				nopnghiemthu.setNgayNghiemThu(rs.getDate(6));
				nopnghiemthu.setHoSoLienQuan(rs.getBytes(7));
				nopnghiemthu.setDiemSo(rs.getInt(8));
				nopnghiemthu.setGhiChu(rs.getString(9));
				listnopnghiemthu.add(nopnghiemthu);
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return listnopnghiemthu;
	}
	
	public DangKyDeTai LayDangKyDeTaiBangMa(int MaDon) {
		DangKyDeTai dangkydetai = new DangKyDeTai();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_DANG_KY_DE_TAI_BANG_MA);) {
			preparedStatement.setInt(1, MaDon);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				dangkydetai.setMaDon(rs.getInt(1));
				dangkydetai.setMaDeTai(rs.getInt(2));
				dangkydetai.setMaChuNhiem(rs.getString(3));
				dangkydetai.setNgayDuyet(rs.getDate(4));
				dangkydetai.setMaNguoiDuyet(rs.getString(5));
				dangkydetai.setFileQuyetDinh(rs.getBytes(6));
				dangkydetai.setMaThoiGian(rs.getInt(7));
				dangkydetai.setTrangThai(rs.getString(8));
				dangkydetai.setGhiChu(rs.getString(9));
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return dangkydetai;
	}

	public NopDeTai LayNopDeTai(int MaDeTai, int MaThoiGian) {
		NopDeTai nopdetai = new NopDeTai();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(LAY_NOP_DE_TAI_BANG_MA_VA_THOI_GIAN);) {
			preparedStatement.setInt(1, MaDeTai);
			preparedStatement.setInt(2, MaThoiGian);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				nopdetai.setMaNopDeTai(rs.getInt(1));
				nopdetai.setMaDeTai(rs.getInt(2));
				nopdetai.setMaNguoiNop(rs.getString(3));
				nopdetai.setFileBaoCao(rs.getBytes(4));
				nopdetai.setThoiGianNop(rs.getTimestamp(5));
				nopdetai.setMaThoiGian(rs.getInt(6));
				nopdetai.setGhiChu(rs.getString(7));
				nopdetai.setTrangThai(rs.getString(8));
				return nopdetai;
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return null;
	}

	public DeTai LayDeTaiBangMa(int MaDeTai) {
		DeTai detai = new DeTai();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_DE_TAI_BANG_MA);) {
			preparedStatement.setInt(1, MaDeTai);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				detai.setMaDeTai(rs.getInt(1));
				detai.setTenDeTai(rs.getString(2));
				detai.setKinhPhi(rs.getInt(3));
				detai.setFileMoTaDeTai(rs.getBytes(4));
				detai.setTrangThai(rs.getString(5));

			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return detai;
	}

	public DeXuatDeTai LayDeXuatDeTaiBangMa(int MaDeXuatDeTai) {
		DeXuatDeTai dexuatdetai = new DeXuatDeTai();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LAY_DE_XUAT_DE_TAI_BANG_MA);) {
			preparedStatement.setInt(1, MaDeXuatDeTai);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				dexuatdetai.setMaDeXuatDeTai(rs.getInt(1));
				dexuatdetai.setMaChuNhiem(rs.getString(2));
				dexuatdetai.setTenDeTai(rs.getString(3));
				dexuatdetai.setNgayDeXuat(rs.getDate(4));
				dexuatdetai.setKinhPhi(rs.getInt(5));
				dexuatdetai.setFileMoTaDeTai(rs.getBytes(6));
				dexuatdetai.setTrangThai(rs.getString(7));
				dexuatdetai.setGhiChu(rs.getString(8));
			}
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		return dexuatdetai;
	}

	public boolean ThemDeTaiDeXuat(String tenDeTai, String kinhPhi, byte[] fileMoTaDeTai) throws SQLException {
		boolean rowUpdated;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(THEM_DE_TAI);) {
			statement.setString(1, tenDeTai);
			statement.setString(2, kinhPhi);
			statement.setBytes(3, fileMoTaDeTai);
			statement.setString(4, "Đã đăng ký");
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public void DuyetDeTaiDangKy(byte[] FileQuyetDinh, String MaNguoiDuyet, String GhiChu, String MaDon) {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DUYET_DE_TAI_DANG_KY);) {

			java.util.Date utilDate = new java.util.Date();
			Date NgayDuyet = new Date(utilDate.getTime());
			preparedStatement.setDate(1, NgayDuyet);
			preparedStatement.setString(2, MaNguoiDuyet);
			preparedStatement.setBytes(3, FileQuyetDinh);
			preparedStatement.setString(4, "Đã duyệt");
			preparedStatement.setString(5, GhiChu);
			preparedStatement.setString(6, MaDon);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}

	public void DuyetDeTaiDeXuat(int MaThoiGian, String MaDeXuatDeTai, byte[] FileQuyetDinh, String MaNguoiDuyet,
			String MaChuNhiem, String GhiChu, String tenDeTai, int kinhPhi, byte[] fileMoTaDeTai) throws SQLException {
		// Cap nhat trang thai de xuat
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(CAP_NHAT_TRANG_THAI_DE_XUAT);) {
			statement.setString(1, GhiChu);
			statement.setString(2, MaDeXuatDeTai);
			statement.executeUpdate();

		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		// Them de xuat vao bang de tai va lay ma de tai
		int MaDeTai = -1;
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(THEM_DE_TAI, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, tenDeTai);
			statement.setInt(2, kinhPhi);
			statement.setBytes(3, fileMoTaDeTai);
			statement.setString(4, "Đã đăng ký");
			statement.executeUpdate();

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					MaDeTai = generatedKeys.getInt(1);
				}
			}
		}
		// them de tai de xuat vao bang dang ky de tai voi trang thai la da duyet
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DUYET_DE_TAI_DE_XUAT);) {

			java.util.Date utilDate = new java.util.Date();
			Date NgayDuyet = new Date(utilDate.getTime());
			preparedStatement.setInt(1, MaDeTai);
			preparedStatement.setString(2, MaChuNhiem);
			preparedStatement.setDate(3, NgayDuyet);
			preparedStatement.setString(4, MaNguoiDuyet);
			preparedStatement.setBytes(5, FileQuyetDinh);
			preparedStatement.setInt(6, MaThoiGian);
			preparedStatement.setString(7, "Đã duyệt");
			preparedStatement.setString(8, GhiChu);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}

	// public DeTai selectDeTai(int MaDeTai)
	// {
	// DeTai detai=null;
	// try {
	// Connection connection = JDBCUtil.getConnection();
	// // Step 2:Create a statement using connection object
	// PreparedStatement preparedStatement =
	// connection.prepareStatement(SELECT_ALL_DETAIs);
	// preparedStatement.setLong(1, MaDeTai);
	// System.out.println(preparedStatement);
	// // Step 3: Execute the query or update query
	// ResultSet rs = preparedStatement.executeQuery();
	// // Step 4: Process the ResultSet object.
	// while (rs.next()) {
	// int maDeTai = rs.getInt("MaDeTai");
	// String tenDeTai = rs.getString("TenDeTai");
	// int kinhPhi = rs.getInt("KinhPhi");
	// byte[] fileMoTa = rs.getBytes("FileMoTa");
	// String trangThai = rs.getString("TrangThai");
	// detai = new DeTai(maDeTai, tenDeTai, kinhPhi, fileMoTa, trangThai);
	// }
	// } catch (SQLException exception) {
	// HandleExeption.printSQLException(exception);
	// }
	// return detai;
	// }

	public List<DeTai> selectAllDeTai() {
		List<DeTai> DeTais = new ArrayList<>();
		try {
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
	public List<DeTai> selectAllDeTai1() {
		List<DeTai> DeTais = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAIs1);
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
		boolean rowDeleted = false;
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
		boolean rowUpdate = false;
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
