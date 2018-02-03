package cn.llanc.GetWebResources;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TextActionContextAction
{
	
	public String execute() {
		
		//1、获取ActionContext对象
		ActionContext actionContext=ActionContext.getContext();
		
		//2、获取application对应的Map 并添加一个属性
			//通过调用ActionContext的getApplication()方法获取Map
		Map<String,Object> applicationMap=actionContext.getApplication();
		//取值,设值
		Object date= applicationMap.get("date");
		applicationMap.put("date", date);
		
		
		//3、获取session对应的Map
		Map<String,Object> sessionMap=actionContext.getSession();
		sessionMap.put("sessionMapKey", "sessionMapValue");
		
		//4、获取request对应的Map
		//ActionContext并没有提供getrequest方法开获取request对象
		//只能调用get方法传入（键）参数request获取
		Map<String,Object> requestMap=(Map<String, Object>) actionContext.get("request");
		requestMap.put("requestMapKey", "requestMapValue");
		
		//5、获取请求参数对应的Map 并获取指定参数
		//请求参数对应的Map的key是参数名，value是参数值数组(复选框等情况)。
		//getParameters与上面的几个相同为Map<String,Object>并不是Map<String,String[]>.此处感觉直接返回Map<String,String[]>更好，省的下面再强转。
		//求参数对应的Map只能get不能put，put了也不起作用。
		Map<String,Object> parametersMap=actionContext.getParameters();
		System.out.println(((String[])parametersMap.get("name"))[0]);
				
		return "success";
	}
	
}
