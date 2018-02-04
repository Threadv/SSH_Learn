<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="TestActionContext.action?name=llanc">非耦合方式之：ActionContext</a><br>
	<a href="TestAware.action?name=llanc">非耦合方式之：XxxAware接口</a><br>
	<a href="TestServletActionContext.action?name=llanc">耦合方式之：ServletActionContext</a><br>
	<a href="TestServletAware.action?name=llanc">耦合方式之：ServletXxxAware接口</a>
	
	<%
		if(application.getAttribute("date")==null){
			application.setAttribute("date",new Date());
		}
	%>
	
</body>
</html>