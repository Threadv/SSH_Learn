package cn.llanc.demo;

import java.util.ArrayList;
import java.util.List;

public class Dao {
	public List<Department> getDepartment(){
		List<Department> departments=new ArrayList<>();
		departments.add(new Department(1001,"Department01"));
		departments.add(new Department(1002,"Department02"));
		departments.add(new Department(1003,"Department03"));
		departments.add(new Department(1004,"Department04"));
		return departments;
	}
	public List<Role> getRole(){
		List<Role> roles =new ArrayList<>();
		roles.add(new Role(201801,"Role01"));
		roles.add(new Role(201802,"Role02"));
		roles.add(new Role(201803,"Role03"));
		roles.add(new Role(201804,"Role04"));
		return roles;
	}
}
