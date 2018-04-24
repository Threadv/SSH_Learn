<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	ProductName:[0]：<s:property value="[0].name"/>    [1]: <s:property value="[1].name"/>
	<br>
	ProductPrice:[0]: <s:property value="[0].price"/>    [1]: <s:property value="[1].price"/>
	<br>
	ProductName:apu：${sessionScope.APUproduct.name}  ---  apu: <s:property value="#session.APUproduct.price"/>
	<br>
	ProductPrice:apu：${requestScope.CPUproduct.name}  ---  Cpu: <s:property value="#request.CPUproduct.price"/>
	<br>
	静态属性方法调用：
	<br>
	<s:property value="@java.lang.Math@cos(0)" />
	<s:property value="@java.lang.Math@PI" />
	<br>
	调用数组类型变量的属性
	<br>
	<%
		String str[]={"a","b","c","d"};
		request.setAttribute("str", str);
	%>
	str.length=<s:property value="#attr.str.length" /><br>
	str[2]=<s:property value="#attr.str[2]"/><br>
	调用Map类型变量的属性
	<br>
	<%
		Map<String,String> abcMap=new HashMap<String,String>();
		abcMap.put("A", "a");
		abcMap.put("B", "b");
		abcMap.put("C", "c");
		request.setAttribute("abcMap", abcMap);
	%>
	abcMap.size=<s:property value="#attr.abcMap.size"/>
	abcMap[A]=<s:property value="#attr.abcMap[\"B\"]"/>
</body>
</html>