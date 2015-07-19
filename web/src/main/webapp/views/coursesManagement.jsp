<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>课程管理</h3></br>

<form align="center" action="/web/courses/creation" method="post">
    课程名: <input style="border-color: pink" type="text" name="name"/>
    教 练: <select name="coachId">
        <c:forEach var="coach" items="${coachList}">
             <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
        </c:forEach>
            </select>
    时 间: <input style="border-color: pink" name="date" type="date"/>
    <input align="center" style="border-color: wheat" type="submit" value="确定添加"/>
</form>

<table align="center" border="2">
    <tr align="center">
        <td>名称</td>
        <td>教练</td>
        <td>时间</td>
        <td>删除</td>
        <td>更新</td>
    </tr>
    <c:forEach var="schedule" items="${scheduleList}">
        <tr align="center">
            <td><c:out value="${schedule.course.name}"/></td>
            <td><c:out value="${schedule.course.employee.name}"/></td>
            <td><c:out value="${schedule.date}"/></td>
            <td><a href="javascript:;" onclick="deleteUser(<c:out value="${schedule.id}"/>);">删除</a></td>
            <td>
                <button type="button" style="border-color: white" align="center"
                        onclick="location = '/web/users/<c:out value="${user.userId}"/>'">更新
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</br>

<div align="center">
    <button type="button" style="border-color: pink" onclick="location = '/web/users/creation'">增加课程</button>
</div>

</body>
</html>
