package cn.llanc.bean;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class ConversionAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer age;
	private Date brith;

	public Date getBrith() {
		return brith;
	}

	public void setBrith(Date brith) {
		this.brith = brith;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String execute() {
		return "success";
	}

}
