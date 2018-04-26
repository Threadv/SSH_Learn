<%@page import="java.util.*"%>
<%@page import="cn.llanc.bean.Product"%>
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
<hr>
set标签：向page,request,session,application域对象中加入一个属性值  value会被自动进行OGNL解析
<br>
<s:set name="setTagTest" value="'yes'" scope="session"></s:set>
取值：${sessionScope.setTagTest }
<br>
<hr>
push标签：把一个对象在标签开始时压入值栈，在标签结束时弹出值栈
<br>
<%
	Product product2=new Product("PustTset",1002);
	request.setAttribute("pustTest", product2);
%>
<s:push value="#request.pustTest" >
push标签内获取属性值：${name }---${price }
</s:push>
<br>
push标签外获取属性值：${name }---${price }
<br>
<hr>
if\else\elseif标签：判断
<br>
<s:if test="price<1000">
	低于1000价格实惠
</s:if>
<s:elseif test="price>1000">
	高于1000价格太高
</s:elseif>
<s:else>价格是1002</s:else>
<br>
<s:if test="#request.pustTest.getPrice()>1001">
	价格大于1001价格是：${requestScope.pustTest.price }
</s:if>
<br>
<hr>
iterator标签：变量集合，将集合对象依次压入弹出值栈,status属性的status属性值用于获取元素索引和位置
<br>
<%
	List<Product> product3=new ArrayList<Product>();
	product3.add(new Product("iterator01",101));
	product3.add(new Product("iterator02",102));
	product3.add(new Product("iterator03",103));
	product3.add(new Product("iterator04",104));
	product3.add(new Product("iterator04",105));
	session.setAttribute("iteratorTagTest", product3);
%>
<s:iterator value="#session.iteratorTagTest" status="status">
index:${status.index}--count:${status.count}-----${name }---${price }<br>
</s:iterator>
<br>
<br>
<br>
<br>
</body>
</html>