package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Account;
import per.jxnflzc.service.AccountService;

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
@WebServlet(name = "SignonServlet", urlPatterns = "/Signon")
public class SignonServlet extends HttpServlet {
	private Account signonAccount;
	private AccountService accountService;

	private static final String SIGNON_FORM = "/WEB-INF/jsp/account/SignonForm.jsp";
	private static final String MAIN_FORM = "/WEB-INF/jsp/catalog/Main.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String inputCaptcha = request.getParameter("inputCaptcha");
		HttpSession session = request.getSession();
		String captcha = (String)session.getAttribute("captcha");

		if(inputCaptcha.toLowerCase().equals(captcha.toLowerCase())){
			signonAccount = new Account();
			signonAccount.setUsername(username);
			signonAccount.setPassword(password);

			accountService = new AccountService();
			signonAccount = accountService.signon(signonAccount);

			if(signonAccount != null){
				accountService = new AccountService();
				signonAccount = accountService.load(signonAccount);
				session.setAttribute("account", signonAccount);
				request.getRequestDispatcher(MAIN_FORM).forward(request, response);
			} else {
				String msg = "UserName or Password is WRONG!!!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(SIGNON_FORM).forward(request, response);
			}
		} else {
			String msg = "Your Captcha is WRONG!!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(SIGNON_FORM).forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
