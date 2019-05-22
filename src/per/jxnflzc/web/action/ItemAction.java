package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Cart;
import per.jxnflzc.domain.Item;
import per.jxnflzc.service.CategoryService;

import javax.swing.*;
import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class ItemAction implements Action, ModelDriven<Item> {
	private Item item = new Item();

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String addItemToCart() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();

		Cart cart = (Cart)session.get("cart");
		if(cart == null){
			cart = new Cart();
		}

		String itemId = item.getItemId();

		if(cart.containsItemId(itemId)){
			cart.incrementQuantityByItemId(itemId);
		} else {
			CategoryService categoryService = new CategoryService();
			Item item = categoryService.getItem(itemId);
			item.setProduct(categoryService.getProduct(item.getProductId()));
			System.out.println("item.getAttribute1() = " + item.getAttribute1());
			boolean isInStock = categoryService.isItemInStock(itemId);
			cart.addItem(item, isInStock);
		}

		session.put("cart", cart);
		return "success";
	}

	public void changeCart() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();

		Cart cart = (Cart)session.get("cart");
		cart.setQuantityByItemId(item.getItemId(), item.getQuantity());

		session.put("cart", cart);
	}

	@Override
	public Item getModel() {
		return item;
	}
}
