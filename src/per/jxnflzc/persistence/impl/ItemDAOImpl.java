package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.Product;
import per.jxnflzc.persistence.ItemDAO;
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
public class ItemDAOImpl implements ItemDAO {
	private static String GET_ITEM_QUANTITY = "SELECT qty FROM inventory WHERE itemid = ?";
	private static String GET_ITEM_LIST = "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS \"product.productId\",NAME AS \"product.name\",DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\",STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2, ATTR3 AS attribute3,ATTR4 AS attribute4, ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
	private static String GET_ITEM = "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\",DESCN AS \"product.description\",CATEGORY AS \"product.categoryId\",STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5,QTY AS quantity from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.ITEMID = V.ITEMID and I.ITEMID = ?";

	@Override
	public int getInventoryQuantity(String itemId) {
		int inventoryQuantity = 0;
		try {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM_QUANTITY);
		preparedStatement.setString(1, itemId);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()){
			inventoryQuantity = resultSet.getInt(1);
		}
		DBUtil.closeResultSet(resultSet);
		DBUtil.closePreparedStatement(preparedStatement);
		DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return inventoryQuantity;
	}

	@Override
	public List<Item> getItemListByProduct(String productId) {
		List<Item> itemList = new ArrayList<Item>();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM_LIST);
			preparedStatement.setString(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
                Item item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                item.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                itemList.add(item);
			}
			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return itemList;
	}

	@Override
	public Item getItem(String itemId) {
		Item item = new Item();
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
			preparedStatement.setString(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
                item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
				item.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
			}

			DBUtil.closeResultSet(resultSet);
			DBUtil.closePreparedStatement(preparedStatement);
			DBUtil.closeConnection(connection);
		} catch (Exception e){

		}
		return item;
	}
}
