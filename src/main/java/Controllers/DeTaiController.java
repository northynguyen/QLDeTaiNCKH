package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAO.ThoiGianNCKHDAO;
import DAO.ThongBaoDAO;
import Models.DangKyDeTai;
import Models.DeTai;
import Models.NopDeTai;
import Models.ThoiGianNCKH;
import Models.ThongTinTaiKhoan;


@WebServlet("/DeTai/*")
@MultipartConfig
public class DeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DeTaiDAO detaiDAO;
    private ThoiGianNCKHDAO thoigianNCKHDAO;

    public DeTaiController() {
        super();

    }
    public void init(ServletConfig config) throws ServletException {
    	detaiDAO = new DeTaiDAO();
    	thoigianNCKHDAO = new ThoiGianNCKHDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/showsubmit":
			ShowNopDeTai(request, response);
			break;
		case "/submit":
			NopDeTai(request, response);
			break;
		case "/quyetdinhduyet":
			QuyetDinhDuyet(request, response);
			break;
		default:
			System.out.println("df" );
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void NopDeTai (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");				
		String MaDeTaistr = request.getParameter("MaDeTai");
		System.out.print(MaDeTaistr);
		int MaDeTai =Integer.parseInt(MaDeTaistr);
		int MaThoiGian = Integer.parseInt(request.getParameter("MaThoiGian"));
		String MaNopDeTaistr = request.getParameter("MaNopDeTai");
		int MaNopDeTai = -1;
		if (!MaNopDeTaistr.equals(""))
		{
			MaNopDeTai  = Integer.parseInt(MaNopDeTaistr);
		}
		String Ghichu = request.getParameter("ghichu");
		String TrangThai = request.getParameter("TrangThai");
		String MaNguoiNop = account.getMaTaiKhoan();
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
		if (TrangThai.equals("Đã nộp"))
		{
			if (FileBaoCao == null) {
				detaiDAO.CapNhatNopDeTaiKhongCoFile(MaNopDeTai, Ghichu);
			}
			else {
				detaiDAO.CapNhatNopDeTai(MaNopDeTai, FileBaoCao, Ghichu);
			}
		}
		else {
			detaiDAO.NopDeTai(MaDeTai, MaNguoiNop, FileBaoCao, MaThoiGian, Ghichu, TrangThai);
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTai/showsubmit");
		dispatcher.forward(request, response);				
	}	
	public void ShowNopDeTai (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String MaDon = request.getParameter("MaDon");
		MaDon = "2";		
		DangKyDeTai dangkydetai = detaiDAO.LayDangKyDeTaiBangMa(Integer.parseInt(MaDon));		
		DeTai detai = detaiDAO.LayDeTaiBangMa(dangkydetai.getMaDeTai());	
		ThoiGianNCKH thoigian = thoigianNCKHDAO.LayThoiGianDK(dangkydetai.getMaThoiGian());
		NopDeTai nopdetai = detaiDAO.LayNopDeTai(dangkydetai.getMaDeTai(), dangkydetai.getMaThoiGian());
		request.setAttribute("dangkydetai", dangkydetai);
		request.setAttribute("thoigian", thoigian);
		request.setAttribute("detai", detai);	
		request.setAttribute("nopdetai", nopdetai);
		String TrangThai = "Chưa nộp";
		if (nopdetai != null) {
			TrangThai = "Đã nộp";
		}
		request.setAttribute("TrangThai", TrangThai);	
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NopDeTaiCN.jsp");
		dispatcher.forward(request, response);				
	}
	public void QuyetDinhDuyet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");				
		String MaDon = request.getParameter("MaDon");
		MaDon = "2";		
		DangKyDeTai dangkydetai = detaiDAO.LayDangKyDeTaiBangMa(Integer.parseInt(MaDon));
		request.setAttribute("dangkydetai", dangkydetai);
		String MaDeTaistr = request.getParameter("MaDeTai");
		System.out.print(MaDeTaistr);
		int MaDeTai =Integer.parseInt(MaDeTaistr);
		int MaThoiGian = Integer.parseInt(request.getParameter("MaThoiGian"));
		String MaNopDeTaistr = request.getParameter("MaNopDeTai");
		int MaNopDeTai = -1;
		if (!MaNopDeTaistr.equals(""))
		{
			MaNopDeTai  = Integer.parseInt(MaNopDeTaistr);
		}
		String Ghichu = request.getParameter("ghichu");
		String TrangThai = request.getParameter("TrangThai");
		String MaNguoiNop = account.getMaTaiKhoan();
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
		if (TrangThai.equals("Đã nộp"))
		{
			if (FileBaoCao == null) {
				detaiDAO.CapNhatNopDeTaiKhongCoFile(MaNopDeTai, Ghichu);
			}
			else {
				detaiDAO.CapNhatNopDeTai(MaNopDeTai, FileBaoCao, Ghichu);
			}
		}
		else {
			detaiDAO.NopDeTai(MaDeTai, MaNguoiNop, FileBaoCao, MaThoiGian, Ghichu, TrangThai);
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTai/showsubmit");
		dispatcher.forward(request, response);				
	}

}
