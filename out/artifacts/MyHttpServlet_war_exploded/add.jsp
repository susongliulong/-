<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2021/1/26
  Time: 18:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<form action="/success?type=adduser" method="post">
    <input type="text" placeholder="请输入你的用户名" name="name">
    <input type="password" placeholder="请输入你的密码" name="password">
    <input type="submit" value="添加">
</form>
</body>
</html>
