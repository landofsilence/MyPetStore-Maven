package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import per.jxnflzc.domain.Category;

import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CategoryAction implements Action {
	private Category category;
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

		System.out.println(categoryId);

		return null;
	}
}
