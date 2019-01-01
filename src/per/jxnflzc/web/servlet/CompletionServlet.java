package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Product;
import per.jxnflzc.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "CompletionServlet", urlPatterns = "/completion")
public class CompletionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取搜索框输入的内容
		String name = request.getParameter("name");
		//向server层调用相应的业务
		CategoryService categoryService = new CategoryService();
		List<Product> productList = categoryService.searchProductList(name);

		String result = "{\"products\":[";
		for (int i = 0; i < productList.size(); i++) {
			if(i > 0){
				result += "," + productList.get(i).toString();
			}else{
				result += productList.get(i).toString();
			}
		}
		result += "]}";
		response.getWriter().write(result);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
