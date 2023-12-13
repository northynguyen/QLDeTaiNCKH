package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import DAO.DeTaiDAO;
import DAO.NghiemThuDAO;
import DAO.ThemDeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import DAO.ThongBaoDAO;
import Models.DangKyDeTai;
import Models.DeTai;
import Models.NghiemThu;
import Models.NopDeTai;
import Models.ThoiGianNCKH;
import Models.ThongTinTaiKhoan;

/**
 * Servlet implementation class NghiemThuController
 */
@WebServlet("/NghiemThu")
@MultipartConfig
public class NghiemThuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NghiemThuDAO nghiemThuDAO;
	private DeTaiDAO detaiDAO;
	private ThoiGianNCKHDAO thoigianNCKHDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NghiemThuController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	nghiemThuDAO = new NghiemThuDAO();
    	detaiDAO=new DeTaiDAO();
    	thoigianNCKHDAO=new ThoiGianNCKHDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		request.setCharacterEncoding("UTF-8");
		System.out.print(action);
		try {
			switch (action) {
			case "/showall":
				showall(request, response);
				break;
			case "/showSubmit":
				ShowNopNghiemThu(request, response);
				break;
			case "/submit":
				System.out.print("hehe");
				Submit(request, response);
				break;
			default:
				System.out.print("VL");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
	
	private void showall(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
		request.setAttribute("account", account);
		System.out.print("hehe");
		List<NopDeTai> list= nghiemThuDAO.ShowAllNopDT();
		request.setAttribute("listNop", list);
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NopDeTai_QL.jsp");
		dispatcher.forward(request, response);

	}
	public void ShowNopNghiemThu (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		String MaNopDeTai  = request.getParameter("MaDon");
		NghiemThu NT = nghiemThuDAO.LayNhiemThu_MNDT(MaNopDeTai);		
		NopDeTai nopDeTai= nghiemThuDAO.LayNopDeTai_MNDT(MaNopDeTai);
		DeTai detai = detaiDAO.LayDeTaiBangMa(nopDeTai.getMaDeTai());	
		ThoiGianNCKH thoigian = thoigianNCKHDAO.LayThoiGianDK(nopDeTai.getMaThoiGian());
	

		request.setAttribute("nopDeTai", nopDeTai);
		request.setAttribute("nghiemthu", NT);
		request.setAttribute("detai", detai);
		request.setAttribute("thoigian", thoigian);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NopNghiemThu_QL.jsp");
		dispatcher.forward(request, response);				
	}
	private void Submit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException, ParseException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");
		request.setAttribute("account", account);
	
			String MaNghiemThu = request.getParameter("MaNghiemThu");
			String MaNopDeTai=request.getParameter("MaNopDeTai");
			String MaNguoiNghiemThu=request.getParameter("MaNguoiNghiemThu");
			String NgayNghiemThu=request.getParameter("NgayNghiemThu");
			NopDeTai nopDeTai= nghiemThuDAO.LayNopDeTai_MNDT(MaNopDeTai);
			
			String diem=request.getParameter("diem");
			String binhluan=request.getParameter("binhluan");
			String TrangThai=request.getParameter("TrangThai");
			
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = currentDate.format(formatter);
			System.out.print(MaNghiemThu);
			System.out.print(MaNopDeTai);
			System.out.print(diem);
			System.out.print(binhluan);
			System.out.print(TrangThai);
			
			NghiemThu NT = nghiemThuDAO.LayNhiemThu_MNDT(MaNopDeTai);		

			Part filePart = request.getPart("file");
			byte[] FileBaoCao = null;
			if (filePart != null && filePart.getSize() > 0)
			{
				InputStream fileContent = filePart.getInputStream();
		        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		        byte[] buffer = new byte[1024];
		        int bytesRead;
		        while ((bytesRead = fileContent.read(buffer)) != -1) {
		            byteArrayOutputStream.write(buffer, 0, bytesRead);
		        }
		        FileBaoCao = byteArrayOutputStream.toByteArray();
			}
			if (nopDeTai.getTrangThai().equals("Đã nghiệm thu"))
			{
				if(FileBaoCao==null) {
					nghiemThuDAO.EditNghiemThu(Integer.parseInt(MaNghiemThu),Integer.parseInt(MaNopDeTai), account.getMaTaiKhoan(), formattedDate, NT.getTaiLieuNghiemThu(), diem, binhluan);
				}
				else
				{
					nghiemThuDAO.EditNghiemThu(Integer.parseInt(MaNghiemThu),Integer.parseInt(MaNopDeTai), account.getMaTaiKhoan(), formattedDate, FileBaoCao, diem, binhluan);
				}
				
			}
			else {
				nghiemThuDAO.ThemNghiemThu(Integer.parseInt(MaNopDeTai), account.getMaTaiKhoan(), formattedDate, FileBaoCao, diem, binhluan);
				nghiemThuDAO.CapNhapNghiemThu_NOP(NT.getMaNopDeTai());
				
			}
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NghiemThu/showall");
			dispatcher.forward(request, response);				
		
	}

}
