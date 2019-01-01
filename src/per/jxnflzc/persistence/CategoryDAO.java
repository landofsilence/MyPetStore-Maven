package per.jxnflzc.persistence;

import per.jxnflzc.domain.Category;

import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
public interface CategoryDAO {

	List<Category> getCategoryList();

	Category getCategory(String categoryId);
}
