package Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

import DAO.DeTaiDaDangKyDAO;
import DAO.DeXuatDeTaiDAO;
import Models.DangKyDeTai;

/**
 * Servlet implementation class DeTaiDaDangKyController
 */
@WebServlet("/DeTaiDaDangKy")
@MultipartConfig
public class DeTaiDaDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDaDangKyDAO deTaiDaDangKyDAO;   

    public DeTaiDaDangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	deTaiDaDangKyDAO = new DeTaiDaDangKyDAO();

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/view":
				view(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void view(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {
		
		 List<DangKyDeTai> ddk=deTaiDaDangKyDAO.XemDeTaiDaDK();
		
		  request.setAttribute("ddk", ddk);
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/Components/DeTaiDaDuocDangKy.jsp");
	       dispatcher.forward(request, response);
	}

}
