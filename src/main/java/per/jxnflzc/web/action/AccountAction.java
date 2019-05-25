package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.service.AccountService;
import per.jxnflzc.util.SessionFactoryUtil;

import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class AccountAction implements Action, ModelDriven<Account> {
	private Account account = new Account();
	private String inputCaptcha;
	private AccountService accountService;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getInputCaptcha() {
		return inputCaptcha;
	}

	public void setInputCaptcha(String inputCaptcha) {
		this.inputCaptcha = inputCaptcha;
	}

	@Override
	public String execute() throws Exception {

		return "success";
	}

	public String signon() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");
		accountService = new AccountService();

		String checkCode = (String)session.get("checkCode");

		if (getInputCaptcha().equals(checkCode)){
			Account result = accountService.signon(account);

			if (result != null){
				result = accountService.signon(result);
				session.put("account", result);
			} else {
				request.put("msg", "Your Username or Password is WRONG!!!");
				return "failed";
			}
			return "success";
		} else {
			request.put("msg", "Your Captcha is WRONG!!!");
			return "failed";
		}



	}

	public String signout() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");

		session.put("account", null);

		return "success";
	}

	public String register() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");

		String checkCode = (String)session.get("checkCode");

		if (getInputCaptcha().equals(checkCode)){
			accountService = new AccountService();
			accountService.register(account);

			return "success";
		} else {
			request.put("msg", "Your Captcha is WRONG!!!");
			return "failed";
		}

	}

	public String editForm() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();

		accountService = new AccountService();
		Account editAccount = (Account)session.get("account");
		editAccount = accountService.load(editAccount);
		session.put("account", editAccount);

		return "success";

	}

	public String edit() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");


		String checkCode = (String)session.get("checkCode");

		if (getInputCaptcha().equals(checkCode)){
			accountService = new AccountService();
			Account sessionAccount = (Account)session.get("account");

			if (account.getPassword().trim().equals("")){
				account.setPassword(sessionAccount.getPassword());
			}
			Account editAccount = (Account)session.get("account");
			account.setUsername(editAccount.getUsername());

			accountService.update(account);

			session.put("account", account);

			return "success";
		} else {
			return "failed";
		}


	}

	@Override
	public Account getModel() {
		return account;
	}
}
