package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Item;

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



		return "success";
	}

	@Override
	public Item getModel() {
		return null;
	}
}
