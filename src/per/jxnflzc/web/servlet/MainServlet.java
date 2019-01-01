package per.jxnflzc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 河木
 * @version v1.0.0
 */

@WebServlet(name = "MainServlet", urlPatterns = "/main")

public class MainServlet extends HttpServlet {
	private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(MAIN).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
