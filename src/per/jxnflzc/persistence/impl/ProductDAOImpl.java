package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Category;
import per.jxnflzc.domain.Product;
import per.jxnflzc.persistence.ProductDAO;
import per.jxnflzc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
public class ProductDAOImpl implements ProductDAO {
	private static String GET_PRODUCT_LIST = "SELECT productid, category, name, descn AS description FROM product WHERE category = ?";
	private static String GET_PRODUCT = "SELECT productid, category, name, descn AS description FROM product WHERE productid = ?";
	private static String SEARCH_PRODUCT = "SELECT productid, category, name, descn AS description FROM product WHERE name LIKE ?";

	@Override
	public List<Product> getProductListByCategory(String categoryId) {
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST);
			preparedStatement.setString(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				Product product = new Product();
				product.setProductId(resultSet.getString(1));
				product.setCategoryId(resultSet.getString(2));
				product.setName(resultSet.getString(3));
				product.setDescription(resultSet.getString(4));
				productList.add(product);
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return productList;
	}

	@Override
	public Product getProduct(String productId) {
		Product product = new Product();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
			preparedStatement.setString(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				product.setProductId(resultSet.getString(1));
				product.setCategoryId(resultSet.getString(2));
				product.setName(resultSet.getString(3));
				product.setDescription(resultSet.getString(4));
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return product;
	}

	@Override
	public List<Product> searchProductList(String keywords) {
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
			preparedStatement.setString(1, "%" + keywords + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				Product product = new Product();
				product.setProductId(resultSet.getString(1));
				product.setCategoryId(resultSet.getString(2));
				product.setName(resultSet.getString(3));
				product.setDescription(resultSet.getString(4));
				productList.add(product);
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return productList;
	}

}
