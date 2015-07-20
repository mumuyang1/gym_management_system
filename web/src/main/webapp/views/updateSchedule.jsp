<%--
  Created by IntelliJ IDEA.
  User: yzli
  Date: 7/20/15
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
  <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jQuery" />
  <script src="${jQuery}"></script>
  <spring:url value="/lib/js/updateSchedule.js" var="updateCourseJs" />
  <script src="${updateCourseJs}"></script>
  <title></title>
</head>
<body>

<h3>更新时间安排信息</h3>

<form id="updateScheduleInfoForm">

  <input id="idInput" type="text" name="id" value="${schedule.id}" hidden="hidden" />
  <input  type="text" name="courseId" value="${schedule.course.id}" hidden="hidden" />
  <input  type="text" name="coachId" value="${schedule.course.employee.id}" hidden="hidden" />

  课程名: <input style="border-color: pink" type="text" name="courseName" readonly="readonly" value="${schedule.course.name}">
  教练   : <input style="border-color: pink" type="text" name="courseName" readonly="readonly" value="${schedule.course.employee.name}">
  <%--<select name="coachId">--%>
    <%--<c:forEach  var="coach" items="${coachList}">--%>
      <%--<option <c:if test="${coach.id == schedule.course.employee.id}">selected </c:if> value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>--%>
    <%--</c:forEach>--%>
  <%--</select>--%>
  时间: <input style="border-color: pink" type="date"  name="date" value="${schedule.date}"/>
  <input style="border-color: wheat"  type="submit" value="确定" />
</form>

</body>
</html>
