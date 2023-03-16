<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<style>
    #intro {
        background-image: url(https://rtworkspace.com/wp-content/uploads/2021/04/News_QTTC.jpg);
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
                    <a class="nav-link" href="https://www.facebook.com/nguyen.akira.372661" rel="nofollow" target="_blank">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://twitter.com/MDBootstrap" rel="nofollow" target="_blank">
                        <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li class="nav-item me-3 me-lg-0">
                    <a class="nav-link" href="https://github.com/phucgari/caseStudyModule3" rel="nofollow"
                       target="_blank">
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
                            <h2>
                                Edit Transaction
                            </h2>
                            <c:if test ="${transaction != null}">
                                <input type="hidden" name="id" value="<c:out value ='${transaction.id}'/>" />
                            </c:if>
                            <tr>
                                <th>time</th>
                                <td>
                                    <input type="datetime-local" name="time" id="meeting-time"  min="2018-06-07T00:00" max="2024-06-14T00:00" size="35"
                                           value = "<c:out value='${transaction.time}'/>">
                                </td>
                            </tr>
                            <tr>
                                <th>money_amount</th>
                                <td>
                                    <input type="text" name="money_Amount" size="35"
                                           value="<c:out value='${transaction.money_Amount}'/>">
                                </td>
                            </tr>
                            <tr>
                                <th>action</th>
                                <td>
                                    <input type="text" name="action" size="35"
                                           value="<c:out value='${transaction.action}'/>">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="5" align="center">
                                    <input type="submit" value="Save"/>
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