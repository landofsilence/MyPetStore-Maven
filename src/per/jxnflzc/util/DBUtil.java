package per.jxnflzc.util;

import java.sql.*;

/**
 * @author 河木
 * @version v1.0.0
 */
public class DBUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mypetstore?useSSL=false";//URL指向访问的数据库名，jsp_data
	private static String user = "root";//Mysql配置时的用户名
	private static String password = "990806";//密码

	public static Connection getConnection() throws Exception{
		Connection connection = null;

		Class.forName(driver);//加载驱动程序
		connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

	public static void closeConnection(Connection connection) throws Exception{
		if(connection != null){
			connection.close();
		}
	}

	public static void closeStatement(Statement statement) throws Exception{
		if(statement != null){
			statement.close();
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) throws Exception{
		if(preparedStatement != null){
			preparedStatement.close();
		}
	}

	public static void closeResultSet(ResultSet resultSet) throws Exception{
		if(resultSet != null){
			resultSet.close();
		}
	}
}
