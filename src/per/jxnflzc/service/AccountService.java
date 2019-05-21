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
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		accountDAO = sqlSession.getMapper(AccountDAO.class);

		accountDAO.registerSignonByAccount(registerAccount);
		accountDAO.registerProfileByAccount(registerAccount);
		accountDAO.registerAccountByAccount(registerAccount);
		sqlSession.commit();
		sqlSession.close();
		return registerAccount;
	}

	public boolean update(Account updateAccount){
		Account result = null;
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		accountDAO = sqlSession.getMapper(AccountDAO.class);

		accountDAO.updateAccountByAccount(updateAccount);
		accountDAO.updateSignonByAccount(updateAccount);
		accountDAO.updateProfileByAccount(updateAccount);
		sqlSession.commit();
		sqlSession.close();
		return true;
	}

	public Account load(Account account){
		Account result = null;
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		accountDAO = sqlSession.getMapper(AccountDAO.class);

		result = accountDAO.findEditAccount(account);
		sqlSession.close();
		return result;
	}
}
