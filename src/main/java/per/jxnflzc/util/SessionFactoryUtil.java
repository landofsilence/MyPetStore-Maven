package per.jxnflzc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.Reader;

/**
 * @author 河木
 * @version v1.0.0
 */
public class SessionFactoryUtil {
	private static String source = "mybatis-config.xml";

	public static SqlSessionFactory getSqlSessionFactory(){
		SqlSessionFactory sqlSessionFactory = null;
		try {
			Reader reader = Resources.getResourceAsReader(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e){
			System.out.println("文件读取错误");
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
