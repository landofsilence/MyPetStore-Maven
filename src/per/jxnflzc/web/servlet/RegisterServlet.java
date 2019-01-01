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
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private Account signonAccount;
	private AccountService accountService;

	private static final String REGISTER_FORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";
	private static final String MAIN_FORM = "/WEB-INF/jsp/catalog/Main.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String favouriteCategoryId = request.getParameter("favouriteCategoryId");
		String languagePreference = request.getParameter("languagePreference");
		boolean listOption = true;
		if(request.getParameter("listOption") == null){
			listOption = false;
		}
		boolean bannerOption = true;
		if(request.getParameter("bannerOption") == null){
			bannerOption = false;
		}
		String inputCaptcha = request.getParameter("inputCaptcha");
		HttpSession session = request.getSession();
		String captcha = (String)session.getAttribute("captcha");

		if(inputCaptcha.toLowerCase().equals(captcha.toLowerCase())){
			signonAccount = new Account();
			signonAccount.setUsername(username);
			signonAccount.setPassword(password);
			signonAccount.setEmail(email);
			signonAccount.setFirstName(firstName);
			signonAccount.setLastName(lastName);
			signonAccount.setAddress1(address1);
			signonAccount.setAddress2(address2);
			signonAccount.setCity(city);
			signonAccount.setState(state);
			signonAccount.setZip(zip);
			signonAccount.setCountry(country);
			signonAccount.setPhone(phone);
			signonAccount.setFavouriteCategoryId(favouriteCategoryId);
			signonAccount.setLanguagePreference(languagePreference);
			signonAccount.setListOption(listOption);
			signonAccount.setBannerOption(bannerOption);

			accountService = new AccountService();

			if(accountService.exist(signonAccount) == null){
				accountService.register(signonAccount);
				session.setAttribute("account", signonAccount);
				request.getRequestDispatcher(MAIN_FORM).forward(request, response);
			} else {
				String msg = "Account is EXIST!!!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher(REGISTER_FORM).forward(request, response);
			}
		} else {
			String msg = "Your Captcha is WRONG!!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(REGISTER_FORM).forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
