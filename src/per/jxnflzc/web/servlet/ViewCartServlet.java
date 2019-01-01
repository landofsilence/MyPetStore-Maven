package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "ViewCartServlet", urlPatterns = "/viewCart")
public class ViewCartServlet extends HttpServlet {
	private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
		}
		session.setAttribute("cart", cart);
		request.getRequestDispatcher(CART).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
