package cn.llanc.HolleWord;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDispathcher
 */
@WebFilter("*.action")
public class FilterDispathcher implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest req=(HttpServletRequest)request;
		response.setContentType("text/html;charset=utf-8");
		String servletPath=req.getServletPath();
		String path=null;//要转发的地址
		
		if("/product-input.action".equals(servletPath)) {
			path="/WEB-INF/pages/input.jsp";
		}else if ("/product-save.action".equals(servletPath))
		{
			String fname= request.getParameter("fname");
			String fage= request.getParameter("fage");
			String fsex= request.getParameter("fsex");
			Product product=new Product(fname, fage, fsex);
			request.setAttribute("Product", product);
			path="/WEB-INF/pages/detais.jsp";
		}
		System.out.println(path);
		if(path!=null){
			request.getRequestDispatcher(path).forward(request, response);//请求转发
			return;
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
