package per.jxnflzc.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.util.SessionFactoryUtil;

/**
 * @author 河木
 * @version v1.0.0
 */
public class AccountService {
	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSession sqlSession = null;
	private AccountDAO accountDAO = null;

	public Account signon(Account loginAccount){
		Account result = null;
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		accountDAO = sqlSession.getMapper(AccountDAO.class);

		result = accountDAO.findAccountExistByUserNameAndPassword(loginAccount);
		if (result != null){
			result =  accountDAO.findByUserNameAndPassword(loginAccount);
		} else {
			result = null;
		}
		sqlSession.close();

		return result;
	}

	public Account exist(Account existAccount){
		return accountDAO.findAccountExistByUserNameAndPassword(existAccount);
	}

	public Account register(Account registerAccount){
		//accountDAO = new AccountDAOImpl();
		accountDAO.registerSignonByAccount(registerAccount);
		accountDAO.registerProfileByAccount(registerAccount);
		return accountDAO.registerAccountByAccount(registerAccount);
	}

	public boolean update(Account updateAccount){
		//accountDAO = new AccountDAOImpl();
		accountDAO.updateSignonByAccount(updateAccount);
		accountDAO.updateProfileByAccount(updateAccount);
		return accountDAO.updateAccountByAccount(updateAccount);
	}

	public Account load(Account account){
		//accountDAO = new AccountDAOImpl();
		return accountDAO.findEditAccount(account);
	}
}
