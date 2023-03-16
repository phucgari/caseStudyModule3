<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/13/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Wallets of ${requestScope["login_name"]}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Homepage</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link active" aria-current="page" href="/user?action=login">Logout</a>--%>
                <%--                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" onclick="confirmDelete()">Delete ${requestScope["login_name"]}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user?action=editProfile">Update ${requestScope["login_name"]}</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Wallets
                    </a>
                    <form method="post">
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach items='${requestScope["wallets"]}' var="wallet">
                                <li><button class="dropdown-item" name="wallet_id" value="${wallet.getId()}">${wallet.getName()}: ${wallet.getBalance()}</button></li>
                            </c:forEach>
                            <li>
                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <a href="/wallet?action=create">+Create...</a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="">Planned Transaction</a>
                    <%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                </li>
            </ul>
            <form class="d-flex">
                <a class="nav-link active" aria-current="page" href="/user?action=login">Logout</a>
                <%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                <%--                <button class="btn btn-outline-success" type="submit">Search</button>--%>
            </form>
        </div>
    </div>
</nav>

<table class="table table-hover p-table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Balance</th>
        <th>Custom</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope['wallets']}" var="wallet">
        <tr>
            <td class="p-name">
                <h4 href="project_details.html">${wallet.getName()}</h4>
            </td>
            <td>
                <span class="">${wallet.getBalance()}</span>
            </td>
            <td>
                <a href="/wallet?action=edit&id=${wallet.getId()}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                <a href="/wallet?action=delete&id=${wallet.getId()}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
