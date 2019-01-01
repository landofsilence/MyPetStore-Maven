package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.Product;
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
@WebServlet(name = "ViewItemServlet", urlPatterns = "/viewItem")
public class ViewItemServlet extends HttpServlet {
	private static final String VIEW_ITEM = "WEB-INF/jsp/catalog/Item.jsp";
	private String itemId;
	private String productId;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemId = request.getParameter("itemId");
		CategoryService categoryService = new CategoryService();
		Item item = categoryService.getItem(itemId);
		Product product = item.getProduct();

		HttpSession session = request.getSession();
		session.setAttribute("item", item);
		session.setAttribute("product", product);

		request.getRequestDispatcher(VIEW_ITEM).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
