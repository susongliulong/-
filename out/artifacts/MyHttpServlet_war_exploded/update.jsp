<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2021/1/26
  Time: 18:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改相应信息</title>
</head>
<body>
<form action="/success?type=updateuser" method="post">
    id:<input type="text" name="id" value="${user.id}"><br>
    name:<input type="text" name="name" value="${user.name}"><br>
    password:<input type="text" name="password" value="${user.password}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
