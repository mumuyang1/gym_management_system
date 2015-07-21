<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/course.js" var="courseJs"/>
    <script src="${courseJs}"></script>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>健身房管理系统</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">员工管理</a></li>
                    <li><a href="/web/courses">课程管理</a></li>
                    <li><a href="/web/customers">顾客管理</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <table align="center" border="2" bgcolor="#ffc0cb">
        <tr align="center">
            <td>登录名</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>邮箱</td>
            <td>更新用户信息</td>
            <td>删除</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr align="center">'
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.employee.name}"/></td>
                <td><c:out value="${user.employee.gender}"/></td>
                <td><c:out value="${user.employee.email}"/></td>
                <td><a href="javascript:;" onclick="deleteUser(<c:out value="${user.id}"/>);">删除</a></td>
                <td>
                    <button type="button" align="center"
                            onclick="location = '/web/users/<c:out value="${user.id}"/>'">更新用户信息
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <
</div>
</body>
</html>
