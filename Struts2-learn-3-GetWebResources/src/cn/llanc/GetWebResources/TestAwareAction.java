package cn.llanc.GetWebResources;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware,SessionAware,RequestAware,ParameterAware
{
	private Map<String,Object> application;
	private Map<String,Object> session;
	private Map<String,String[]> parameters;
	private Map<String,Object> request;
	//Struts2通过Aware接口已经把Map传递进来（依赖注入），在此只需要接收。
	public String  execute()
	{
		//获取application中的属性date向application中添加属性 date
		Object date=application.get("date");
		application.put("dateNew", date);

		//读写session对象的属性
		session.put("sessionKey", "sessionValue");
		System.out.println(session.getClass());
		if(session instanceof SessionMap) {
			SessionMap sm=(SessionMap)session; //强制转换成SessionMap
			sm.invalidate();
			System.out.println("Session被销毁！");
		}
		
		//读写request对象的属性
		request.put("requestKey", "requestValue");
		
		//读写parameters对象的属性
		System.out.println(parameters.get("name")[0]);
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> arg0)
	{
		//绑定对象
		this.application=arg0;
		
	}

	@Override
	public void setParameters(Map<String, String[]> arg0)
	{
		this.parameters=arg0;
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0)
	{
		this.request=arg0;
		
	}

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session=arg0;
		
	}
}
