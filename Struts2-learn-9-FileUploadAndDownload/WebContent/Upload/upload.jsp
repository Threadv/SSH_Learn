<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
	<s:form action="upload.action" method="post" enctype="multipart/form-data">
		<s:file name="fileTest" label="请选择文件"></s:file>
		<s:submit value="上传"></s:submit>
	</s:form>
	<s:if test="fileTest!=null">
	
		<s:property value="fileName"/>
		<s:property value="fileContentType"/>
	
	</s:if>
</body>
</html>