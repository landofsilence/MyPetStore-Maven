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
@WebServlet(name = "UpdateAccountServlet", urlPatterns = "/updateAccount")
public class UpdateAccountServlet extends HttpServlet {
	private Account updateAccount;
	private AccountService accountService;

	private static final String EDIT_ACCOUNT_FORM = "/WEB-INF/jsp/account/EditAccountForm.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username = ((Account)session.getAttribute("account")).getUsername();
		String password = request.getParameter("password");
		System.out.println("password = " + password);
		Account account = (Account)session.getAttribute("account");
		System.out.println("account.getPassword() = " + account.getPassword());
		if(password.isEmpty()){
			password = account.getPassword();
		}
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
		String captcha = (String)session.getAttribute("captcha");

		if(inputCaptcha.toLowerCase().equals(captcha.toLowerCase())) {
			updateAccount = new Account();
			updateAccount.setUsername(username);
			updateAccount.setPassword(password);
			updateAccount.setEmail(email);
			updateAccount.setFirstName(firstName);
			updateAccount.setLastName(lastName);
			updateAccount.setAddress1(address1);
			updateAccount.setAddress2(address2);
			updateAccount.setCity(city);
			updateAccount.setState(state);
			updateAccount.setZip(zip);
			updateAccount.setCountry(country);
			updateAccount.setPhone(phone);
			updateAccount.setFavouriteCategoryId(favouriteCategoryId);
			updateAccount.setLanguagePreference(languagePreference);
			updateAccount.setListOption(listOption);
			updateAccount.setBannerOption(bannerOption);

			accountService = new AccountService();
			boolean suc = accountService.update(updateAccount);

			if(suc){
				session.setAttribute("account", updateAccount);
				String msg = "Edit SUCCESSFULLY!!!";
				request.setAttribute("msg", msg);
			} else {
				String msg = "Edit FAILED!!!";
				request.setAttribute("msg", msg);
			}
		} else {
			String msg = "Captcha is NOT TRUE!!!";
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher(EDIT_ACCOUNT_FORM).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
