<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2021/1/25
  Time: 18:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>

    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        a {
            text-decoration: none;
        }

        .clearFix:after {
            display: block;
            content: "";
            clear: both;
        }

        .top {
            position: absolute;
            height: 60%;
            width: 100%;
            background-color: #00b38a;
        }

        .bottom {
            position: absolute;
            height: 40%;
            width: 100%;
            background-color: #f8f9fc;
            top: 60%;
        }

        .main {
            position: absolute;
            width: 528px;
            height: 368px;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
        }
        .main .logo{
            background-color: #00b38a;
        }

        .main .logo img {
            display: block;
            width: 86px;
            height: 36px;
        }

        .main .login .head img {
            display: block;
            float: left;
            width: 40px;
            height: 40px;
            margin: 4px;
        }
        .main .login .head span{
            float: left;
            font-size: 10px;
            color: lightgray;
            border: 1px solid lightgray;
            margin-top: 3px;
            -webkit-transform:scale(0.8);
        }
        .main .login .middle{
            position: absolute;
            margin: 46px 59px;
            width: 400px;
            height: 242px;
            background-color: white;
        }
        .main .login .middle .left{
            position: absolute;
            width: 200px;
            height: 100%;
            background-color: white;
        }
        .main .login .middle .left .login_choose{
            position: absolute;
            width: 100%;
        }
        .main .login .middle .left .login_choose span{
            float: left;
            width: 100%;
            height: 20px;
            font-size: 14px;
            line-height: 20px;
            text-align: center;
            margin-bottom: 12px;

        }
        .main .login .middle .left .login_choose span a{
            color:black;
            font-weight: bold;
        }
        .main .login .middle .left .form input{
            width: 193px;
            height: 48px;
            padding: 5px 0 0 3px;
            border-style: none;
            border-bottom: 1px solid lightgray;
        }
        .main .login .middle .left .form input:first-child{
            margin-top: 40px;
        }

        .main .login .middle .left .form input:last-child{
            padding: 0;
            width: 200px;
            height: 40px;
            font-size: 16px;
            line-height: 40px;
            text-align: center;
            margin-top: 30px;
            color: white;
            background-color: #00b38a;
        }
        .main .login .middle .left .form .forget_password a{
            color: #00b38a;
        }
        .main .login .middle .right{
            float: right;
            width: 142px;
            height: 205px;
        }
        .main .login .middle .right img{
            width: 100%;
            height: 100%;
        }
        </style>
</head>
<body>
<div class="content clearFix">
    <div class="top"></div>
    <div class="bottom"></div>
    <div class="main">
        <div class="logo"><img src="image/logo.png" alt=""></div>
        <div class="login">
            <div class="head"><img src="image/left_top.png" alt=""><span>微信快捷登录</span></div>
            <div class="middle">
                <div class="left">
                    <div class="login_choose">
                        <span><a href="">注册</a></span>
                    </div>

                    <div class="form">
                        <form action="/register" method="post">
                            <input type="text" placeholder="请输入你的手机号" name="name">
                            <input type="password" placeholder="请输入你的密码" name="password">
                            <input type="submit" value="注册">
                        </form>
                    </div>
                </div>
                <div class="right">
                    <img src="image/beauty.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
