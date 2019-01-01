package per.jxnflzc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "SignoutServlet", urlPatterns = "/Signout")
public class SignoutServlet extends HttpServlet {
	private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("account", null);

		request.getRequestDispatcher(MAIN).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
