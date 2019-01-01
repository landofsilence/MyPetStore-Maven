package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.*;
import per.jxnflzc.service.OrderService;
import sun.java2d.pipe.hw.AccelDeviceEventListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewOrderServlet" , urlPatterns = "/NewOrder")
public class NewOrderServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String SHIP = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String CONFIRM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SUCCESS = "/WEB-INF/jsp/order/OrderSuccess.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String skipType = request.getParameter("skipType");
        HttpSession session = request.getSession();
        Order order;
        if(skipType.equals("1"))
        {
            request.getRequestDispatcher(MAIN).forward(request, response);
        }
        if(skipType.equals("2"))
        {
            order = (Order)session.getAttribute("order");
			Account account = (Account)session.getAttribute("account") ;
			Cart cart = (Cart)session.getAttribute("cart") ;

            order.setCardType(request.getParameter("cardType"));
            order.setCreditCard(request.getParameter("creditCard"));
            order.setUsername(account.getUsername());
            order.setTotalPrice(cart.getSubTotal());
            order.setExpiryDate(request.getParameter("expiryDate"));
            order.setBillToFirstName(request.getParameter("billToFirstName"));
            order.setBillToLastName(request.getParameter("billToLastName"));
            order.setBillAddress1(request.getParameter("billAddress1"));
            order.setBillAddress2(request.getParameter("billAddress2"));
            order.setBillCity(request.getParameter("billCity"));
            order.setBillCountry(request.getParameter("billCountry"));
            order.setBillState(request.getParameter("billState"));
            order.setBillZip(request.getParameter("billZip"));


            String shipAdd = request.getParameter("shipAddress");

            if(shipAdd==null)
            {
                order.setShipToFirstName(request.getParameter("billToFirstName"));
                order.setShipToLastName(request.getParameter("billToLastName"));
                order.setShipAddress1(request.getParameter("billAddress1"));
                order.setShipAddress2(request.getParameter("billAddress2"));
                order.setShipCity(request.getParameter("billCity"));
                order.setShipCountry(request.getParameter("billCountry"));
                order.setShipState(request.getParameter("billState"));
                order.setShipZip(request.getParameter("billZip"));
                session.setAttribute("order",order);

                request.getRequestDispatcher(CONFIRM).forward(request, response);
            }
            else{
                session.setAttribute("order",order);
                request.getRequestDispatcher(SHIP).forward(request, response);
            }

        }
        if(skipType.equals("3")){

            order = (Order)session.getAttribute("order");

            order.setShipToFirstName(request.getParameter("shipToFirstName"));
            order.setShipToLastName(request.getParameter("shipToLastName"));
            order.setShipAddress1(request.getParameter("shipAddress1"));
            order.setShipAddress2(request.getParameter("shipAddress2"));
            order.setShipCity(request.getParameter("shipCity"));
            order.setShipCountry(request.getParameter("shipCountry"));
            order.setShipState(request.getParameter("shipState"));
            order.setShipZip(request.getParameter("shipZip"));

            session.setAttribute("order",order);
            request.getRequestDispatcher(CONFIRM).forward(request, response);

        }
        if(skipType.equals("4")){
        	Cart cart = (Cart)session.getAttribute("cart");
        	cart.clear();
			session.setAttribute("cart", cart);
            order = (Order)session.getAttribute("order");
            OrderService s = new OrderService();
            s.insertOrder(order);
            request.getRequestDispatcher(SUCCESS).forward(request, response);

        }
    }

    private List<LineItem> move(List<CartItem> cartItemList){
		List<LineItem> lineItemList = new ArrayList<LineItem>();

		for (int i = 0; i < cartItemList.size(); i++){
			LineItem lineItem = new LineItem();
			lineItem.setItem(cartItemList.get(i).getItem());
			lineItem.setItemId(cartItemList.get(i).getItem().getItemId());
			lineItem.setQuantity(cartItemList.get(i).getQuantity());
		}

		return lineItemList;
	}
}
