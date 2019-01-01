package per.jxnflzc.persistence;

import per.jxnflzc.domain.Account;

/**
 * @author 河木
 * @version v1.0.0
 */
public interface AccountDAO {
	Account findByUserNameAndPassword(Account loginAccount);

	Account findByUserName(Account registerAccount);

	Account findEditAccount(Account editAccount);

	Account registerSignonByAccount(Account registerAccount);

	Account registerAccountByAccount(Account registerAccount);

	Account registerProfileByAccount(Account registerAccount);

	Account updateSignonByAccount(Account registerAccount);

	boolean updateAccountByAccount(Account registerAccount);

	Account updateProfileByAccount(Account registerAccount);
}
