<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="./style/customer.css" rel="stylesheet" type="text/css">
    <link href="./lib/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<jsp:include page="navigator.jsp"/>
<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <div>
            <h3 id="updateText" class="text-danger" hidden>更新顾客</h3>

            <form id="updateCustomerForm" class="form-horizontal" hidden>
                <input id="idInput" type="text" name="customerId" hidden/>
                <input id="coachIdInput" type="text" name="coachId" hidden/>

                <div class="form-group">
                    <label for="inputCustomerName" class="col-sm-2 control-label">顾客:</label>

                    <div class="col-sm-7">
                        <input type="text" name="customerName" class="form-control" id="customerName"
                               placeholder="请输入顾客名字">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" onclick="updateCustomer()">更新</button>
                    </div>
                </div>
            </form>
        </div>
        <h3 class="text-danger">添加顾客</h3>

        <form action="/web/customers/creation" method="post" class="form-horizontal">
            <div class="form-group">
                <label for="inputCustomerName" class="col-sm-2 control-label">顾客:</label>

                <div class="col-sm-7">
                    <input type="text" name="name" class="form-control" id="inputCustomerName" placeholder="请输入顾客名字">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <table border="1" class="table table-bordered text-center">
            <tr align="center">
                <td>姓名</td>
                <td>私教</td>
                <td>删除</td>
                <td>更新</td>
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td><c:out value="${customer.name}"/></td>
                    <td><c:out value="${customer.employee.name}"/></td>
                    <td><a class="btn btn-sm btn-danger" href="javascript:;"
                           onclick="deleteCustomer(<c:out value="${customer.id}"/>);">删除</a></td>
                    <td>
                        <button class="update btn btn-sm btn-success" type="button" align="center"
                                data-id="<c:out value="${customer.id}"/>"
                                data-name="<c:out value="${customer.name}"/>"
                                data-coach-id="<c:out value="${customer.employee.id}"/>">
                            更新
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="./lib/js/jquery-1.11.1.min.js"></script>
<script src="./js/customer.js"></script>
</body>
</html>
