package cn.llanc.bean;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String execute() {
		Product product1=new Product("property",1001);
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.push(product1);
		return "success";
	}

}
