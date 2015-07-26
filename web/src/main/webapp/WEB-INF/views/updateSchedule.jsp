<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <link href="/lib/css/bootstrap.min.css" rel="stylesheet"/>
    <title></title>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <h3>更新时间安排信息</h3>

    <form id="updateScheduleInfoForm">

        <input id="idInput" type="text" name="id" value="${schedule.id}" hidden="hidden"/>
        <input type="text" name="courseId" value="${schedule.course.id}" hidden="hidden"/>
        <input type="text" name="coachId" value="${schedule.course.employee.id}" hidden="hidden"/>

        课程名: <input style="border-color: pink" type="text" name="courseName" readonly="readonly"
                    value="${schedule.course.name}">
        教练 : <input style="border-color: pink" type="text" name="courseName" readonly="readonly"
                    value="${schedule.course.employee.name}">
        时间: <input style="border-color: pink" type="date" name="date" value="${schedule.date}"/>
        <input style="border-color: wheat" type="submit" value="确定"/>
    </form>
</div>
<script src="/lib/js/jquery-1.11.1.min.js"></script>
<script src="js/updateSchedule.js"></script>
</body>
</html>
