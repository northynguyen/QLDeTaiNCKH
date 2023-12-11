package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Models.Khoa;
import Models.ThongTinSinhVien;
import Models.ThongTinTaiKhoan;


@WebServlet("/TTTK/*")
public class ThongTinTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ThongTinTaiKhoanController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/create":
			try {
				TaoTaiKhoan(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		

		default:
			System.out.println("df" );
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void TaoTaiKhoan (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
		LoginDAO loginDAO = new LoginDAO();
		
		String HoTen = request.getParameter("name");
		String GioiTinh = request.getParameter("gender");
		String MaKhoa = request.getParameter("khoa");
		String SDT = request.getParameter("sdt");
		String Email = request.getParameter("email");
		String DiaChi = request.getParameter("address");
		String MaTK = request.getParameter("MaTK");
		String MatKhau = request.getParameter("password");
		String Role = request.getParameter("role");
		
		List <Khoa> ListKhoa = loginDAO.LayKhoa();
		request.setAttribute("ListKhoa", ListKhoa);
		request.removeAttribute("errSignUp");
		request.removeAttribute("EmailErr");
		request.removeAttribute("SignUpSucsses");
		if (MaKhoa != null)
		{	
			ThongTinTaiKhoan acc = new ThongTinTaiKhoan();
			acc = loginDAO.KiemTraTaiKhoan(MaTK);
			ThongTinTaiKhoan emalTaiKhoan = new ThongTinTaiKhoan();
			emalTaiKhoan = loginDAO.KiemTraEmail(Email);
			if (acc != null) {
				request.setAttribute("SignUpErr", "Tên tài khoản đã tồn tại. Vui lòng thử lại!");
			}else if (emalTaiKhoan != null) {
				request.setAttribute("EmailErr", "Email đã tồn tại, hãy kiểm tra lại!!!");
			}else {
				request.setAttribute("SignUpSucsses", "Đăng ký thành công!!!");
				loginDAO.TaoTaiKhoan(MaTK, MatKhau, Role, HoTen, GioiTinh, MaKhoa, SDT, Email, DiaChi);
			}			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TaoTaiKhoan.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TaoTaiKhoan.jsp");
			dispatcher.forward(request, response);
		}
	}

}
