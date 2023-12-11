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

import DAO.DuyetDeTaiDAO;
import DAO.DuyetDeXuatDAO;
import DAO.ThamGiaDeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import Models.DeXuatDeTai;
import Models.Duyet;
import Models.ThamGiaDeTai;
import Models.ThoiGianNCKH;
import Models.ThongTinSinhVien;

@WebServlet("/detaicuatoi")
public class DeTaiCuaToiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DuyetDeXuatDAO dexuatCNDAO;
    private DuyetDeTaiDAO detaiCNDAO;
    private ThamGiaDeTaiDAO tgdtDAO;
    private ThoiGianNCKHDAO nckhDAO;
    private ThoiGianNCKH tg;

    public DeTaiCuaToiController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		dexuatCNDAO = new DuyetDeXuatDAO();
		detaiCNDAO = new DuyetDeTaiDAO();
		tgdtDAO = new ThamGiaDeTaiDAO();
		nckhDAO= new ThoiGianNCKHDAO();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		try {
			switch (action) {
			case "/new":
				showDeXuat_CN(request, response);
				break;
			case "/chitiet":
				showThanhVien(request, response);
				break;
			case "/add":
				addThanhVien(request, response);
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
		
		List<DeXuatDeTai> list1 = new ArrayList<>();
		list1 = detaiCNDAO.selectAllDeTaiCN("3");
		request.setAttribute("listCNDangKy", list1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTaiCuaToiCN.jsp");
		dispatcher.forward(request, response);
	}

	private void showThanhVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<ThamGiaDeTai> list1 = new ArrayList<>();
		int madetai = Integer.parseInt(request.getParameter("madetai"));
		list1 = tgdtDAO.ThamGiaDeTai_MaDeTai(madetai);
		List<ThamGiaDeTai> listSVTrong = new ArrayList<>();
		listSVTrong = tgdtDAO.SV_Trong();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemThanhVien.jsp");
		request.setAttribute("thamgiadetai", list1);
		request.setAttribute("svtrong", listSVTrong);
		request.setAttribute("madetai", madetai);
		dispatcher.forward(request, response);
	}

	private void addThanhVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		 String mssv = request.getParameter("mssv");		 
		 int madetai = Integer.parseInt(request.getParameter("madetai"));		 
		 String vaitro = request.getParameter("VaiTro");
		 System.out.print(madetai);
		 tg=nckhDAO.LayThoiGian();
		 ThamGiaDeTai tgdt= new ThamGiaDeTai(madetai,mssv,vaitro,tg.getMaThoiGianNCKH());
		 tgdtDAO.ThemSVThamGia(tgdt);	 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/detaicuatoi/chitiet");
		 List<ThamGiaDeTai> list1 = new ArrayList<>();
		 List<ThamGiaDeTai> listSVTrong = new ArrayList<>();
		 list1 = tgdtDAO.ThamGiaDeTai_MaDeTai(madetai);
		 listSVTrong = tgdtDAO.SV_Trong();
		 request.setAttribute("thamgiadetai", list1);
		 request.setAttribute("svtrong", listSVTrong);
		 request.setAttribute("madetai", madetai);
		 dispatcher.forward(request, response);
	}
}

