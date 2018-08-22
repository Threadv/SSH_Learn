package cn.llanc.demo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class Employee implements RequestAware{
	
	private String name;
	private String password;
	private String gender;
	private List<String> dept;
	private String role;
	private String desc;
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", gender=" + gender + ", dept=" + dept + ", role="
				+ role + ", desc=" + desc + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getDept() {
		return dept;
	}

	public void setDept(List<String> dept) {
		this.dept = dept;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	Map<String,Object> requestMap=null;
	Dao dao=new Dao();
	
	public String input() {
		requestMap.put("depts", dao.getDepartment());
		requestMap.put("roles", dao.getRole());
		return "input";
	}
	
	public String save() {
		
		System.out.println(this.toString());
		return "save";
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap=arg0;
	}
	
}
