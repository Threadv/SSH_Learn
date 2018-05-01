<%@page import="java.util.*"%>
<%@page import="cn.llanc.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form-Tags</title>
</head>
<body>

<%
	List<City> cities=new ArrayList<City>();
	cities.add(new City(1001,"City01"));
	cities.add(new City(1002,"City02"));
	cities.add(new City(1003,"City03"));
	cities.add(new City(1004,"City04"));
	request.setAttribute("Caties", cities);
%>

<!-- Struts2的form标签可以自动进行回显（栈顶对象的属性值，栈顶对象不存在时向下查找） -->

	<s:form action="save.action" method="post">
	
		<s:hidden name="userId"></s:hidden>
		
		<s:textfield name="userName" label="UserName:" />
		<s:password name="passWord" label="PassWord:" />
		<s:textarea name="desc" label="Desc:" />
		
		
		<s:checkbox name="agree" label="阅读并同意同意本协议"></s:checkbox>
		
		<s:radio name="sex" list="#{'1':'男','0':'女' }" label="Sex" ></s:radio>
		
		<!-- 服务端使用List保证回显 -->
		<s:checkboxlist name="city" list="#request.Caties" listKey="cityId" listValue="cityName" label="City"></s:checkboxlist>
		
		<s:select list="{1,2,3,4}" headerKey="" headValue="请选择" name="age" label="Age">
			<s:optgroup list="#{5:5,6:6,7:7 }" label="5岁到7岁"></s:optgroup>
			<s:optgroup list="#{8:8,9:9,10:10 }" label="8岁到10岁"></s:optgroup>
			
		</s:select>
		
		
		
		<s:submit />
		
	</s:form>
</body>
</html>