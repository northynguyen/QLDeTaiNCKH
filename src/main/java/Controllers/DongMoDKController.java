package Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import DAO.ThoiGianNCKHDAO;
import DAO.ThongBaoDAO;
import Models.Khoa;


@WebServlet("/DongMoDK/*")
public class DongMoDKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThoiGianNCKHDAO thoigianDAO; 
    static boolean DaDong = false;
    static boolean DaMo = false;

    public DongMoDKController() {
        super();

    }
    public void init(ServletConfig config) throws ServletException {
    	thoigianDAO = new ThoiGianNCKHDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/dong":
			DongDK(request, response);
			break;
		case "/mo":
			MoDK(request, response);
			break;

		default:
			System.out.println("df" );
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void DongDK (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if (!DongMoDKController.DaDong) {
			boolean check = thoigianDAO.SoSanhNgayDong();
			if (check)
			{
				thoigianDAO.CapNhatTrangThaiDeTai("Đã đăng ký");
				request.setAttribute("suc", "Đóng thành công");
				DongMoDKController.DaMo = false;
				DongMoDKController.DaDong = true;
			}
			else {
				request.setAttribute("err", "Chưa tới thời gian đóng đăng ký");
			}
		}
		else {
			request.setAttribute("err", "Bạn đã đóng");
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyDongMoDK.jsp");
		dispatcher.forward(request, response);				
	}
	public void MoDK (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if (!DongMoDKController.DaMo) {
			boolean check = thoigianDAO.SoSanhNgayMo();
			if (check)
			{
				thoigianDAO.CapNhatTrangThaiDeTai("Trống");
				request.setAttribute("suc", "Mở thành công");
				DongMoDKController.DaMo = true;
				DongMoDKController.DaDong = false;
			}
			else {
				request.setAttribute("err", "Chưa tới thời gian mở đăng ký");
			}
		}
		else {
			request.setAttribute("err", "Bạn đã mở rồi");
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLyDongMoDK.jsp");
		dispatcher.forward(request, response);				
	}

}
