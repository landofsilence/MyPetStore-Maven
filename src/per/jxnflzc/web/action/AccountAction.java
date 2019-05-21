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
	private AccountService accountService;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

		System.out.println(account.getUsername());

		Account result = accountService.signon(account);

		if (result != null){
			result = accountService.signon(result);
			session.put("account", result);
		} else {
			request.put("msg", "Your Username or Password is WRONG!!!");
			return "failed";
		}

		return "success";
	}

	public String signout() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");

		session.put("account", null);

		return "success";
	}

	@Override
	public Account getModel() {
		return account;
	}
}
