package cn.llanc.bean;

public class OrderBoth {
	private Integer orderId;
	private String orderName;
	
	private CustomerBoth customer;
 	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public CustomerBoth getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBoth customer) {
		this.customer = customer;
	}
	
}
