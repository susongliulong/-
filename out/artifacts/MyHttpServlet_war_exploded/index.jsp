<%--
  Created by IntelliJ IDEA.
  User: 刘龙
  Date: 2020/12/9
  Time: 23:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
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
        border-bottom: 1px solid lightgray;
      }
      .main .login .middle .left .login_choose span{
        float: left;
        width: 50%;
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
      .main .login .middle .left .form .forget_password{
        font-size: 14px;
        margin-top: 8px;
        margin-left: 130px;
      }
      .main .login .middle .left .form .forget_password a{
        color: #00b38a;
      }
      .main .login .middle .right{
        float: right;
        width: 156px;
        height: 242px;
        border-left: 1px solid lightgray;
      }
      .main .login .middle .right .other_login{
        position: absolute;
        margin-top: 62px;
        margin-left: 20px;
        width: 136px;
        height: 180px;
      }
      .main .login .middle .right .other_login p{
        font-size: 12px;
        line-height: 2.2;
        color: #9c9797;
      }
      .main .login .middle .right .other_login p:nth-of-type(2){
        color: #00b38a;
      }
      .main .login .middle .right .other_login p:nth-of-type(2) span{
        margin-left: 3px;
      }
      .main .login .middle .right .other_login p .register{
        position: absolute;
        top: 32px;
        left: 59px;
        width: 15px;
        height: 15px;
      }
      .main .login .middle .or{
        position: absolute;
        margin-top: 107px;
        margin-left: 233px;

      }
      .main .login .middle .right .other_login p:last-child span{
        margin-right: 14px;
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
              <span><a href="">密码登录</a></span>
              <span><a href="">验证码登录</a></span>
            </div>

            <div class="form">
              <form action="/login" method="post">
                <input type="text" placeholder="请输入你的账号" name="name">
                <input type="password" placeholder="请输入你的密码" name="password">
                <div class="forget_password"><a href="">忘记密码？</a></div>
                <input type="submit" value="提交">
              </form>
            </div>

          </div>
          <div class="right">
            <div class="other_login">
              <p>还没有账号：</p>
              <p>立即注册<span><a href=""><img src="image/register.png" alt="" class="register"></a></span></p>
              <p>使用下面账号直接登录：</p>
              <p>
                <span><a href=""><img src="image/icon-sina1.png" alt=""></a></span>
                <span><a href=""><img src="image/icon-baidu.png" alt=""></a></span>
                <span><a href=""><img src="image/icon-wechat.png" alt=""></a></span>
                <span><a href=""><img src="image/icon-tencent.png" alt=""></a></span>
              </p>
            </div>
          </div>
          <div class="or"><span>or</span></div>
        </div>
      </div>

    </div>
  </div>
  </body>
</html>
