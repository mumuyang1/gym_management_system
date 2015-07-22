<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<link href="${bootstrapCss}" rel="stylesheet"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <spring:url value="/lib/js/customer.js" var="customerJs"/>
    <script src="${customerJs}"></script>
    <spring:url value="/lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/views/navigator.jsp" />
    <div align="center">
        <c:if test="${customerToBeUpdated != null}">
            <form id="updateCustomerForm">
                名字: <input style="border-color: green" type="text" value="${customerToBeUpdated.name}" name="name"/>
                <input id="idInput" type="text" value="${customerToBeUpdated.id}" name="id" hidden/>
                <input align="center" style="border-color: green" type="submit"
                       onclick="updateCustomer(<c:out value="${customerToBeUpdated.id}"/>);" value="更新"/>
            </form>
        </c:if>
        <form action="/web/customers/creation" method="post">
            名字: <input style="border-color: pink" type="text" name="name"/>
            <input align="center" style="border-color: wheat" type="submit" value="添加"/>
        </form>
    </div>
    <table align="center" border="2" bgcolor="#ffc0cb">
        <tr align="center">
            <td>姓名</td>
            <td>私教</td>
            <td>删除</td>
            <td>更新</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr align="center">
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.employee.name}"/></td>
                <td><a href="javascript:;" onclick="deleteCustomer(<c:out value="${customer.id}"/>);">删除</a></td>
                <td>
                    <button type="button" align="center"
                            onclick="location='/web/customers/<c:out value="${customer.id}"/>'">更新
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
</div>
</body>
</html>
