package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import DAO.DeXuatDeTaiDAO;
import DAO.ThemDeTaiDAO;

/**
 * Servlet implementation class ThemDeTaiController
 */
@WebServlet("/ThemDeTai")
@MultipartConfig
public class ThemDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThemDeTaiDAO themDeTaiDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDeTaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	themDeTaiDAO = new ThemDeTaiDAO();

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/insert":
				insert(request, response);
				break;
			/*
			 * case "/showedit": showedit(request, response); break; case "/edit":
			 * edit(request, response); break;
			 */
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
		doGet(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {

		String tenDeTai = request.getParameter("tenDeTai");
		String kinhPhi = request.getParameter("kinhPhi");
		System.out.print("hehe");
		Part filePart = request.getPart("file");
		if (filePart != null && filePart.getSize() > 0) {
			InputStream fileContent = filePart.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fileContent.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, bytesRead);
			}
			byte[] fileData = byteArrayOutputStream.toByteArray();
			System.out.println("ImageData= " + fileData);
			themDeTaiDAO.ThemDeTai( tenDeTai, kinhPhi, fileData);
			System.out.println("is");
		} else {
			System.out.print("nono");
		}

		// deXuatDeTaiDAO.ThemDeXuat(maChuNhiem,tenDeTai,ngayDeXuat, kinhPhi);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Components/QuanLyDeTai.jsp");
		dispatcher.forward(request, response);

	}

}
