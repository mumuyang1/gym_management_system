<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>--%>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./style/courses.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <spring:url value="./js/course.js" var="courseJs"/>
    <script src="${courseJs}"></script>
</head>
<body>
<jsp:include page="navigator.jsp"/>
<div id="updateCoursesForm">
    <form id="updateCourseForm" hidden>
        课程: <input type="text" name="name"/>
        <input id="idInput" type="text" name="id" hidden/>
        <input type="submit"
               onclick="updateCourse();" value="更新"/>
    </form>
</div>
<table id="courseTable">
    <tr id="courseTableTheFirstLine">
        <td>课程</td>
        <td>删除</td>
        <td>更新</td>
    </tr>
    <c:forEach var="course" items="${courseList}">
        <tr>
            <td><c:out value="${course.name}"/></td>
            <td><button class="deleteButton" type="button"
                       onclick="deleteCourse(<c:out value="${course.id}"/>);">删除
            </button>
            </td>
            <td>
                <button class="button courseTable" type="button"
                        data-course-name="<c:out value="${course.name}"/>"
                        data-course-id="<c:out value="${course.id}"/>">更新
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

