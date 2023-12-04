package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.ThongBao;
import Models.ThongTinTaiKhoan;
import DAO.ThongBaoDAO;

@WebServlet("/ThongBao/*")
public class ThongBaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private ThongBaoDAO thongBaoDAO;
    public ThongBaoController() {
        super();

    }
    public void init(ServletConfig config) throws ServletException {
    	thongBaoDAO = new ThongBaoDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/create":
			TaoThongBao(request, response);
			break;
		case "/show":
        	XemThongBao(request, response);
			break;

		default:
			System.out.println("df" );
			break;
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void XemThongBao (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
		if (account != null)
		{
			List < ThongBao > ListthongBao = thongBaoDAO.LayThongBao(account.getMaTaiKhoan());
			request.setAttribute("ListthongBao", ListthongBao);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBao.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void TaoThongBao (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
		
		String TenThongBao = request.getParameter("title");
		java.util.Date curDay = new java.util.Date();
        Date NgayThongBao = new Date(curDay.getTime());
		String MaNguoiNhan = request.getParameter("reciever");
		String MaNguoiGui = account.getMaTaiKhoan();
		String NoiDung = request.getParameter("content");
		List < ThongTinTaiKhoan > ListThongTinTaiKhoan = thongBaoDAO.LayNguoiNhan();
		request.setAttribute("ListThongTinTaiKhoan", ListThongTinTaiKhoan);
		request.removeAttribute("InformSuccess");
		if (MaNguoiNhan != null) {
			request.setAttribute("InformSuccess", "Đã gửi thông báo thành công!!!");
			thongBaoDAO.TaoThongBao(TenThongBao, NgayThongBao, MaNguoiNhan, MaNguoiGui, NoiDung);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TaoThongBao.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TaoThongBao.jsp");
			dispatcher.forward(request, response);
		}
		
	}


}
