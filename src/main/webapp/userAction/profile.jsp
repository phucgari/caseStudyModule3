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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" integrity="sha256-h20CPZ0QyXlBuAw7A+KluUYx/3pK+c7lYEpqLTlxjYQ=" crossorigin="anonymous" />
<div class="container">
    <div class="team-single">
        <div class="row">
            <div class="col-lg-4 col-md-5 xs-margin-30px-bottom">
                <div class="team-single-img">
                    <img src="${requestScope["user"].getPicture_url()}" alt="">
                </div>
                <div class="bg-light-gray padding-30px-all md-padding-25px-all sm-padding-20px-all text-center">
                    <h4 class="margin-10px-bottom font-size24 md-font-size22 sm-font-size20 font-weight-600">Profile Picture</h4>
<%--                    <p class="sm-width-95 sm-margin-auto">We are proud of child student. We teaching great activities and best program for your kids.</p>--%>
                    <div class="margin-20px-top team-single-icons">
                        <ul class="no-margin">
                            <li><a href="javascript:void(0)"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="javascript:void(0)"><i class="fab fa-twitter"></i></a></li>
                            <li><a href="javascript:void(0)"><i class="fab fa-google-plus-g"></i></a></li>
                            <li><a href="javascript:void(0)"><i class="fab fa-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-lg-8 col-md-7">
                <div class="team-single-text padding-50px-left sm-no-padding-left">
                    <h4 class="font-size38 sm-font-size32 xs-font-size30">${requestScope["user"].getUser_name()}</h4>
<%--                    <p class="no-margin-bottom">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum voluptatem.</p>--%>
                    <div class="contact-info-section margin-40px-tb">
                        <ul class="list-style9 no-margin">
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fas fa-graduation-cap text-orange"></i>
                                        <strong class="margin-10px-left text-orange">Login_name:</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p>${requestScope["user"].getLogin_name()}</p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="far fa-gem text-yellow"></i>
                                        <strong class="margin-10px-left text-yellow">Gender</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p>
                                            <c:choose>
                                                <c:when test="${requestScope['user'].isGender()}">Male</c:when>
                                                <c:otherwise>Female</c:otherwise>
                                            </c:choose>
                                        </p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="far fa-file text-lightred"></i>
                                        <strong class="margin-10px-left text-lightred">Card_id:</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p>${requestScope["user"].getCard_id()}</p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fas fa-map-marker-alt text-green"></i>
                                        <strong class="margin-10px-left text-green">Address:</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p>${requestScope["user"].getAddress()}</p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fas fa-mobile-alt text-purple"></i>
                                        <strong class="margin-10px-left xs-margin-four-left text-purple">Phone:</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p>${requestScope["user"].getPhone()}</p>
                                    </div>
                                </div>

                            </li>
                            <li>
                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fas fa-envelope text-pink"></i>
                                        <strong class="margin-10px-left xs-margin-four-left text-pink">Email:</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p><a href="javascript:void(0)">${requestScope["user"].getEmail()}</a></p>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>

<%--                    <h5 class="font-size24 sm-font-size22 xs-font-size20">Professional Skills</h5>--%>

<%--                    <div class="sm-no-margin">--%>
<%--                        <div class="progress-text">--%>
<%--                            <div class="row">--%>
<%--                                <div class="col-7">Positive Behaviors</div>--%>
<%--                                <div class="col-5 text-right">40%</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="custom-progress progress">--%>
<%--                            <div role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:40%" class="animated custom-bar progress-bar slideInLeft bg-sky"></div>--%>
<%--                        </div>--%>
<%--                        <div class="progress-text">--%>
<%--                            <div class="row">--%>
<%--                                <div class="col-7">Teamworking Abilities</div>--%>
<%--                                <div class="col-5 text-right">50%</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="custom-progress progress">--%>
<%--                            <div role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:50%" class="animated custom-bar progress-bar slideInLeft bg-orange"></div>--%>
<%--                        </div>--%>
<%--                        <div class="progress-text">--%>
<%--                            <div class="row">--%>
<%--                                <div class="col-7">Time Management </div>--%>
<%--                                <div class="col-5 text-right">60%</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="custom-progress progress">--%>
<%--                            <div role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:60%" class="animated custom-bar progress-bar slideInLeft bg-green"></div>--%>
<%--                        </div>--%>
<%--                        <div class="progress-text">--%>
<%--                            <div class="row">--%>
<%--                                <div class="col-7">Excellent Communication</div>--%>
<%--                                <div class="col-5 text-right">80%</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="custom-progress progress">--%>
<%--                            <div role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:80%" class="animated custom-bar progress-bar slideInLeft bg-yellow"></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                </div>
            </div>

            <div class="col-md-12">

            </div>
        </div>
    </div>
</div>
<%--<div class="container-fluid text-center">--%>
<%--    <div class="row content">--%>
<%--        <div class="col-sm-2 sidenav">--%>
<%--            <img class="profilepic" src="https://msmobile.com.vn/upload_images/images/hinh-nen-powerpoint-tien-te-1.jpg">--%>
<%--            <p><a href="#">Link</a></p>--%>
<%--            <p><a href="#">Link</a></p>--%>
<%--        </div>--%>
<%--        <div class="col-sm-8 text-left">--%>
<%--            <h1>Profile of ${requestScope["login_name"]}</h1>--%>
<%--            <table>--%>
<%--                <tr>--%>
<%--                    <th>Id</th>--%>
<%--                    <th>${requestScope["user"].getId()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Login_name</th>--%>
<%--                    <th>${requestScope["user"].getLogin_name()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Email</th>--%>
<%--                    <th>${requestScope["user"].getEmail()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>gender</th>--%>
<%--                    <th><c:choose><c:when test="${requestScope['user'].isGender()}">male</c:when><c:otherwise>female</c:otherwise></c:choose></th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>User Name</th>--%>
<%--                    <th>${requestScope["user"].getUser_name()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Date of birth</th>--%>
<%--                    <th>${requestScope["user"].getUser_dob()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Card_id</th>--%>
<%--                    <th>${requestScope["user"].getCard_id()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Phone</th>--%>
<%--                    <th>${requestScope["user"].getPhone()}</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Address</th>--%>
<%--                    <th>${requestScope["user"].getAddress()}</th>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--            <hr>--%>
<%--            <h3>Test</h3>--%>
<%--            <p>Lorem ipsum...</p>--%>
<%--        </div>--%>
<%--        <div class="col-sm-2 sidenav">--%>
<%--            <div class="well">--%>
<%--                <p>ADS</p>--%>
<%--            </div>--%>
<%--            <div class="well">--%>
<%--                <p>ADS</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<footer class="container-fluid text-center">--%>
<%--    <p>Footer Text</p>--%>
<%--</footer>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
<script>
    function confirmDelete()  {
        if(confirm("Are you sure ?")) {
            window.location = "user?action=delete"
        }

    }
</script>
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