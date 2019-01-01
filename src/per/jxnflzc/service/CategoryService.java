package per.jxnflzc.service;

import java.util.List;
import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.Product;
import per.jxnflzc.domain.Category;
import per.jxnflzc.persistence.ItemDAO;
import per.jxnflzc.persistence.ProductDAO;
import per.jxnflzc.persistence.CategoryDAO;
import per.jxnflzc.persistence.impl.CategoryDAOImpl;
import per.jxnflzc.persistence.impl.ItemDAOImpl;
import per.jxnflzc.persistence.impl.ProductDAOImpl;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CategoryService {
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	private ItemDAO itemDAO;

	public CategoryService(){
		categoryDAO = new CategoryDAOImpl();
		productDAO = new ProductDAOImpl();
		itemDAO = new ItemDAOImpl();
	}

	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryDAO.getCategory(categoryId);
	}

	public Product getProduct(String productId) {
		return productDAO.getProduct(productId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDAO.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keyword) {
		return productDAO.searchProductList(keyword.toLowerCase());
	}

	public List<Item> getItemListByProduct(String productId) {
		return itemDAO.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		return itemDAO.getItem(itemId);
	}

	public boolean isItemInStock(String itemId) {
		return itemDAO.getInventoryQuantity(itemId) > 0;
	}
}
