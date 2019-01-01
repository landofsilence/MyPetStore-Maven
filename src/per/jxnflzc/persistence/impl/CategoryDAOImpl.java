package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Category;
import per.jxnflzc.persistence.CategoryDAO;
import per.jxnflzc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CategoryDAOImpl implements CategoryDAO {
	private static String GET_CATEGORY_LIST = "SELECT catid AS categoryId, name, descn AS description FROM category";
	private static String GET_CATEGORY = "SELECT catid AS categoryId, name, descn AS description FROM category WHERE catid = ?";

	@Override
	public List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_LIST);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				Category category = new Category();
				category.setCategoryId(resultSet.getString(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));
				categoryList.add(category);
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return categoryList;
	}

	@Override
	public Category getCategory(String categoryId) {
		Category category = new Category();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY);
			preparedStatement.setString(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				category.setCategoryId(resultSet.getString(1));
				category.setName(resultSet.getString(2));
				category.setDescription(resultSet.getString(3));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return category;
	}
}
