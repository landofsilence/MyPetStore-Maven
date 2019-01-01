package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Account;
import per.jxnflzc.domain.Order;
import per.jxnflzc.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewOrderServlet",urlPatterns = "/viewOrder")
public class ViewOrderServlet extends HttpServlet {
    private static final String ORDER_LIST = "WEB-INF/jsp/order/ListOrders.jsp";
    private static final String ORDER_VIEW = "WEB-INF/jsp/order/ViewOrder.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderService s = new OrderService();
        Account account = (Account)session.getAttribute("account");

        String orderId = request.getParameter("orderId");
        if(orderId == null){
        List<Order> orderList= s.getOrdersByUsername(account.getUsername());
        session.setAttribute("orderList",orderList);
        request.getRequestDispatcher(ORDER_LIST).forward(request, response);}
        else{
            List<Order> orderList = (List) session.getAttribute("orderList");
            Order findOrder = s.getOrder(Integer.parseInt(orderId));

            session.setAttribute("order",findOrder);
            request.getRequestDispatcher(ORDER_VIEW).forward(request, response);}
        }
    }

