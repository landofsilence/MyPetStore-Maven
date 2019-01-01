package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Account;
import per.jxnflzc.persistence.AccountDAO;
import per.jxnflzc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 河木
 * @version v1.0.0
 */
public class AccountDAOImpl implements AccountDAO {
	private static String findByUserNameAndPasswordSQL = "SELECT * FROM signon WHERE username = ? AND password = ?";
	private static String findByUserNameSQL = "SELECT * FROM signon WHERE username = ?";
	private static String findEditAccountSQL = "SELECT * FROM `profile`, account, signon WHERE `profile`.userid = ? AND" +
			" account.userid = ? AND signon.username = ?";
	private static String registerSignonByUserNameAndPasswordSQL = "INSERT INTO signon (username, password) VALUES (?, ?)";
	private static String registerAccountByUserNameAndPasswordSQL = "INSERT INTO account VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String registerProfileByAccount = "INSERT INTO profile VALUES (?, ?, ?, ?, ?)";
	private static String updateSignonByUserNameAndPasswordSQL = "UPDATE signon SET password = ? WHERE username = ?";
	private static String updateAccountByUserNameAndPasswordSQL = "UPDATE account SET email = ?, firstname = ?, lastname = ?," +
			"addr1 = ?, addr2 = ?, city = ?, state = ?, zip = ?, country = ?, phone = ? WHERE userid = ?";
	private static String updateProfileByAccount = "UPDATE profile SET langpref = ?, favcategory = ?, mylistopt = ?," +
			"banneropt = ? WHERE userid = ?";

	public Account findEditAccount(Account editAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(findEditAccountSQL);
			preparedStatement.setString(1, editAccount.getUsername());
			preparedStatement.setString(2, editAccount.getUsername());
			preparedStatement.setString(3, editAccount.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				account = new Account();
				account.setUsername(resultSet.getString(1));
				account.setLanguagePreference(resultSet.getString(2));
				account.setFavouriteCategoryId(resultSet.getString(3));
				account.setListOption(resultSet.getBoolean(4));
				account.setBannerOption(resultSet.getBoolean(5));
				account.setEmail(resultSet.getString(7));
				account.setFirstName(resultSet.getString(8));
				account.setLastName(resultSet.getString(9));
				account.setAddress1(resultSet.getString(11));
				account.setAddress2(resultSet.getString(12));
				account.setCity(resultSet.getString(13));
				account.setState(resultSet.getString(14));
				account.setZip(resultSet.getString(15));
				account.setCountry(resultSet.getString(16));
				account.setPhone(resultSet.getString(17));
				account.setPassword(resultSet.getString(19));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account findByUserNameAndPassword(Account signonAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(findByUserNameAndPasswordSQL);
			preparedStatement.setString(1, signonAccount.getUsername());
			preparedStatement.setString(2, signonAccount.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				account = new Account();
				account.setUsername(resultSet.getString(1));
				account.setPassword(resultSet.getString(2));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account findByUserName(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(findByUserNameSQL);
			preparedStatement.setString( 1, registerAccount.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				account = new Account();
				account.setUsername(resultSet.getString("username"));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account registerSignonByAccount(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(registerSignonByUserNameAndPasswordSQL);
			preparedStatement.setString(1, registerAccount.getUsername());
			preparedStatement.setString(2, registerAccount.getPassword());

			if(preparedStatement.executeUpdate() > 0){
				account = new Account();
				account.setUsername(registerAccount.getUsername());
				account.setPassword(registerAccount.getPassword());
			}
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account registerAccountByAccount(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(registerAccountByUserNameAndPasswordSQL);
			preparedStatement.setString(1, registerAccount.getUsername());
			preparedStatement.setString(2, registerAccount.getEmail());
			preparedStatement.setString(3, registerAccount.getFirstName());
			preparedStatement.setString(4, registerAccount.getLastName());
			preparedStatement.setString(5, "OK");
			preparedStatement.setString(6, registerAccount.getAddress1());
			preparedStatement.setString(7, registerAccount.getAddress2());
			preparedStatement.setString(8, registerAccount.getCity());
			preparedStatement.setString(9, registerAccount.getState());
			preparedStatement.setString(10, registerAccount.getZip());
			preparedStatement.setString(11, registerAccount.getCountry());
			preparedStatement.setString(12, registerAccount.getPhone());
			boolean successInsert = preparedStatement.execute();

			if(successInsert){
				account = new Account();
				account.setUsername(registerAccount.getUsername());
				account.setPassword(registerAccount.getPassword());
			}
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account registerProfileByAccount(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(registerProfileByAccount);
			preparedStatement.setString(1, registerAccount.getUsername());
			preparedStatement.setString(2, registerAccount.getLanguagePreference());
			preparedStatement.setString(3, registerAccount.getFavouriteCategoryId());
			preparedStatement.setBoolean(4, registerAccount.isListOption());
			preparedStatement.setBoolean(5, registerAccount.isBannerOption());
			boolean successInsert = preparedStatement.execute();

			if(successInsert){
				account = new Account();
				account.setUsername(registerAccount.getUsername());
				account.setPassword(registerAccount.getPassword());
			}
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public Account updateSignonByAccount(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateSignonByUserNameAndPasswordSQL);
			preparedStatement.setString(1, registerAccount.getPassword());
			preparedStatement.setString(2, registerAccount.getUsername());
			boolean successUpdate = preparedStatement.execute();

			if(successUpdate){
				account = new Account();
				account.setUsername(registerAccount.getUsername());
				account.setPassword(registerAccount.getPassword());
			}
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}

	public boolean updateAccountByAccount(Account registerAccount){
		Account account = null;
		boolean successUpdate = false;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateAccountByUserNameAndPasswordSQL);
			preparedStatement.setString(1, registerAccount.getEmail());
			preparedStatement.setString(2, registerAccount.getFirstName());
			preparedStatement.setString(3, registerAccount.getLastName());
			preparedStatement.setString(4, registerAccount.getAddress1());
			preparedStatement.setString(5, registerAccount.getAddress2());
			preparedStatement.setString(6, registerAccount.getCity());
			preparedStatement.setString(7, registerAccount.getState());
			preparedStatement.setString(8, registerAccount.getZip());
			preparedStatement.setString(9, registerAccount.getCountry());
			preparedStatement.setString(10, registerAccount.getPhone());
			preparedStatement.setString(11, registerAccount.getUsername());
			successUpdate = preparedStatement.executeUpdate() > 0;
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return successUpdate;
	}

	public Account updateProfileByAccount(Account registerAccount){
		Account account = null;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateProfileByAccount);
			preparedStatement.setString(1, registerAccount.getLanguagePreference());
			preparedStatement.setString(2, registerAccount.getFavouriteCategoryId());
			preparedStatement.setBoolean(3, registerAccount.isListOption());
			preparedStatement.setBoolean(4, registerAccount.isBannerOption());
			preparedStatement.setString(5, registerAccount.getUsername());
			boolean successUpdate = preparedStatement.execute();

			if(successUpdate){
				account = new Account();
				account.setUsername(registerAccount.getUsername());
				account.setPassword(registerAccount.getPassword());
			}
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return account;
	}
}
