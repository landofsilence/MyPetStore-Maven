package per.jxnflzc.web.action;

import com.opensymphony.xwork2.ModelDriven;
import per.jxnflzc.domain.Cart;
import com.opensymphony.xwork2.Action;


public class CheckoutAction implements Action {


    @Override
    public String execute() throws Exception {
        return "checkout";
    }

    public String checkout() throws Exception{
        return "checkout";
    }

}