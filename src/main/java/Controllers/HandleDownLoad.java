package Controllers;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.DeTaiDAO;
import DAO.DeTaiDaDangKyDAO;
import DAO.DeXuatDeTaiDAO;
import Models.DangKyDeTai;
import Models.DeTai;
import Models.DeXuatDeTai;
import Models.NopNghiemThu;

/**
 * Servlet implementation class HandleDownLoad
 */
@WebServlet("/download")
@MultipartConfig
public class HandleDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDaDangKyDAO deTaiDaDangKyDAO;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleDownLoad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		deTaiDaDangKyDAO = new DeTaiDaDangKyDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/fileQuyetDinh":
				FileQuyetDinh(request, response);
				break;
			case "/fileMoTa":
				FileMoTa(request, response);
				break;
			case "/fileMoTaDeXuat":
				FileMoTaDeXuat(request, response);
				break;
			case "/fileMoTaDangKy":
				FileMoTaDangKy(request, response);
				break;
			case "/fileBaoCao":
				FileBaoCao(request, response);
				break;
			case "/fileHoSo":
				FileHoSo(request, response);
				break;
			default:
				System.out.println("df");
				break;
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void FileQuyetDinh(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		response.setContentType("application/octet-stream");
		String maDon = request.getParameter("maDon");
		System.out.print(maDon);
		DangKyDeTai ddk = null;
		try {
			ddk = deTaiDaDangKyDAO.LayDeTaiDaDK(maDon);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		byte[] fileData = ddk.getFileQuyetDinh();

		String fileName = "QuyetDinh_MaDon" + maDon + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();

	}

	private void FileMoTa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		response.setContentType("application/octet-stream");
		int maDT = Integer.parseInt(request.getParameter("maDT"));
		System.out.print("jeje");
		System.out.print(maDT);
		DeTai dt = null;
		try {
			dt = deTaiDaDangKyDAO.LayDeTai_MaDT(maDT);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		byte[] fileData = dt.getFileMoTaDeTai();

		String fileName = "MoTa_MaDeTai" + maDT + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}
	private void FileBaoCao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		response.setContentType("application/octet-stream");
		int maDT = Integer.parseInt(request.getParameter("maDT"));
		
		NopNghiemThu dt = null;
		dt = deTaiDaDangKyDAO.LayFileNghiemThu(maDT);
		

		byte[] fileData = dt.getFileBaoCao();

		String fileName = "FileBaoCaoDeTai_" + maDT + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}
	private void FileHoSo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {

		response.setContentType("application/octet-stream");
		int maDT = Integer.parseInt(request.getParameter("maDT"));
		
		NopNghiemThu dt = null;
		dt = deTaiDaDangKyDAO.LayFileNghiemThu(maDT);
		

		byte[] fileData = dt.getHoSoLienQuan();

		String fileName = "FileHoSoLienQuan_" + maDT + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}
	private void FileMoTaDeXuat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		DeTaiDAO detaiDAO = new DeTaiDAO();
		response.setContentType("application/octet-stream");
		int maDT = Integer.parseInt(request.getParameter("maDT"));
		System.out.print("jeje");
		System.out.print(maDT);
		DeXuatDeTai dt = null;
		dt = detaiDAO.LayDeXuatDeTaiBangMa(maDT);

		byte[] fileData = dt.getFileMoTaDeTai();

		String fileName = "MoTa_MaDeXuatDeTai" + maDT + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}
	private void FileMoTaDangKy (HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		DeTaiDAO detaiDAO = new DeTaiDAO();
		response.setContentType("application/octet-stream");
		int maDT = Integer.parseInt(request.getParameter("maDT"));
		DangKyDeTai dktd = detaiDAO.LayDangKyDeTaiBangMa(maDT);
		DeTai dt = null;
		try {
			dt = deTaiDaDangKyDAO.LayDeTai_MaDT(dktd.getMaDeTai());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		byte[] fileData = dt.getFileMoTaDeTai();

		String fileName = "MoTa_MaDeTai" + dktd.getMaDeTai() + ".doc";
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentLength(fileData.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(fileData));

		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}

}
