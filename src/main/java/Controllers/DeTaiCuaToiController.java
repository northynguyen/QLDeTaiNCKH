package Controllers;

import java.io.IOException;
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

import DAO.DuyetDeXuatDAO;
import Models.DeXuatDeTai;
import Models.Duyet;

@WebServlet("/detaicuatoi")
public class DeTaiCuaToiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DuyetDeXuatDAO dexuatCNDAO;   

    public DeTaiCuaToiController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		dexuatCNDAO = new DuyetDeXuatDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/new":
				showDeXuat_CN(request, response);
				break;
			case "/new2":
				showCNDangKy(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTaiCuaToiCN.jsp");
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
	private void showDeXuat_CN(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<DeXuatDeTai> list = new ArrayList<>();
		list = dexuatCNDAO.selectAllDeTaiCN("3");
		request.setAttribute("listDeXuat", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTaiCuaToiCN.jsp");
		dispatcher.forward(request, response);
	}
	private void showCNDangKy(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<DeXuatDeTai> list = new ArrayList<>();
		list = dexuatCNDAO.selectAllDeTaiCN("3");
		request.setAttribute("listCNDangKy", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTaiCuaToiCN.jsp");
		dispatcher.forward(request, response);
	}
}
