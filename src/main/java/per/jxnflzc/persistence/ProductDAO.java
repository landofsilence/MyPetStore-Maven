package per.jxnflzc.persistence;

import per.jxnflzc.domain.Product;
import java.util.List;
/**
 * @author 河木
 * @version v1.0.0
 */
public interface ProductDAO {
	List<Product> getProductListByCategory(String categoryId);

	Product getProduct(String productId);

	List<Product> searchProductList(String keywords);
}
