package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Cart;
import per.jxnflzc.domain.CartItem;
import per.jxnflzc.domain.Item;
import per.jxnflzc.service.CategoryService;

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
@WebServlet(name = "RemoveItemFromCartServlet", urlPatterns = "/removeItemFromCartServlet")
public class RemoveItemFromCartServlet extends HttpServlet {
	private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
	private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

	String itemId;
	Cart cart;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		cart = (Cart)session.getAttribute("cart");
		itemId = request.getParameter("itemId");
		Item item =cart.removeItemById(itemId);

		if(item == null){
			request.setAttribute("msg", "This Item DO NOT EXIST!!!");
			request.getRequestDispatcher(ERROR).forward(request, response);
		} else {
			List<CartItem> cartItemList = cart.getCartItemList();
			session.setAttribute("cart", cart);
			session.setAttribute("cartItemList", cartItemList);
			request.getRequestDispatcher(VIEW_CART).forward(request, response);
		}



	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
