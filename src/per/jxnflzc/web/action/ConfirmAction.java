package per.jxnflzc.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.*;
import per.jxnflzc.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfirmAction extends ActionSupport implements ModelDriven<Order> {
    private Order order = new Order();

    public Order getOrder() {
        return order;
    }

    @Override
    public Order getModel() {
        return order;
    }

    public String confirm(){
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Map request = (Map)context.get("request");
        Cart sessionCart = (Cart)session.get("cart");
		Account account = (Account)session.get("account");
		Cart cart = (Cart)session.get("cart");
        List<LineItem> lineItems = new ArrayList<>();
        for(int i = 0;i < sessionCart.getCartItemList().size();i++){
			LineItem lineItem = new LineItem(i, sessionCart.getCartItemList().get(i));
			lineItem.calculateTotal();
            lineItems.add(lineItem);

        }
        order.setUsername(account.getUsername());
        order.setLineItems(lineItems);
        order.initOrder(account, cart);
        session.put("order",order);
        return "checkout";



    }
}
