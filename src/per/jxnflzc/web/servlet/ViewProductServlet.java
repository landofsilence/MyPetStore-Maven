package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Category;
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
@WebServlet(name = "ViewProductServlet", urlPatterns = "/viewProduct")
public class ViewProductServlet extends HttpServlet {
	private static final String VIEW_PRODUCT = "WEB-INF/jsp/catalog/Product.jsp";
	private String productId;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productId = request.getParameter("productId");
		CategoryService categoryService = new CategoryService();
		List<Item> itemList = categoryService.getItemListByProduct(productId);
		Product product = categoryService.getProduct(productId);

		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		session.setAttribute("itemList", itemList);

		request.getRequestDispatcher(VIEW_PRODUCT).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
