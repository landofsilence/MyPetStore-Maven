package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Account;
import per.jxnflzc.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "UsernameIsExistServlet", urlPatterns = "/usernameIsExist")
public class UsernameIsExistServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		Account account = new Account();
		account.setUsername(username);
		AccountService accountService = new AccountService();

		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();

		if(accountService.exist(account) != null){
			out.print("<msg>Exist</msg>");
		} else {
			out.print("<msg>NotExist</msg>");
		}
		out.flush();
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
