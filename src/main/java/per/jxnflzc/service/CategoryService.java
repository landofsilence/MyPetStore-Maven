package per.jxnflzc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.Product;
import per.jxnflzc.domain.Category;
import per.jxnflzc.persistence.ItemDAO;
import per.jxnflzc.persistence.ProductDAO;
import per.jxnflzc.persistence.CategoryDAO;
import per.jxnflzc.util.SessionFactoryUtil;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CategoryService {
	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSession sqlSession = null;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	private ItemDAO itemDAO;

	public CategoryService(){

	}

	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		categoryDAO = sqlSession.getMapper(CategoryDAO.class);

		Category retCategory = categoryDAO.getCategory(categoryId);
		sqlSession.close();
		return retCategory;
	}

	public Product getProduct(String productId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		productDAO = sqlSession.getMapper(ProductDAO.class);

		return productDAO.getProduct(productId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		productDAO = sqlSession.getMapper(ProductDAO.class);

		return productDAO.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keyword) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		productDAO = sqlSession.getMapper(ProductDAO.class);

		return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
	}

	public List<Item> getItemListByProduct(String productId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		itemDAO = sqlSession.getMapper(ItemDAO.class);

		return itemDAO.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		itemDAO = sqlSession.getMapper(ItemDAO.class);
		productDAO = sqlSession.getMapper(ProductDAO.class);
		Item item = itemDAO.getItem(itemId);
		item.setProduct(productDAO.getProduct(item.getProductId()));

		return item;
	}

	public boolean isItemInStock(String itemId) {
		sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		itemDAO = sqlSession.getMapper(ItemDAO.class);

		return itemDAO.getInventoryQuantity(itemId) > 0;
	}
}
