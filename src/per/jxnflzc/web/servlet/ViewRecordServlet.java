package per.jxnflzc.web.servlet;

import per.jxnflzc.domain.Account;
import per.jxnflzc.domain.Record;
import per.jxnflzc.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewRecordServlet",urlPatterns = "/viewRecord")

public class ViewRecordServlet extends HttpServlet {
    private static final String VIEW_RECORD = "WEB-INF/jsp/account/Record.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page;
        boolean isLast = false;
        String getPage = request.getParameter("page");
        if(getPage == null)
            page = 0;
        else
            page = Integer.parseInt(getPage);
        RecordService s = new RecordService();
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        List<Record>  recordList= s.getRecordList(account.getUsername());
        List<Record> appearList = new ArrayList<Record>();
        for(int i = recordList.size() - 10*page - 1;i>recordList.size() - 10*page - 11;i--){
            if(i<0){
                isLast = true;
                break;
            }
            recordList.get(i).generateDescription();
            appearList.add(recordList.get(i));

        }


        session.setAttribute("appearList",appearList);
        session.setAttribute("isLast",isLast);
        session.setAttribute("page",page);
        request.getRequestDispatcher(VIEW_RECORD).forward(request, response);
    }
}

