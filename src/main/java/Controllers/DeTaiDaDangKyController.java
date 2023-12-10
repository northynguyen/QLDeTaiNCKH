package Controllers;

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
import Models.DeTai;
import Models.ThanhVienThamGiaDeTai;
import Models.ThongTinTaiKhoan;

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
			case "/chitiet":
				chitiet(request, response);
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

	private void chitiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {
		
		 String maDon=request.getParameter("maDon");
		 request.setAttribute("maDon", maDon);
		 DangKyDeTai dkdt= deTaiDaDangKyDAO.LayDeTaiDaDK(maDon);
		 
		 int maDT=dkdt.getMaDeTai();
		 String maCN=dkdt.getMaChuNhiem();
		 int maTG=dkdt.getMaThoiGian();
		 
		 DeTai dt=deTaiDaDangKyDAO.LayDeTai_MaDT(maDT);
		 request.setAttribute("dt", dt);
		 
		 
		 ThongTinTaiKhoan tttk=deTaiDaDangKyDAO.LayChuNhiem_MaCN(maCN);
		 request.setAttribute("cn", tttk);
		 
		 List<ThanhVienThamGiaDeTai> tv=deTaiDaDangKyDAO.LayThanhVien_MaDT_MaTG(maDT, maTG);
		 System.out.print(tv);System.out.print(maTG);
		 request.setAttribute("tv", tv);
		
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/Components/ChiTietDDK.jsp");
	       dispatcher.forward(request, response);
	}

}
