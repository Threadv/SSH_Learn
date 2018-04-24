package cn.llanc.bean;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.regexp.internal.recompile;

public class Product implements RequestAware,SessionAware{
	private String name;
	private String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	public String execute() {
		System.out.println(this.toString());
		return "success";
	}
	
	public String save() {
		//获取值栈
		ValueStack valueStack =ActionContext.getContext().getValueStack();
		Product product=new Product();
		product.setName("Cpu");
		product.setPrice("1200");
		//压入栈
		valueStack.push(product);
		
		
		sessionMap.put("APUproduct", this);
		requestMap.put("CPUproduct", product);
		
		return "success";
		
	}
	
	private Map<String,Object> requestMap;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap=arg0;
		
		
	}
	private Map<String ,Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
		
	}
	
}
