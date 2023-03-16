<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
    <title>Planned Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        body{
            font-size: 16px;
            color: #050c3f;
            font-weight: 400;
            line-height: 28px;
            letter-spacing: 0.8px;
            margin-top:20px;
            background: rgba(223, 230, 243, 0.98);
        }
        .font-size38 {
            font-size: 38px;
        }
        .team-single-text .section-heading h4,
        .section-heading h5 {
            font-size: 36px
        }

        .team-single-text .section-heading.half {
            margin-bottom: 20px
        }

        @media screen and (max-width: 1199px) {
            .team-single-text .section-heading h4,
            .section-heading h5 {
                font-size: 32px
            }
            .team-single-text .section-heading.half {
                margin-bottom: 15px
            }
        }

        @media screen and (max-width: 991px) {
            .team-single-text .section-heading h4,
            .section-heading h5 {
                font-size: 28px
            }
            .team-single-text .section-heading.half {
                margin-bottom: 10px
            }
        }


        @media screen and (max-width: 767px) {
            .team-single-text .section-heading h4,
            .section-heading h5 {
                font-size: 24px
            }
        }


        .team-single-icons ul li {
            display: inline-block;
            border: 1px solid #02c2c7;
            border-radius: 50%;
            color: #86bc42;
            margin-right: 8px;
            margin-bottom: 5px;
            -webkit-transition-duration: .3s;
            transition-duration: .3s
        }

        .team-single-icons ul li a {
            color: #02c2c7;
            display: block;
            font-size: 14px;
            height: 25px;
            line-height: 26px;
            text-align: center;
            width: 25px
        }

        .team-single-icons ul li:hover {
            background: #02c2c7;
            border-color: #02c2c7
        }

        .team-single-icons ul li:hover a {
            color: #fff
        }

        .team-social-icon li {
            display: inline-block;
            margin-right: 5px
        }

        .team-social-icon li:last-child {
            margin-right: 0
        }

        .team-social-icon i {
            width: 30px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            font-size: 15px;
            border-radius: 50px
        }

        .padding-30px-all {
            padding: 30px;
        }
        .bg-light-gray {
            background-color: #f7f7f7;
        }
        .text-center {
            text-align: center!important;
        }
        img {
            width: 100%;
            height: 100%;
        }


        .list-style9 {
            list-style: none;
            padding: 0
        }

        .list-style9 li {
            position: relative;
            padding: 0 0 15px 0;
            margin: 0 0 15px 0;
            border-bottom: 1px dashed rgba(0, 0, 0, 0.1)
        }

        .list-style9 li:last-child {
            border-bottom: none;
            padding-bottom: 0;
            margin-bottom: 0
        }


        .text-sky {
            color: #02c2c7
        }

        .text-orange {
            color: #e95601
        }

        .text-green {
            color: #5bbd2a
        }

        .text-yellow {
            color: #f0d001
        }

        .text-pink {
            color: #ff48a4
        }

        .text-purple {
            color: #9d60ff
        }

        .text-lightred {
            color: #ff5722
        }

        a.text-sky:hover {
            opacity: 0.8;
            color: #02c2c7
        }

        a.text-orange:hover {
            opacity: 0.8;
            color: #e95601
        }

        a.text-green:hover {
            opacity: 0.8;
            color: #5bbd2a
        }

        a.text-yellow:hover {
            opacity: 0.8;
            color: #f0d001
        }

        a.text-pink:hover {
            opacity: 0.8;
            color: #ff48a4
        }

        a.text-purple:hover {
            opacity: 0.8;
            color: #9d60ff
        }

        a.text-lightred:hover {
            opacity: 0.8;
            color: #ff5722
        }

        .custom-progress {
            height: 10px;
            border-radius: 50px;
            box-shadow: none;
            margin-bottom: 25px;
        }
        .progress {
            display: -ms-flexbox;
            display: flex;
            height: 1rem;
            overflow: hidden;
            font-size: .75rem;
            background-color: #e9ecef;
            border-radius: .25rem;
        }


        .bg-sky {
            background-color: #02c2c7
        }

        .bg-orange {
            background-color: #e95601
        }

        .bg-green {
            background-color: #5bbd2a
        }

        .bg-yellow {
            background-color: #f0d001
        }

        .bg-pink {
            background-color: #ff48a4
        }

        .bg-purple {
            background-color: #9d60ff
        }

        .bg-lightred {
            background-color: #ff5722
        }
    </style>
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
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/user">Profile</a>
                </li>
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
                                <li><a class="dropdown-item" name="wallet_id" value="${wallet.getId()}" href="/transaction?id=${wallet.getId()}">${wallet.getName()}: ${wallet.getBalance()}</a></li>
                            </c:forEach>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <a class="dropdown-item" href="/wallet?action=create">+Create...</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="/wallet">Show All Wallets</a>
                            </li>
                        </ul>
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/plannedtransaction">Planned Transaction</a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script>
    function confirmDelete()  {
        if(confirm("Are you sure ?")) {
            window.location = "user?action=delete"
        }

    }
</script>
</body>
</html>
