package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import DAO.LoginDAO;
import DAO.ThemDeTaiDAO;
import DAO.ThongTinSinhVienDAO;
import Models.Khoa;
import Models.ThoiGianNCKH;
import Models.ThongTinSinhVien;
import Models.ThongTinTaiKhoan;


@WebServlet("/TTSV/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ThongTinSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongTinSinhVienDAO thongtinsinhvienDAO;
  
    public ThongTinSinhVienController() {
        super();
        
    }
    public void init(ServletConfig config) throws ServletException {
    	thongtinsinhvienDAO = new ThongTinSinhVienDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		request.setCharacterEncoding("UTF-8");
		switch (action) {
		case "/createThuCong":
			try {
				ThemSuaSinhVienThuCong(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/createExcel":
			try {
				ThemSinhVienExcel(request, response);
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/show":
			ShowSinhVien(request, response);			
			break;
		case "/delete":
			XoaSinhVien(request, response);			
			break;

		default:
			System.out.println("df" );
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void ThemSuaSinhVienThuCong (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {	
		String HoTen = request.getParameter("name");
		String GioiTinh = request.getParameter("gender");
		String MaKhoa = request.getParameter("khoa");
		String SDT = request.getParameter("sdt");
		String Email = request.getParameter("email");
		String DiaChi = request.getParameter("address");
		String MSSV = request.getParameter("MSSV");
		
		request.removeAttribute("errSignUp");
		request.removeAttribute("EmailErr");
		request.removeAttribute("suc");
		String Loai = request.getParameter("loai");
		if (Loai.equals("them")) {
			ThongTinSinhVien sinhvien = new ThongTinSinhVien();
			sinhvien = thongtinsinhvienDAO.KiemTraMSSinhVien(MSSV);
			ThongTinSinhVien emalsinhvien = new ThongTinSinhVien();
			emalsinhvien = thongtinsinhvienDAO.KiemTraEmailSinhVien(Email);
			if (sinhvien != null) {
				request.setAttribute("SignUpErr", "MSSV đã tồn tại, hãy kiểm tra lại!!!");
			}else if (emalsinhvien != null) {
				request.setAttribute("EmailErr", "Email đã tồn tại, hãy kiểm tra lại!!!");
			}else {
				request.setAttribute("suc", "Thêm thành công!!!");
				thongtinsinhvienDAO.TaoSinhVien(MSSV, HoTen, GioiTinh, MaKhoa, SDT, Email, DiaChi);
			}	
		}
		else {
			thongtinsinhvienDAO.SuaSinhVien(MSSV, HoTen, GioiTinh, MaKhoa, SDT, Email, DiaChi);
			request.setAttribute("suc", "Sửa thành công");
		}
		request.setAttribute("loai", Loai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TTSV/show");
		dispatcher.forward(request, response);
	}
	public void ThemSinhVienExcel (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		request.removeAttribute("errExcel");
		request.removeAttribute("sucExcel");
		try {
            Part filePart = request.getPart("excelFile");
            InputStream fileContent = filePart.getInputStream();

            XSSFWorkbook workbook = new XSSFWorkbook(fileContent);
            XSSFSheet sheet = workbook.getSheetAt(0); // Láº¥y sheet Ä‘áº§u tiÃªn
            DataFormatter dataFormatter = new DataFormatter();
            boolean check = false;
            for (Row row : sheet) {
            	    String MSSV = dataFormatter.formatCellValue(row.getCell(0));
            	    String HoTen = dataFormatter.formatCellValue(row.getCell(1));
            	    String GioiTinh = dataFormatter.formatCellValue(row.getCell(2));
            	    String MaKhoa = dataFormatter.formatCellValue(row.getCell(3));
            	    String SoDienThoai = dataFormatter.formatCellValue(row.getCell(4));
            	    String Email = dataFormatter.formatCellValue(row.getCell(5));
            	    String DiaChi = dataFormatter.formatCellValue(row.getCell(6));
                if (thongtinsinhvienDAO.TaoSinhVien(MSSV, HoTen, GioiTinh, MaKhoa, SoDienThoai, Email, DiaChi)) {
                	check = true;
                }
            }
            if (check) {
            	request.setAttribute("sucExcel", "Thêm thành công");
            }else {
            	request.setAttribute("errExcel", "Thêm thất bại, hãy kiểm tra định dạng file");
            }
            
            workbook.close();
            fileContent.close();
        } catch (Exception e) {      	
            e.printStackTrace();
        }
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TTSV/show");
        dispatcher.forward(request, response);
	}
	public void ShowSinhVien (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		List<ThongTinSinhVien> listSinhVien = thongtinsinhvienDAO.LayToanBoSinhVien();
		request.setAttribute("listSinhVien", listSinhVien);
		List <Khoa> ListKhoa = loginDAO.LayKhoa();
		request.setAttribute("ListKhoa", ListKhoa);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLySinhVien.jsp");
		dispatcher.forward(request, response);	
	}
	public void XoaSinhVien (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("err");
		request.removeAttribute("suc");
		String MSSV = request.getParameter("mssvlist");	
		if (!thongtinsinhvienDAO.XoaSinhVien(MSSV)) {
			request.setAttribute("err", "Xóa thất bại do sinh viên này đã tham gia đề tài");
		}
		else {			
			request.setAttribute("suc", "Xóa thành công");
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TTSV/show");
		dispatcher.forward(request, response);		
	}
}
	
