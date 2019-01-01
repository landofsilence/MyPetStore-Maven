package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Cart;
import per.jxnflzc.domain.CartItem;
import per.jxnflzc.domain.Category;
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
@WebServlet(name = "AddItemToCartServlet", urlPatterns = "/addItemToCart")
public class AddToCartServlet extends HttpServlet {
	private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
		}

		String itemId = request.getParameter("itemId");
		if(cart.containsItemId(itemId)){
			cart.incrementQuantityByItemId(itemId);
		} else {
			CategoryService categoryService = new CategoryService();
			Item item = categoryService.getItem(itemId);
			boolean isInStock = categoryService.isItemInStock(itemId);
			cart.addItem(item, isInStock);
		}
		//cart.addItem(item, true);
		List<CartItem> cartItemList = cart.getCartItemList();


		session.setAttribute("cart", cart);
		session.setAttribute("cartItemList", cartItemList);

		request.getRequestDispatcher(CART).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
