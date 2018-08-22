<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="toConversion" method="post">
		<s:textfield label="age" name="age"></s:textfield>
		<s:textfield label="birth" name="birth"></s:textfield>
		
		<s:submit value="Submit" label="Submit"></s:submit>
	</s:form>
</body>
</html>