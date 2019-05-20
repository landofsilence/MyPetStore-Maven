package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.util.SessionFactoryUtil;

import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class AccountAction implements Action, ModelDriven<Account> {
	private Account account = new Account();

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

		Account result = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);
			result = accountDAO.findAccountExistByUserNameAndPassword(account);
			if (result != null){
				result = accountDAO.findByUserNameAndPassword(result);
				session.put("account", result);
			} else {
				request.put("msg", "UserName or Password is WRONG!!!");
				return "failed";
			}
		}catch (Exception e){
			//e.printStackTrace();
		}finally {
			sqlSession.close();
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
