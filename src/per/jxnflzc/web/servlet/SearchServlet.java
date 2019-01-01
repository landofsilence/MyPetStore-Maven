package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Category;
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
@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
	private static final String VIEW_CATEGORY = "WEB-INF/jsp/catalog/SearchProducts.jsp";
	private String keyword;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		keyword = request.getParameter("keyword");
		CategoryService categoryService = new CategoryService();
		List<Product> productList = categoryService.searchProductList(keyword);

		HttpSession session = request.getSession();
		session.setAttribute("productList", productList);

		request.getRequestDispatcher(VIEW_CATEGORY).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
