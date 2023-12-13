package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAO.DuyetDeTaiDAO;
import DAO.ThongBaoDAO;
import Models.DangKyDeTai;
import Models.DeTai;
import Models.Duyet;
import Models.ThongTinTaiKhoan;


@WebServlet("/duyetdetai")
public class DuyetDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DuyetDeTaiDAO duyetdetaiDAO;

	public DuyetDeTaiController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		duyetdetaiDAO = new DuyetDeTaiDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/new":
				showDuyetDeTai(request, response);
				break;
			case "/dangky":

				break;
			case "/xoa":
				khongDuyet(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DuyetDeTai.jsp");
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

	private void showDuyetDeTai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Duyet> listDuyet = new ArrayList<>();
		listDuyet = duyetdetaiDAO.selectAllDeTaiDuyet();
		request.setAttribute("listDuyet", listDuyet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DuyetDeTai.jsp");
		dispatcher.forward(request, response);
	}
	private void khongDuyet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");	
		DeTaiDAO detaiDAO = new DeTaiDAO();
		ThongBaoDAO thongbaoDAO = new ThongBaoDAO();
		int maDon = Integer.parseInt(request.getParameter("MaDon"));
		DangKyDeTai dangkydetai = detaiDAO.LayDangKyDeTaiBangMa(maDon);
		String LyDo= request.getParameter("GhiChu");
		duyetdetaiDAO.TuChoi(maDon, LyDo);
		String MaChuNhiem = dangkydetai.getMaChuNhiem();
		String TenDeTai = request.getParameter("TenDeTai");
		String MaNguoiDuyet = account.getMaTaiKhoan();
		java.util.Date utilDate = new java.util.Date();
        Date NgayThongBao = new Date(utilDate.getTime());
		String TenThongBao = "Thông báo từ chối duyệt đề tài";
		String NoiDung ="Đề tài: " + TenDeTai +" chưa được duyệt "
        		+ "Lý do: " + LyDo; 
		thongbaoDAO.TaoThongBao(TenThongBao, NgayThongBao, MaChuNhiem, MaNguoiDuyet, NoiDung);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/duyetdetai/new");
		dispatcher.forward(request, response);
	}
}