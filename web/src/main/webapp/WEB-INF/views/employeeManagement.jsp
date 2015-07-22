<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./style/employees.css" rel="stylesheet" type="text/css"/>

<html>
<head>
    <title></title>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <spring:url value="/js/user.js" var="userJs"/>
    <script src="${userJs}"></script>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <div id="updateForm" hidden>
        <form id="updateUserInfoForm">
            <input type="text" name="employeeId" hidden/>
            <input id="idInput" type="text" name="id" hidden/>

            登录名: <input type="text" name="userName"/>
            密码: <input type="password" name="password"/>
            姓名: <input type="text" name="name"/>
            性别: <input type="text" name="gender"/>
            邮箱: <input type="email" name="email"/>
            职位: <select name="position">
            <option
                    <c:if test="${userToBeUpdated.employee.position == 'COACH'}">selected</c:if> value="COACH">COACH
            </option>
            <option
                    <c:if test="${userToBeUpdated.employee.position == 'HR'}">selected</c:if> value="HR">HR
            </option>
            <option
                    <c:if test="${userToBeUpdated.employee.position == 'OPs'}">selected</c:if> value="OPs">OPs
            </option>
        </select>

            <input align="center" type="submit" onclick="updateUser();" value="更新"/>
        </form>
    </div>
    <table id="userInfoTable">
        <tr id="userInfoTableTheFirstLine">
            <td>登录名</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>邮箱</td>
            <td>职位</td>
            <td>删除</td>
            <td>更新用户信息</td>

        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.employee.name}"/></td>
                <td><c:out value="${user.employee.gender}"/></td>
                <td><c:out value="${user.employee.email}"/></td>
                <td><c:out value="${user.employee.position}"/></td>
                <td><a class="delete button" href="javascript:"
                       onclick="deleteUser(<c:out value="${user.id}"/>);">删除</a></td>
                <td>
                    <a class="update button" href="javascript:" data-user-name="<c:out value="${user.userName}"/>"
                       data-password="<c:out value="${user.password}"/>"
                       data-employee-name="<c:out value="${user.employee.name}"/>"
                       data-employee-email="<c:out value="${user.employee.email}"/>"
                       data-employee-gender="<c:out value="${user.employee.gender}"/>"
                       data-employee-position="<c:out value="${user.employee.position}"/>"
                       data-employee-id="<c:out value="${user.employee.id}"/>"
                       data-id="<c:out value="${user.id}"/>"
                            >
                        更新用户信息
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
