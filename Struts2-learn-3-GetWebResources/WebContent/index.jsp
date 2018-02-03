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
	<a href="TextActionContext.action?name=llanc">ActionContext</a>
	
	<%
		if(application.getAttribute("date")==null){
			application.setAttribute("date",new Date());
		}
	%>
	
</body>
</html>