package cn.llanc.bean;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class Login implements SessionAware,ApplicationAware
{
	private String name;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	public String execute() {
		
		session.put("userName", name);
		
		Integer count=(Integer) application.get("count");
		if (count==null)
		{
			count=0;
		}
		count++;
		application.put("count", count);
		return "success";
		
	}
	public String logOut() {
		Integer count=(Integer) application.get("count");
		if (count==0)
		{
			return "login";
		}else {
			count--;
		}
		application.put("count", count);
		return "login";
		
	}

	Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0)
	{
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	Map<String ,Object> application;
	@Override
	public void setApplication(Map<String, Object> arg0)
	{
		// TODO Auto-generated method stub
		this.application=arg0;
	}
}
