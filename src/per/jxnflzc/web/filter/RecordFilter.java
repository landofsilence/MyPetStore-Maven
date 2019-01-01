package per.jxnflzc.web.filter;

import per.jxnflzc.domain.Account;
import per.jxnflzc.domain.Order;
import per.jxnflzc.domain.Record;
import per.jxnflzc.service.RecordService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "RecordFilter",urlPatterns = "/*")
public class RecordFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        String uri=request.getRequestURI();
        Record record = new Record();
        record.setActionType(0);
        HttpSession session = request.getSession();
        System.out.println(uri);
        switch(uri){
            //type1=viewCategory,2=viewProduct,3=viewItem,4=addTocart,5=generateOrder
            case "/viewCategory":record.setActionType(1);record.setId(request.getParameter("categoryId"));break;
            case "/viewProduct":record.setActionType(2);record.setId(request.getParameter("productId"));break;
            case"/viewItem":record.setActionType(3);record.setId(request.getParameter("itemId"));break;
            case"/addItemToCart":record.setActionType(4);record.setId(request.getParameter("itemId"));break;
            case"/NewOrder":
                String skipType = request.getParameter("skipType");
                if(skipType == "4") {
                    record.setActionType(5);
                    Order order = (Order) session.getAttribute("order");
                    record.setId(String.valueOf(order.getOrderId()));
                }
                break;
        }
        Account account = (Account)session.getAttribute("account");
        if(record.getActionType() == 0 || account == null){
        chain.doFilter(req, resp);return;}
        record.setUserId(account.getUsername());
        record.setDate(new Date());
        RecordService s = new RecordService();
        s.InsertRecord(record);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
