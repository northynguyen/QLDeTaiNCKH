package Controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;

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
import DAO.LoginDAO;
import DAO.ThoiGianNCKHDAO;
import DAO.ThongBaoDAO;
import Models.DangKyDeTai;
import Models.DeTai;
import Models.DeXuatDeTai;
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
		case "/showquyetdinhduyet":
			try {
				ShowQuyetDinhDuyet(request, response);
			} catch (ClassNotFoundException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void ShowQuyetDinhDuyet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
		LoginDAO loginDAO = new LoginDAO();
		String MaDon = request.getParameter("MaDon");
		MaDon = "";
		String MaDeXuatDeTai = request.getParameter("MaDeXuatDeTai");
		MaDeXuatDeTai = "1";
		if (!MaDon.equals("")){
			DangKyDeTai dangkydetai = detaiDAO.LayDangKyDeTaiBangMa(Integer.parseInt(MaDon));		
			DeTai detai = detaiDAO.LayDeTaiBangMa(dangkydetai.getMaDeTai());
			ThongTinTaiKhoan thongtintaikhoan = loginDAO.KiemTraTaiKhoan(dangkydetai.getMaChuNhiem());
			request.setAttribute("dangkydetai", dangkydetai);
			request.setAttribute("thongtintaikhoan", thongtintaikhoan);
			request.setAttribute("detai", detai);
		}
		else {
			DeXuatDeTai dexuatdetai = detaiDAO.LayDeXuatDeTaiBangMa(Integer.parseInt(MaDeXuatDeTai));
			ThongTinTaiKhoan thongtintaikhoan = loginDAO.KiemTraTaiKhoan(dexuatdetai.getMaChuNhiem());
			request.setAttribute("thongtintaikhoan", thongtintaikhoan);
			request.setAttribute("dexuatdetai", dexuatdetai);
		}			
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuyetDinhDuyet.jsp");
		dispatcher.forward(request, response);					
	}
	public void QuyetDinhDuyet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		ThongTinTaiKhoan account = (ThongTinTaiKhoan) session.getAttribute("account");	
		String TenThongBao;
		String TenDeTai;
		String LoaiDuyet = request.getParameter("LoaiDuyet");
		String MaNguoiDuyet = account.getMaTaiKhoan();
		String GhiChu = request.getParameter("ghichu");
		Part filePart = request.getPart("file");
		String MaChuNhiem = request.getParameter("MaChuNhiem");
		byte[] FileQuyetDinh = null;
		if (filePart != null && filePart.getSize() > 0)
		{
			InputStream fileContent = filePart.getInputStream();
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = fileContent.read(buffer)) != -1) {
	            byteArrayOutputStream.write(buffer, 0, bytesRead);
	        }
	        FileQuyetDinh = byteArrayOutputStream.toByteArray();
		}
		if (LoaiDuyet.equals("DangKy")) {
			String MaDon = request.getParameter("madon");
			detaiDAO.DuyetDeTaiDangKy(FileQuyetDinh, MaNguoiDuyet, GhiChu, MaDon);
			TenThongBao = "Thông báo duyệt đề tài đăng ký";
			TenDeTai = request.getParameter("TenDeTai");
		}
		else {
			ThoiGianNCKH thoigian = thoigianNCKHDAO.LayThoiGianHienTai();
			int MaThoiGian = thoigian.getMaThoiGianNCKH();
			String MaDeXuatDeTai = request.getParameter("madexuat");			
			DeXuatDeTai dexuatdetai = detaiDAO.LayDeXuatDeTaiBangMa(Integer.parseInt(MaDeXuatDeTai));
			TenDeTai = dexuatdetai.getTenDeTai();
			int KinhPhi = dexuatdetai.getKinhPhi();
			byte[] FileMoTaDeTai = dexuatdetai.getFileMoTaDeTai();
			TenThongBao = "Thông báo duyệt đề tài đề xuất";
			try {
				detaiDAO.DuyetDeTaiDeXuat(MaThoiGian, MaDeXuatDeTai, FileQuyetDinh, MaNguoiDuyet, MaChuNhiem, GhiChu, TenDeTai, KinhPhi, FileMoTaDeTai);
			} catch (SQLException e) {
				System.out.print("Lỗi mất r");
				e.printStackTrace();
			}			
		}
		ThongBaoDAO thongbaoDAO = new ThongBaoDAO();
		java.util.Date utilDate = new java.util.Date();
        Date NgayThongBao = new Date(utilDate.getTime());
        String NoiDung ="Đề tài: " + TenDeTai +" đã được duyệt "
        		+ "Ghi chú: " + GhiChu; 
		thongbaoDAO.TaoThongBao(TenThongBao, NgayThongBao, MaChuNhiem, MaNguoiDuyet, NoiDung);
					
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TaoThongBao.jsp");
		dispatcher.forward(request, response);				
	}	

}
