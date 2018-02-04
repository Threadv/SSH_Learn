package cn.llanc.GetWebResources;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction
{
	public String execute() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("requestKey", "requestValue");
		
		HttpSession session =request.getSession();//ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionKey", "sessionValue");
		
		ServletContext servletContext=ServletActionContext.getServletContext();
		servletContext.setAttribute("servletContextKey", "servletContextValue");
		
		
		return  "success";
	}
}
