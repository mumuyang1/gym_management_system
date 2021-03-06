<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <link href="./lib/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="./style/schedules.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="navigator.jsp"/>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-4">
        <h3 class="text-danger" align="left">添加公共课</h3>

        <form action="/web/schedules/creation" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="inputCourseName" class="col-sm-3 control-label">课程/教练:</label>

                <div class="col-sm-7">
                    <select id="inputCourseName" name="courseId" class="form-control">
                        <c:forEach var="course" items="${courseList}">
                            <c:if test="${course.name != '私教课'}">
                                <option value="<c:out value="${course.id}"/>"><c:out
                                        value="${course.name} / ${course.employee.name}"/></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputDate" class="col-sm-3 control-label">时间:</label>

                <div class="col-sm-7">
                    <input name="date" type="date" class="form-control" id="inputDate">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>

    <div class="col-md-4">
        <h3 class="text-danger">添加私教课</h3>

        <form action="/web/schedules/creation/private" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">课程:</label>

                <div class="col-sm-7">
                    <input type="text" name="name" class="form-control" id="inputPrivateCourseName"
                           readonly value="私教课">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPrivateCoach" class="col-sm-2 control-label">教练:</label>

                <div class="col-sm-7">
                    <select id="inputPrivateCoach" name="coachId" class="form-control">
                        <c:forEach var="coach" items="${coachList}">
                            <option value="<c:out value="${coach.id}"/>"><c:out value="${coach.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPrivateCustomer" class="col-sm-2 control-label">顾客:</label>

                <div class="col-sm-7">
                    <select id="inputPrivateCustomer" name="customerId" class="form-control">
                        <c:forEach var="customer" items="${customerList}">
                            <c:if test="${customer.employee.id == null}">
                                <option value="<c:out value="${customer.id}"/>"><c:out
                                        value="${customer.name}"/></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPrivateDate" class="col-sm-2 control-label">时间: </label>

                <div class="col-sm-7">
                    <input name="date" type="date" class="form-control" id="inputPrivateDate">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-2"></div>
</div>


<h3 class="text-danger" align="center">课程时间表</h3>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <table align="center" border="1" class="table table-bordered">
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
                    <td><a href="javascript:;" class="btn btn-sm btn-danger"
                           onclick="deleteASchedule(<c:out value="${schedule.id}"/>);">删除</a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-sm btn-success"
                                onclick="location = '/web/schedules/<c:out value="${schedule.id}"/>'">更新
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="./js/schedule.js"></script>
<script src="./lib/js/jquery-1.11.1.min.js"></script>
</body>
</html>
