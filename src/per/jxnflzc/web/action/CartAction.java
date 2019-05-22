package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Cart;

import java.util.Map;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CartAction implements Action, ModelDriven<Cart> {
	private Cart cart = new Cart();

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();

		Cart sessionCart = (Cart)session.get("cart");
		if (sessionCart == null){
			sessionCart = new Cart();
		}
		session.put("cart", sessionCart);

		return "success";
	}

	@Override
	public Cart getModel() {
		return null;
	}
}
