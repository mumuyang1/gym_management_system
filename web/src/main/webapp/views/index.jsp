<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"
                                                   aria-hidden="true"></span>健身房管理系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/web/employees">员工管理</a></li>
                <li class="active"><a href="#">课程管理</a></li>
                <li><a href="/web/schedules">课表管理</a></li>
                <li><a href="/web/customers">顾客管理</a></li>
            </ul>
        </div>
    </div>
</nav>
<%--<button type="button" style="border-color: pink" align="center" onclick="location = '/web/courses>'">课程管理</button>--%>
<%--<button type="button" style="border-color: pink" align="center" onclick="location = '/web/users>'">员工管理</button>--%>
</body>
</html>
