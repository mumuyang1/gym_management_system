<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">

    <jsp:include page="index.jsp"/>
    <div class="panel panel-danger">
        <div class="panel-heading"><h1>健身房管理系统欢迎您！</h1></div>
        <div class="panel-body">
            <div class="jumbotron">
                <div><h3>&nbsp;&nbsp;亲,来此购商城商品种类多，质量好，给您最开心的购物体验！快来选购吧！</h3></div>
                <br>

                <p class="text-center">本店郑重承诺，假一赔十！质量有保证让您买的放心！
                    <span class="glyphicon glyphicon-heart text-danger"></span>
                </p><br>

                <p class="text-center">
                    <a class="btn btn-primary btn-lg" href="web/courses">查看课程<span
                            class="glyphicon glyphicon glyphicon-hand-up"></span></a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
