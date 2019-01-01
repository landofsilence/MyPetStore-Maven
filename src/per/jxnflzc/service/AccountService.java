package per.jxnflzc.service;

import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.persistence.impl.AccountDAOImpl;

/**
 * @author 河木
 * @version v1.0.0
 */
public class AccountService {
	private AccountDAO userDAO;

	public Account signon(Account loginAccount){
		userDAO = new AccountDAOImpl();
		return userDAO.findByUserNameAndPassword(loginAccount);
	}

	public Account exist(Account registerAccount){
		userDAO = new AccountDAOImpl();
		return userDAO.findByUserName(registerAccount);
	}

	public Account register(Account registerAccount){
		userDAO = new AccountDAOImpl();
		userDAO.registerSignonByAccount(registerAccount);
		userDAO.registerProfileByAccount(registerAccount);
		return userDAO.registerAccountByAccount(registerAccount);
	}

	public boolean update(Account updateAccount){
		userDAO = new AccountDAOImpl();
		userDAO.updateSignonByAccount(updateAccount);
		userDAO.updateProfileByAccount(updateAccount);
		return userDAO.updateAccountByAccount(updateAccount);
	}

	public Account load(Account account){
		userDAO = new AccountDAOImpl();
		return userDAO.findEditAccount(account);
	}
}
