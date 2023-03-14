<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
        img.profilepic{
            max-height: 450px;
            width:100%;
            height: 100%;
            max-width: 253.19px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}

        }
    </style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user?action=delete">Delete ${requestScope["login_name"]}</a>
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
                        </ul>
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <img class="profilepic" src="https://msmobile.com.vn/upload_images/images/hinh-nen-powerpoint-tien-te-1.jpg">
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <h1>Profile of ${requestScope["login_name"]}</h1>
            <table>
                <tr>
                    <th>Id</th>
                    <th>${requestScope["user"].getId()}</th>
                </tr>
                <tr>
                    <th>Login_name</th>
                    <th>${requestScope["user"].getLogin_name()}</th>
                </tr>
                <tr>
                    <th>Email</th>
                    <th>${requestScope["user"].getEmail()}</th>
                </tr>
                <tr>
                    <th>gender</th>
                    <th><c:choose><c:when test="${requestScope['user'].isGender()}">male</c:when><c:otherwise>female</c:otherwise></c:choose></th>
                </tr>
                <tr>
                    <th>User Name</th>
                    <th>${requestScope["user"].getUser_name()}</th>
                </tr>
                <tr>
                    <th>Date of birth</th>
                    <th>${requestScope["user"].getUser_dob()}</th>
                </tr>
                <tr>
                    <th>Card_id</th>
                    <th>${requestScope["user"].getCard_id()}</th>
                </tr>
                <tr>
                    <th>Phone</th>
                    <th>${requestScope["user"].getPhone()}</th>
                </tr>
                <tr>
                    <th>Address</th>
                    <th>${requestScope["user"].getAddress()}</th>
                </tr>
            </table>
            <hr>
            <h3>Test</h3>
            <p>Lorem ipsum...</p>
        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#">Navbar</a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link active" aria-current="page" href="#">Home</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#">Link</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Wallets--%>
<%--                    </a>--%>
<%--                    <form method="post">--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <c:forEach items='${requestScope["wallets"]}' var="wallet">--%>
<%--                            <li><button class="dropdown-item" name="wallet_id" value="${wallet.getId()}">${wallet.getName()}: ${wallet.getBalance()}</button></li>--%>
<%--                        </c:forEach>--%>
<%--                    </ul>--%>
<%--                    </form>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <form class="d-flex">--%>
<%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>