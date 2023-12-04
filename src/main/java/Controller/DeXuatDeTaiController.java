package Controller;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;

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

import DAO.DeXuatDeTaiDAO;
import Models.DeXuatDeTai;
import Models.ThongTinTaiKhoan;

/**
 * Servlet implementation class DeXuatDeTai
 */
@WebServlet("/DeXuatDeTai")
@MultipartConfig
public class DeXuatDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeXuatDeTaiDAO deXuatDeTaiDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeXuatDeTaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		deXuatDeTaiDAO = new DeXuatDeTaiDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/insert":
				insert(request, response);
				break;
			case "/edit":
				edit(request, response);
				break;
			default:
				System.out.println("df" );
				break;
		}} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException 
	{
		HttpSession session = request.getSession();
		/*
		 * ThongTinTaiKhoan account = (ThongTinTaiKhoan)
		 * session.getAttribute("account"); String maChuNhiem =
		 * Integer.toString(account.getMaTaiKhoan());
		 */
		String tenDeTai = request.getParameter("tenDeTai");
		String ngayDeXuat = request.getParameter("ngayDeXuat");
		String kinhPhi = request.getParameter("kinhPhi");
		System.out.print("hehe");
		Part filePart = request.getPart("file");
		if (filePart != null && filePart.getSize() > 0)
		{
			InputStream fileContent = filePart.getInputStream();
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = fileContent.read(buffer)) != -1) {
	            byteArrayOutputStream.write(buffer, 0, bytesRead);
	        }
	        byte[] fileData = byteArrayOutputStream.toByteArray();
	        System.out.println("ImageData= " + fileData);
	        deXuatDeTaiDAO.ThemDeXuat("1", tenDeTai, ngayDeXuat, kinhPhi,fileData);  
	        System.out.println("is" );
		}
		else
		{
			System.out.print("nono");
			}

		// deXuatDeTaiDAO.ThemDeXuat(maChuNhiem,tenDeTai,ngayDeXuat, kinhPhi);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Components/DeTaiCuaToiCN.jsp");
dispatcher.include(request, response);
		//response.sendRedirect(request.getContextPath() + "/Components/DeTaiCuaToiCN.jsp");
	}
	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException 
	{
		HttpSession session = request.getSession();
		/*
		 * ThongTinTaiKhoan account = (ThongTinTaiKhoan)
		 * session.getAttribute("account"); String maChuNhiem =
		 * Integer.toString(account.getMaTaiKhoan());
		 */
		String madt = request.getParameter("madt");
		DeXuatDeTai dx=deXuatDeTaiDAO.LayDeXuat_ByID(madt);
		
		

		// deXuatDeTaiDAO.ThemDeXuat(maChuNhiem,tenDeTai,ngayDeXuat, kinhPhi);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/Components/DeTaiCuaToiCN.jsp");
//		dispatcher.include(request, response);
		response.sendRedirect(request.getContextPath() + "/Components/DeTaiCuaToiCN.jsp");
	}

}
