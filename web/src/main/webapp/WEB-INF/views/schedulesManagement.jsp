<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<html>
<head>
    <title></title>
    <spring:url value="/js/schedule.js" var="scheduleJs"/>
    <script src="${scheduleJs}"></script>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</head>
<body>

<div class="container">

    <jsp:include page="navigator.jsp"/>

    <div>添加公共课</div>
    </br>
    <form action="/web/schedules/creation" method="post">
        课程名: <input style="border-color: pink" type="text" name="name"/>
        教 练: <select name="coachId">
        <c:forEach var="coach" items="${coachList}">
            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
        </c:forEach>
    </select>
        时 间: <input style="border-color: pink" name="date" type="date"/>
        <input align="center" style="border-color: wheat" type="submit" value="确定添加"/>
    </form>

    <div>添加私教课</div>
    </br>
    <form action="/web/schedules/creation/private" method="post">
        课程名: <input style="border-color: pink" type="text" value="私教课" readonly/>
        教 练: <select name="coachId">
        <c:forEach var="coach" items="${coachList}">
            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
        </c:forEach>
    </select>
        顾客:<select name="customerId">
        <c:forEach var="customer" items="${customerList}">
            <c:if test="${customer.employee.id == null}">
                <option value="<c:out value="${customer.id}"/>"><c:out value="${customer.name}"/></option>
            </c:if>
        </c:forEach>
    </select>
        时 间: <input style="border-color: pink" name="date" type="date"/>
        <input align="center" style="border-color: wheat" type="submit" value="确定添加"/>
    </form>
    <div align="center">课程时间表</div>
    </br>

    <table align="center" border="2">
        <tr align="center">
            <td>名称</td>
            <td>教练</td>
            <td>时间</td>
            <td>顾客</td>
            <td>删除</td>
            <td>更新</td>
        </tr>
        <c:forEach var="schedule" items="${scheduleList}">
            <tr align="center">
                <td><c:out value="${schedule.course.name}"/></td>
                <td><c:out value="${schedule.course.employee.name}"/></td>
                <td><c:out value="${schedule.date}"/></td>
                <td><c:out value="${schedule.customer.name}"/></td>
                <td><a href="javascript:;" onclick="deleteASchedule(<c:out value="${schedule.id}"/>);">删除</a></td>
                <td>
                    <button type="button" style="border-color: white" align="center"
                            onclick="location = '/web/schedules/<c:out value="${schedule.id}"/>'">更新
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
