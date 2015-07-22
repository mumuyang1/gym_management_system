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
    <spring:url value="/js/customer.js" var="customerJs"/>
    <script src="${customerJs}"></script>
</head>
<body>
<div class="container">
    <jsp:include page="navigator.jsp"/>
    <div align="center">
        <form id="updateCustomerForm" hidden>
            名字: <input type="text" name="customerName"/>
            <input id="idInput" type="text" name="customerId" hidden/>
            <input align="center" type="submit" onclick="updateCustomer();" value="更新"/>
        </form>
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
                        <%--<button type="button" align="center"--%>
                        <%--onclick="location='/web/customers/<c:out value="${customer.id}"/>'">更新--%>
                        <%--</button> --%>
                    <button class="update" type="button" align="center" data-id="<c:out value="${customer.id}"/>"
                            data-name="<c:out value="${customer.name}"/>">
                        更新
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
</div>
</body>
</html>
