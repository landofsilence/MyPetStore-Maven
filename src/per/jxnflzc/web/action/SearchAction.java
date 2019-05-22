package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import per.jxnflzc.domain.Category;
import per.jxnflzc.domain.Product;
import per.jxnflzc.service.CategoryService;

import java.util.List;
import java.util.Map;

public class SearchAction implements Action {
    private String keyword;
    private Category category = new Category();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override

    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        CategoryService categoryService = new CategoryService();

        List<Product> productList = categoryService.searchProductList(getKeyword());
        session.put("productList", productList);

        return "success";
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
