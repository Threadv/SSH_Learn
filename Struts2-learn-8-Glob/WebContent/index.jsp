<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="i18.action?request_locale=en_US">English</a>
<a href="i18.action?request_locale=zh_CN">中文</a>
<s:form acceptcharset="Test" method="post">
	<s:textfield label="%{getText('username')}" name="username"></s:textfield>
	<s:textfield key="username" name="username"></s:textfield>
	<s:password key="password" name="password"></s:password>
	<s:submit key="submit" value="submit"></s:submit>
</s:form>
	
</body>
</html>