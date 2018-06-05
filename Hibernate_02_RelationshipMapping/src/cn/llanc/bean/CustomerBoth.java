package cn.llanc.bean;

import java.util.HashSet;
import java.util.Set;

public class CustomerBoth {
	private Integer customerId;
	private String customerName;
	
	private Set<OrderBoth> orders=new HashSet<>();
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Set<OrderBoth> getOrders() {
		return orders;
	}
	public void setOrders(Set<OrderBoth> orders) {
		this.orders = orders;
	}

	
	
}
