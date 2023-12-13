package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import Models.DeTai;
import Models.ThoiGianNCKH;

@WebServlet("/quanlydetai")
@MultipartConfig
public class QuanLyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO detaiDAO;
	private ThoiGianNCKHDAO thoigianNCKHDAO;
	private DeTai detai;

	public void init(ServletConfig config) throws ServletException {
		detaiDAO = new DeTaiDAO();
		thoigianNCKHDAO = new ThoiGianNCKHDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/new":
				showDeTai(request, response);
				break;
			case "/add":
				themDeTai(request, response);
				break;
			case "/delete":
				xoaDeTai(request, response);
				break;
			case "/update":
				suaDeTai(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyDeTai.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showDeTai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<DeTai> listDeTai = detaiDAO.selectAllDeTai1();
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyDeTai.jsp");
		dispatcher.forward(request, response);
	}
	private void themDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String tendetai = request.getParameter("tendetai");
		int kinhphi = Integer.parseInt(request.getParameter("kinhphi"));
		Part filePart = request.getPart("file");
		byte[] FileBaoCao = null;
		if (filePart != null && filePart.getSize() > 0)
		{
			InputStream fileContent = filePart.getInputStream();
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = fileContent.read(buffer)) != -1) {
	            byteArrayOutputStream.write(buffer, 0, bytesRead);
	        }
	        FileBaoCao = byteArrayOutputStream.toByteArray();
		}
		String trangthai= request.getParameter("trangthai");
		detai=new DeTai(tendetai,kinhphi,FileBaoCao,trangthai);
		detaiDAO.themDeTai(detai);
		response.sendRedirect("new");
	}

	private void suaDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int madetai = Integer.parseInt(request.getParameter("madetai"));
		String tendetai = request.getParameter("tendetai");
		int kinhphi = Integer.parseInt(request.getParameter("kinhphi"));
		Part filePart = request.getPart("file");
		byte[] FileBaoCao = null;
		if (filePart != null && filePart.getSize() > 0)
		{
			InputStream fileContent = filePart.getInputStream();
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = fileContent.read(buffer)) != -1) {
	            byteArrayOutputStream.write(buffer, 0, bytesRead);
	        }
	        FileBaoCao = byteArrayOutputStream.toByteArray();
		}
		String trangthai= request.getParameter("trangthai");
		detai=new DeTai(madetai,tendetai,kinhphi,null,trangthai);
		detaiDAO.suaDeTai(detai);
		response.sendRedirect("new");
	}

	private void xoaDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int madetai = Integer.parseInt(request.getParameter("madetai"));
			detaiDAO.xoaDeTai(madetai);
			response.sendRedirect("new");
	}

}