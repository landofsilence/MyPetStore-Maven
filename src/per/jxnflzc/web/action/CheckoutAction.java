package per.jxnflzc.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Account;
import per.jxnflzc.domain.Cart;
import com.opensymphony.xwork2.Action;
import per.jxnflzc.domain.Order;
import per.jxnflzc.service.OrderService;

import java.util.Map;


public class CheckoutAction implements Action {


    @Override
    public String execute() throws Exception {
        return "checkout";
    }

    public String checkout() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Account account = (Account)session.get("account");
        if(account == null)
            return "notSuccess";
        else
        return "checkout";
    }

    public String checkout2() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Order order = (Order)session.get("order");
        OrderService orderService = new OrderService();
        orderService.insertOrder(order);
        return  "checkout";
    }
}