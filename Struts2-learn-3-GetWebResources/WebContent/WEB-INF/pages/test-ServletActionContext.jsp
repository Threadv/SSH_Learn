<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test-ServletActionContext-page</h2>
	Request：${requestScope.requestKey}<br>
	Session：${sessionScope.sessionKey}<br>
	ServletContext:${servletContextKey}
</body>
</html>