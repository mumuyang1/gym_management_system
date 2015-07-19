<%--
  Created by IntelliJ IDEA.
  User: yzli
  Date: 7/17/15
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
<h3>添加课程</h3>

<form action="/web/courses/creation" method="post">
  课程   名: <input style="border-color: pink" type="text" name="name" />
  性   别: 男<input style="border-color: pink" name="gender" type="radio" value="男" />女<input name="gender" type="radio" value="女" />
  邮   箱: <input style="border-color: pink" type="text" name="mailbox" />
  年   龄: <input style="border-color: pink" type="number" min="1" max="110" name="age" />
  密   码: <input style="border-color: pink" type="password" name="password" />
  <input  align="center" style="border-color: wheat" type="submit" value="确定" />
</form>
</body>
</html>
