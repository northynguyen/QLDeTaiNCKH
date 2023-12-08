package Controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/duyetdexuat")
public class DuyetDeXuatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DuyetDeXuatController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
