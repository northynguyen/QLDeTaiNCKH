package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.ThongTinTaiKhoan;
import DAO.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		loginDAO = new LoginDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.removeAttribute("errMsg");
		try {
			ThongTinTaiKhoan acc = new ThongTinTaiKhoan();
			acc = loginDAO.validate(username, password);
			HttpSession session = request.getSession();
			if (acc != null) {
				session.setAttribute("account", acc);
				if (acc.getRole().equals("Chủ nhiệm")) {
					//response.sendRedirect("./Components/ThongBao.jsp");

					 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBao/show");
					 dispatcher.forward(request, response);

				} else if (acc.getRole().equals("Quản lý"))
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBao/create");
					dispatcher.forward(request, response);

				}
				else if (acc.getRole().equals("Admin")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/TTTK/create");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("errMsg", "Sai tài khoản hoặc mật khẩu");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
