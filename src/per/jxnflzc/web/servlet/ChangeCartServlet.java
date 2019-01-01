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
@WebServlet(name = "ChangeCartServlet", urlPatterns = "/changeCart")
public class ChangeCartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId = request.getParameter("itemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		cart.setQuantityByItemId(itemId, quantity);

		session.setAttribute("cart", cart);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
