package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.Product;
import per.jxnflzc.service.CategoryService;

import java.util.List;
import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class ProductAction implements Action, ModelDriven<Product> {
	private Product product = new Product();
	private CategoryService categoryService;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String viewProduct() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		categoryService = new CategoryService();

		product = categoryService.getProduct(product.getProductId());
		List<Item> itemList = categoryService.getItemListByProduct(product.getProductId());

		session.put("product", product);
		session.put("itemList", itemList);

		for (int i = 0; i < itemList.size(); i++){
			System.out.println(itemList.get(i).getItemId());
		}

		return "success";
	}


	@Override
	public Product getModel() {
		return product;
	}
}
