<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<style>
    #intro {
        background-image: url(https://mdbootstrap.com/img/new/fluid/city/008.jpg);
        height: 100vh;
    }

    /* Height for devices larger than 576px */
    @media (min-width: 992px) {
        #intro {
            margin-top: -58.59px;
        }
    }

    .navbar .nav-link {
        color: #fff !important;
    }
</style>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark d-none d-lg-block" style="z-index: 2000;">
    <div class="container-fluid">
        <!-- Navbar brand -->
        <a class="navbar-brand nav-link" href="http://localhost:8080/">
            <strong>Home</strong>
        </a>
        <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarExample01"
                aria-controls="navbarExample01" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarExample01">
            <ul class="navbar-nav d-flex flex-row">
                <!-- Icons -->
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://www.youtube.com/channel/UC5CF7mLQZhvx8O5GODZAhdA" rel="nofollow"
                       target="_blank">
                        <i class="fab fa-youtube"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://www.facebook.com/mdbootstrap" rel="nofollow" target="_blank">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://twitter.com/MDBootstrap" rel="nofollow" target="_blank">
                        <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://github.com/phucgari/caseStudyModule3" rel="nofollow" target="_blank">
                        <i class="fab fa-github"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Navbar -->

<!-- Background image -->
<div id="intro" class="bg-image shadow-2-strong">
    <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0, 0, 0, 0.8);">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-md-8">
                    <form class="bg-white  rounded-3 shadow-3-strong p-3" method="post">
                        <table style="background: white" cellpadding="3">
                            <tr>
                                <td colspan="2" align="center">
                                    <h2>Register</h2>
                                </td>
                            </tr>
                            <tr>
                                <th>User Name:</th>
                                <td>
                                    <input type="text" name="login_name" id="login_name" size="35"/>*
                                </td>
                            </tr>
                            <tr>
                                <th>Password:</th>
                                <td>
                                    <input type="text" name="login_password" id="login_password" size="35"/>*
                                </td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td>
                                    <input type="text" name="email" id="email" size="35"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Picture:</th>
                                <td>
                                    <input type="text" name="picture_url" id="picture_url" size="35"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Gender:</th>
                                <td>
                                    <select name="gender" id="gender"/>*
                                    <option value="true">Male</option>
                                    <option value="false">Female</option>
                                    </select>
                                </td>
                                </td>
                            </tr>
                            <tr>
                                <th>Name:</th>
                                <td>
                                    <input type="text" name="user_name" id="user_name" size="35"/>*
                                </td>
                            </tr>
                            <tr>
                                <th>user_dob:</th>
                                <td>
                                    <input type="text" name="user_dob" id="user_dob" size="35"/>*
                                </td>
                            </tr>
                            <tr>
                                <th>Card id:</th>
                                <td>
                                    <input type="text" name="card_id" id="card_id" size="35"/>
                                </td>
                            </tr>
                            <tr>
                                <th >Phone:</th>
                                <td>
                                    <input type="text" name="phone" id="phone" size="35"/>*
                                </td>
                            </tr>
                            <tr>
                                <th>Address:</th>
                                <td>
                                    <input type="text" name="address" id="address" size="35"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="2">
                                    <input class="btn btn-primary btn-block"  type="submit" value="Sign in"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="2">
                                    <a href="http://localhost:8080/user?action=login">Back to LogIn</a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
