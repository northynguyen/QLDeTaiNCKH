package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import Models.DeTai;
import Models.ThoiGianNCKH;

@WebServlet("/quanlydetai")
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
		List<DeTai> listDeTai = detaiDAO.selectAllDeTai();
		request.setAttribute("listDeTai", listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyDeTai.jsp");
		dispatcher.forward(request, response);
	}
	private void themDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String tendetai = request.getParameter("tendetai");
		int kinhphi = Integer.parseInt(request.getParameter("kinhphi"));
		//Byte[] filemota = request.getParameter("chontep");
		String trangthai= request.getParameter("trangthai");
		detai=new DeTai(tendetai,kinhphi,null,trangthai);
		detaiDAO.themDeTai(detai);
		response.sendRedirect("new");
	}

	private void suaDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int madetai = Integer.parseInt(request.getParameter("madetai"));
		String tendetai = request.getParameter("tendetai");
		int kinhphi = Integer.parseInt(request.getParameter("kinhphi"));
		//Byte[] filemota = request.getParameter("chontep");
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
