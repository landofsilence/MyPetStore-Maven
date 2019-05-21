package per.jxnflzc.persistence;

import org.apache.ibatis.annotations.Param;
import per.jxnflzc.domain.Item;

import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
public interface ItemDAO {

	//void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(@Param("itemId") String itemId);

	List<Item> getItemListByProduct(@Param("productId") String productId);

	Item getItem(String itemId);
}
