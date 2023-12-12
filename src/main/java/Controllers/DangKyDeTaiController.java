package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import DAO.DangKyDeTaiDAO;
import DAO.DeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import Models.DeTai;
import Models.ThoiGianNCKH;
import Models.ThongTinTaiKhoan;
import Models.DangKyDeTai;

@WebServlet("/dangkydetai")
public class DangKyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO detaiDAO;
	private ThoiGianNCKHDAO thoigianNCKHDAO;
	private DangKyDeTaiDAO dangkydetaiDAO;
	private ThoiGianNCKH tgNCKH;
	
	public void init(ServletConfig config) throws ServletException {
		detaiDAO= new DeTaiDAO();
		thoigianNCKHDAO= new ThoiGianNCKHDAO();
		dangkydetaiDAO = new DangKyDeTaiDAO();
		tgNCKH  = new ThoiGianNCKH();
		tgNCKH = thoigianNCKHDAO.LayThoiGian();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		try {
            switch (action) {
                case "/new":
                    showDeTai(request, response);
                    break;
                case "/dangky":
                    dkDeTai(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/DangKyDeTai.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}
	
	private void showDeTai(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		List <DeTai> listDeTai = new ArrayList<>(); 
		request.removeAttribute("err");
		if (tgNCKH != null) {
			listDeTai = detaiDAO.selectAllDeTai();			
        }
		else
		{
			request.setAttribute("err", "Chưa tới thời gian đăng ký, hãy quay lại sau!!");
		}
		request.setAttribute("listDeTai",listDeTai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DangKyDeTai.jsp");
        dispatcher.forward(request, response);
	}
	private void dkDeTai(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");	
		int madetai = Integer.parseInt(request.getParameter("madetai"));
		DangKyDeTai dkdt=new DangKyDeTai(madetai,account.getMaTaiKhoan(),tgNCKH.getMaThoiGianNCKH(),"Chưa duyệt");
		dangkydetaiDAO.dkDeTai(dkdt);
		response.sendRedirect("new");
	}
}