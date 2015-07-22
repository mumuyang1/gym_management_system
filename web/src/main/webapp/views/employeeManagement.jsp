<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/user.js" var="userJs"/>
    <script src="${userJs}"></script>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/views/index.jsp"/>
    <div align="center">
        <c:if test="${userToBeUpdated != null}">
            <form id="updateUserInfoForm">
                <input type="text" value="${userToBeUpdated.employee.id}" name="employeeId" hidden/>
                登录名: <input style="border-color: pink" type="text" value="${userToBeUpdated.userName}"
                            name="userName"/>
                密码: <input style="border-color: pink" type="password" value="${userToBeUpdated.password}"
                           name="password"/>
                姓名: <input style="border-color: pink" type="text" value="${userToBeUpdated.employee.name}"
                           name="name"/>
                性别: <input style="border-color: pink" type="text" value="${userToBeUpdated.employee.gender}"
                           name="gender"/>
                邮箱: <input style="border-color: pink" type="email" value="${userToBeUpdated.employee.email}"
                           name="email"/>
                职位: <select name="position">
                <option <c:if test="${userToBeUpdated.employee.position == 'COACH'}">selected</c:if> value="COACH">COACH</option>
                <option <c:if test="${userToBeUpdated.employee.position == 'HR'}">selected</c:if> value="HR">HR</option>
                <option <c:if test="${userToBeUpdated.employee.position == 'OPs'}">selected</c:if> value="OPs">OPs</option>
            </select>

                <input align="center" style="border-color: green" type="submit"
                       onclick="updateUser(<c:out value="${userToBeUpdated.id}"/>);" value="更新"/>
            </form>
        </c:if>
    </div>
    <table align="center" border="2" bgcolor="#ffc0cb">
        <tr align="center">
            <td>登录名</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>邮箱</td>
            <td>职位</td>
            <td>更新用户信息</td>
            <td>删除</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr align="center">
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.employee.name}"/></td>
                <td><c:out value="${user.employee.gender}"/></td>
                <td><c:out value="${user.employee.email}"/></td>
                <td><c:out value="${user.employee.position}"/></td>
                <td><a href="javascript:;" onclick="deleteUser(<c:out value="${user.id}"/>);">删除</a></td>
                <td>
                    <button type="button" align="center"
                            onclick="location = '/web/users/<c:out value="${user.id}"/>'">更新用户信息
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
</div>
</body>
</html>
