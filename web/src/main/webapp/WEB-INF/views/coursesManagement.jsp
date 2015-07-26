<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="./style/courses.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="navigator.jsp"/>
<div>
    <form id="updateCourseForm" hidden>
        课程: <input id="nameInput" type="text" name="name"/>
        <input id="idInput" type="text" name="id" hidden/>
        <input class="submitInput" id="submitInput" type="submit"
               onclick="updateCourse();" value="更新"/>
    </form>
    <form id="addCourseForm" action="/web/courses/creation" method="post">

        名称: <input type="text" name="name"/>

        <input align="center" type="submit" value="添加"/>
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
            <td>
                <button class="delete-button" type="button"
                        onclick="deleteCourse(<c:out value="${course.id}"/>);">删除
                </button>
            </td>
            <td>
                <button class="update-button" type="button"
                        data-course-name="<c:out value="${course.name}"/>"
                        data-course-id="<c:out value="${course.id}"/>">更新
                </button>
            </td>
        </tr>
    </c:forEach>
    <script src="./lib/js/jquery-1.11.1.min.js"></script>
    <script src="./js/course.js"></script>
</table>
</body>
</html>

