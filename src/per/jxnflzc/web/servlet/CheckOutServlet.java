package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.*;
import per.jxnflzc.service.OrderService;

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

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = "/checkout")
public class CheckOutServlet extends HttpServlet {
	private static final String CHECK_OUT = "/WEB-INF/jsp/cart/Checkout.jsp";
	private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Account account = (Account)session.getAttribute("account");
		if(account != null){
			order.setTotalPrice(cart.getSubTotal());
			order.setUsername(account.getUsername());
			order.setOrderDate(new Date());
			OrderService s = new OrderService();
			int newId = s.getNewId();
			order.setOrderId(newId);
			List <CartItem> cartItems = cart.getCartItemList();
			List <LineItem> lineItems = new ArrayList<LineItem>();

			for(int i = 0;i < cartItems.size();i++){
				LineItem item = new LineItem();
				CartItem section = cartItems.get(i);
				item.setOrderId(newId);
				item.setItemId(section.getItem().getItemId());
				item.setItem(section.getItem());
				item.setLineNumber(i);
				item.setQuantity(section.getQuantity());
				item.setUnitPrice(section.getItem().getListPrice());

				lineItems.add(item);
			}
			order.setLineItems(lineItems);
			session.setAttribute("order",order);
			request.getRequestDispatcher(CHECK_OUT).forward(request, response);
		} else {
			request.getRequestDispatcher(SIGNON).forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}
}
