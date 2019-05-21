package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Category;
import per.jxnflzc.service.AccountService;
import per.jxnflzc.service.CategoryService;

import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CategoryAction implements Action, ModelDriven<Category> {
	private Category category = new Category();
	private CategoryService categoryService;
	private String categoryId;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");
		categoryService = new CategoryService();

		Category myCategory =categoryService.getCategory(category.getCategoryId());

		System.out.println(myCategory.getName());

		return null;
	}

	@Override
	public Category getModel() {
		return category;
	}
}
