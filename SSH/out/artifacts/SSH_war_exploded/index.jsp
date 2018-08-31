<%--
  User: 刘兰聪
  Date: 2018/08/12
  Time: 16:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>欢迎注册</title>
    </head>
    <body>
        <form action="user_save" method="post">
            用户名：<input type="text" name="name" id="userName">
            <br>
            密码：<input type="password" name="password" id="userPassword">
            <br>
            <input type="submit" value="注册">
        </form>
    </body>
</html>
