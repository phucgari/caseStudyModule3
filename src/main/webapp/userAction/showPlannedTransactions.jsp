<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <section class="panel">
        <header class="panel-heading">
            All Planned Transaction List
            <span class="pull-right">
                <form action="/plannedtransaction">
                    <button type="button" id="loading-btn" class="btn btn-warning btn-xs"><i class="fa fa-refresh"></i> Refresh</button>
                </form>
                <a href="/plannedtransaction?action=create" class=" btn btn-success btn-xs"> Create New Planned Transaction</a>
            </span>
        </header>
        <div class="panel-body">
            <form method="get">
                <div class="row">
                    <div class="col-5">
                        <input type="number" placeholder="Minimum Money_amount" class="inputlg form-control"
                               name="money_start">
                    </div>
                    <div class="col-5">
                        <input type="number" placeholder="Maximum Money_amount" class="inputlg form-control"
                               name="money_end">
                    </div>
                    <div class="col-2">
                        <span class="input-group-btn"><button type="submit"
                                                              class="btn btn-sm btn-success"> search</button> </span>
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
            <c:forEach items="${requestScope['list']}" var="plannedTransaction">
                <tr>
                    <td class="p-name">
                        <h4 href="project_details.html">${plannedTransaction.getAction()}</h4>
                    </td>
                    <td>
                        <span class="">${plannedTransaction.getMoney_Amount()}</span>
                    </td>
                    <td>
                        <a href="/plannedtransaction?action=edit&id=${plannedTransaction.getId()}"
                           class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                        <a href="/plannedtransaction?action=delete&id=${plannedTransaction.getId()}"
                           class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>
