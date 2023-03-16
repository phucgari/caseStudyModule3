<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
    <title>Planned Transaction</title>
    <!--Made with love by Mutiullah Samim -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <section class="panel">
        <header class="panel-heading">
            All Transaction List
            <span class="pull-right">
                <form action="/transaction">
                    <button type="button" id="loading-btn" class="btn btn-warning btn-xs"><i class="fa fa-refresh"></i> Refresh</button>
                </form>
                <a href="/transaction?action=create&id=${transaction.id}" class=" btn btn-success btn-xs"> Create New Transaction</a>
            </span>
        </header>
        <div class="panel-body">
            <form method="get">
                <div class="row">
                    <c:if test="${transaction != null}">
                        <input type="hidden" name="id" value="${transaction.wallet.id}"/>
                    </c:if>
                    <div class="col-5">
                        <input type="datetime-local" name="timeStart" id="timeStart"  min="2018-06-07T00:00" max="2024-06-14T00:00" size="35"
                               value='2018-06-07T00:00'>
                    </div>
                    <div class="col-5">
                        <input type="datetime-local" name="timeEnd" id="timeEnd"  min="2018-06-07T00:00" max="2024-06-14T00:00" size="35"
                               value='2024-06-14T00:00'>
                    </div>
                    <div class="col-5">
                        <input type="number" class="inputlg form-control"
                           name="moneyStart">
                    </div>
                    <div class="col-5">
                        <input type="number" class="inputlg form-control"
                               name="moneyEnd">
                    </div>
                    <div class="col-2">
                        <span class="input-group-btn"><button type="submit" class="btn btn-sm btn-success"> search</button> </span>
                    </div>
                </div>
            </form>
        </div>
        <table class="table table-hover p-table">
            <thead>
            <tr>
                <th>Action</th>
                <th>Money Amount</th>
                <th>Custom</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope['transactions']}" var="transaction">
                <tr>
                    <td class="p-name">
                        <h4 href="project_details.html">${transaction.getAction()}</h4>
                    </td>
                    <td>
                        <span class="">${transaction.getMoney_Amount()}</span>
                    </td>
                    <td>
                        <span class="">${transaction.getTime()}</span>
                    </td>
                    <td>
                        <a href="/transaction?action=edit&id=${transaction.getId()}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                        <a href="/transaction?action=delete&id=${transaction.getId()}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>
