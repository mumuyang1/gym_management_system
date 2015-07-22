<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <spring:url value="/lib/js/course.js" var="courseJs"/>
    <script src="${courseJs}"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/views/index.jsp"/>
    <div align="center">
        <c:if test="${courseToBeUpdated != null}">
            <form id="updateCourseForm">
                课程: <input style="border-color: green" type="text" value="${courseToBeUpdated.name}" name="name"/>
                <input id="idInput" type="text" value="${courseToBeUpdated.id}" name="id" hidden/>
                <input align="center" style="border-color: green" type="submit"
                       onclick="updateCourse(<c:out value="${courseToBeUpdated.id}"/>);" value="更新"/>
            </form>
        </c:if>
    </div>
    <table align="center" border="2" bgcolor="#ffc0cb">
        <tr align="center">
            <td>课程</td>
            <td>删除</td>
            <td>更新</td>
        </tr>
        <c:forEach var="course" items="${courseList}">
            <tr align="center">
                <td><c:out value="${course.name}"/></td>
                <td><a href="javascript:;" onclick="deleteCourse(<c:out value="${course.id}"/>);">删除</a></td>
                <td>
                    <button type="button" align="center"
                            onclick="location = '/web/courses/<c:out value="${course.id}"/>'">更新
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
</div>
</body>
</html>

