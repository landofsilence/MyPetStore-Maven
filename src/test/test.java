package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.util.SessionFactoryUtil;

/**
 * @author 河木
 * @version v1.0.0
 */
public class test {
	public static void main(String [] args){
		Account a = new Account();
		a.setUsername("3901170623");
		a.setPassword("500");
		Account account = getPassword(a);
		System.out.println(account.getUsername());
		System.out.println(account.getPassword());
		System.out.println(account.getPhone());
		System.out.println(account.getCountry());
		System.out.println(account.getZip());
		System.out.println(account.getState());
	}

	public static Account getPassword(Account account){
		Account result = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);
			result = accountDAO.findAccountExistByUserNameAndPassword(account);//sqlSession.selectOne("per.jxnflzc.domain.AccountMapper.accountExist",account);
			if (result != null){
				result = accountDAO.findByUserNameAndPassword(result);
			} else {
				System.out.println("账号不存在");
			}
		}catch (Exception e){
			//e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
}
