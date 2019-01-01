package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Cart;
import per.jxnflzc.domain.CartItem;
import per.jxnflzc.domain.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "UpdateCartServlet", urlPatterns = "/updateCart")
public class UpdateCartServlet extends HttpServlet {
	private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

	String itemId;
	Cart cart;
	int newItemQuantity;
	CartItem cartItem;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		cart = (Cart)session.getAttribute("cart");

		List<CartItem> cartItemList = cart.getCartItemList();

		for (int i = 0; i < cartItemList.size(); i++){
			cartItem = cartItemList.get(i);
			itemId = cartItem.getItem().getItemId();
			newItemQuantity = Integer.parseInt(request.getParameter(itemId));
			cart.setQuantityByItemId(itemId, newItemQuantity);
		}
		session.setAttribute("cart", cart);
		session.setAttribute("cartItemList", cartItemList);

		request.getRequestDispatcher(VIEW_CART).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
