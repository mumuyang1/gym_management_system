<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/lib/css/bootstrap.min.css" var="bootstrapCss"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${bootstrapCss}" rel="stylesheet"/>
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
    <nav class="navbar navbar-default">
        <div class="container-fluid">
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
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/web/employees">员工管理</a></li>
                    <li><a href="/web/courses">课程管理</a></li>
                    <li class="active"><a href="#">顾客管理</a></li>
                </ul>
            </div>
        </div>
    </nav>
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
