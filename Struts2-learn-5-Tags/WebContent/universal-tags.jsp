<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="line-height: 30px">
<s:debug></s:debug>
<hr>
property标签:获取值栈中对象值
<br>
栈顶对象：<s:property />
<br>
<hr>
url标签：动态创建url（字符串）
<br>
 静态：<s:url value="/url-tag-test" var="url"/>
${url }
<br>
带静态参数：<s:url value="/url-tag-test" var="url01">
			<s:param name="id" value="01" />
		</s:url>
		${url01 }
<br>
带动态参数（值栈商品对象的价格,自动进行OGNL解析，无需解析是加单引号）：
<s:url value="/url-tag-test" var="url02">
	<s:param name="price" value="price" />
	<s:param name="name"  value="'name'"/>
</s:url>
${url02 }
<br>
构建请求action url:
<s:url action="action-url" namespace="/ActionUrlTest" method="execuet" var="url03">
	<s:param name="price" value="price" />
	<s:param name="name"  value="'name'"/>
</s:url>
${url03 }
<br>
包含请求参数(get--include=get/post&get--include=all)：
<s:url value="/url-tag-test" var="url04" includeParams="get">
</s:url>
${url04 }
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>