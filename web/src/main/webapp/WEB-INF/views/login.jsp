<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">

    <h3 align="center">登录</h3>

    <div align="center">
        <form action="/web/users/login" method="post">
            用户名:&nbsp;<input type="text" name="name"></br>
            密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name="password"/></br></br>
            <input align="center" style="border-color: wheat" type="submit" value="登录"/>
        </form>
        还没有账号？点这里，注册一个免费账号</br></br>
        <button type="button" style="border-color: pink" onclick="location = '/web/users/sign-up'">注册
        </button>
    </div>
</div>
</body>
</html>
