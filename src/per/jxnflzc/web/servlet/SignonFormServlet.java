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

@WebServlet(name = "SignonFormServlet", urlPatterns = "/SignonForm")
public class SignonFormServlet extends HttpServlet {
	private static final String LOGIN_FORM = "/WEB-INF/jsp/account/SignonForm.jsp";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(LOGIN_FORM).forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
