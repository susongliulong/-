<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2021/1/25
  Time: 22:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台信息管理系统</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>账号</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>
                <a href="/success?type=add">添加</a>
                <a href="/success?type=update&id=${user.id}">修改</a>
                <a href="/success?type=delete&id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
