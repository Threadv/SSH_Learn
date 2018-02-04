package cn.llanc.GetWebResources;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction implements ServletRequestAware,ServletContextAware
{

	private HttpServletRequest request;
	
	private ServletContext servletContext;
	
	//private HttpSession session=request.getSession();
	
	public String execute()
	{
		request.getSession().setAttribute("sessionKey", "sessionValue");
	
		return "success";
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
		this.request=arg0;
		
	}

	@Override
	public void setServletContext(ServletContext arg0)
	{
		this.servletContext=arg0;
		
	}

	
}