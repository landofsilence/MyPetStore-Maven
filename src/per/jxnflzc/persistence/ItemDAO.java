package per.jxnflzc.persistence;

import per.jxnflzc.domain.Item;

import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
public interface ItemDAO {

	//void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(String itemId);

	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);
}
