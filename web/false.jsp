<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2021/1/26
  Time: 17:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误信息</title>
    <style>
        .content{
            position: absolute;
            width: 200px;
            height: 200px;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            text-align: center;
            line-height: 2.3;
        }
        .content a{
            font-size: 16px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="content">
    <span>${falseMessage}</span>
    <br>
    <hr>
    <a href="/register.jsp">立即注册</a>
</div>
</body>
</html>
