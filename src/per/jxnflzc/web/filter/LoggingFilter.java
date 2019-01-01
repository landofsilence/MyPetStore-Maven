package per.jxnflzc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebFilter(filterName = "LoggingFilter", urlPatterns = "/*",
			initParams = {
					@WebInitParam(name = "logFileName", value = "log.txt"),
					@WebInitParam(name = "prefix", value = "URL: "),
			})
public class LoggingFilter implements Filter {
	private PrintWriter logger;
	private String prefix;

	public void init(FilterConfig filterConfig) throws ServletException {
		prefix = filterConfig.getInitParameter("prefix");
		String logFileName = filterConfig.getInitParameter("logFileName");
		String appPath = filterConfig.getServletContext().getRealPath("/");

		System.out.println("logFileName: " + logFileName);
		try{
			logger = new PrintWriter(new File(appPath, logFileName));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain filterChain) throws ServletException, IOException {
		System.out.println("LoggingFilter.doFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		logger.println(new Date() + "\t" + prefix
						+ httpServletRequest.getRequestURI());
		logger.flush();
		filterChain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("Destroying filter");
		if(logger != null){
			logger.close();
		}
	}
}
