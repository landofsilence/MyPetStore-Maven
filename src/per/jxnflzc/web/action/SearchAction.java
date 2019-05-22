package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import per.jxnflzc.domain.Product;
import per.jxnflzc.service.CategoryService;

import java.util.List;
import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class SearchAction implements Action {
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public void completion() throws Exception  {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Map request = (Map)context.get("request");

		CategoryService categoryService = new CategoryService();
		List<Product> productList = categoryService.searchProductList(getKeyword());

		String result = "{\"products\":[";
		for (int i = 0; i < productList.size(); i++) {
			if(i > 0){
				result += "," + productList.get(i).toString();
			}else{
				result += productList.get(i).toString();
			}
		}
		result += "]}";

		System.out.println(result);

		request.put("data", result);
	}
}
