<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/schedule.js" var="scheduleJs" />
    <script src="${scheduleJs}"></script>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
        <script src="${jquery}"></script>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
                    <li class="active"><a href="#">课表管理</a></li>
                    <li><a href="/web/customers">顾客管理</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div>添加公共课</div></br>
    <form  action="/web/schedules/creation" method="post">
        课程名: <input style="border-color: pink" type="text" name="name"/>
        教 练: <select  name="coachId">
        <c:forEach  var="coach" items="${coachList}">
            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
        </c:forEach>
    </select>
        时 间: <input style="border-color: pink" name="date" type="date"/>
        <input align="center" style="border-color: wheat" type="submit" value="确定添加"/>
    </form>

    <div >添加私教课</div></br>
    <form  action="/web/schedules/creation/private" method="post">
        课程名: <input style="border-color: pink" type="text" value="私教课" readonly/>
        教 练: <select  name="coachId">
        <c:forEach  var="coach" items="${coachList}">
            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
        </c:forEach>
    </select>
        顾客:<select  name="customerId">
        <c:forEach  var="customer" items="${customerList}">
            <c:if test="${customer.employee.id == null}">
                <option value="<c:out value="${customer.id}"/>"><c:out value="${customer.name}"/></option>
            </c:if>
        </c:forEach>
    </select>
        时 间: <input style="border-color: pink" name="date" type="date"/>
        <input align="center" style="border-color: wheat" type="submit" value="确定添加"/>
    </form>
    <div align="center">课程时间表</div></br>

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
