<%--
  Created by IntelliJ IDEA.
  User: yzli
  Date: 7/17/15
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div class="container">
    <jsp:include page="index.jsp"/>
    <h3 align="center">注册</h3>

    <div align="center">
        <form action="/web/users/sign-up" method="post">
            登录名:&nbsp;<input type="text" name="userName"></br></br>
            密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input type="password" name="password"/></br></br>
            姓&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input type="text" name="name"></br></br>
            性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input type="text" name="gender"/></br></br>
            邮&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;<input type="email" name="email"/></br></br>
            职&nbsp;&nbsp;&nbsp;&nbsp;位:&nbsp;
            <select name="position">
                <option value="COACH">COACH</option>
                <option value="HR">HR</option>
                <option value="OPs">OPs</option>
            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</br></br>
            <input align="center" style="border-color: wheat" type="submit" value="创建用户"/>
        </form>
    </div>
</div>
</body>
</html>
