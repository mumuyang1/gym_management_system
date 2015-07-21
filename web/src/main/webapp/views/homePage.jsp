<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
                    <li><a href="/web/employees">员工管理</a></li>
                    <li><a href="/web/courses">课程管理</a></li>
                    <li><a href="web/customers">顾客管理</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="panel panel-danger">
        <div class="panel-heading"><h1>健身房管理系统欢迎您！</h1></div>
        <div class="panel-body">
            <div class="jumbotron">
                <div><h3>&nbsp;&nbsp;亲,来此购商城商品种类多，质量好，给您最开心的购物体验！快来选购吧！</h3></div><br>
                <p class="text-center">本店郑重承诺，假一赔十！质量有保证让您买的放心！
                    <span class="glyphicon glyphicon-heart text-danger"></span>
                </p><br>
                <p class="text-center">
                    <a class="btn btn-primary btn-lg" href="web/courses">查看课程<span class="glyphicon glyphicon glyphicon-hand-up"></span></a>
                </p>
            </div>
        </div>
    </div>
    </div>
   <div ></div>
</body>
</html>
