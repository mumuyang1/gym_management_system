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
    <jsp:include page="/views/index.jsp"/>
    <div align="center" id="mDiv">
        该时间已被占用，请重新选时间！
        <button type="button" style="border-color: pink" onclick="location = '/web/schedules'">重新添加课程</button>
    </div>
</div>
</body>
</html>
