<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/03/2023
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<!--Main Navigation-->
<header>
    <style>
        #intro {
            background-image: url("https://vieclamvui.com/upload/img/700/2020/10/27/nganh_tai_chinh_ngan_hang_vieclamvui_2_1603766664856.jpg");
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

    <!-- Background image -->
    <div id="intro" class="bg-image shadow-2-strong">
        <div class="mask" style="background-color: rgba(0, 0, 0, 0.8);">
            <div class="container d-flex align-items-center justify-content-center text-center h-100">
                <div class="text-white">
                    <h1 class="mb-3">FINANCIAL MANAGERMENT</h1>
                    <h5 class="mb-4">produced by group 1</h5>
                    <a class="btn btn-outline-light btn-lg m-2" href="user?action=login">LOGIN</a>
                    <a class="btn btn-outline-light btn-lg m-2" href="user?action=create">REGISTER</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Background image -->
</header>
<!--Main Navigation-->

<!--Main layout-->
<main class="mt-5">
    <div class="container">
        <!--Section: Content-->
        <section>
            <div class="row">
                <div class="col-md-6 gx-5 mb-4">
                    <div class="bg-image hover-overlay ripple shadow-2-strong rounded-5" data-mdb-ripple-color="light">
                        <img src="https://www.wealthandfinance-news.com/wp-content/uploads/2021/07/Finance-technology.jpg" class="img-fluid" />
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                        </a>
                    </div>
                </div>

                <div class="col-md-6 gx-5 mb-4">
                    <h4><strong><a href="https://www.wealthandfinance-news.com/the-history-of-finance-and-what-the-digital-future-holds/">Where Currency First Began</a></strong></h4>
                    <p class="text-muted">
                        The term of currency is broad, but its roots can be tracked down to the caveman,
                        who could have given someone something they held valuable, such as a shiny rock,
                        for some meat that another had hunted.
                    </p>
                    <p><strong>How Assets Were Important</strong></p>
                    <p class="text-muted">
                        Physical assets have been important to the financial world for a number of years.
                        When thinking of assets, you can think of gold bars, which are often held by banks
                        and governments in vaults to accrue interest and hold something of value to strengthen
                        their financial capital. Most people will hold some sort of asset, whether that be something
                        trivial such as vintage memorabilia, or something more concrete, such as property.
                    </p>
                </div>
            </div>
        </section>

        <!--Section: Content-->
        <section class="text-center">
            <h4 class="mb-5"><strong>Related information</strong></h4>

            <div class="row">
                <div class="col-lg-4 col-md-12 mb-4">
                    <div class="card">
                        <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                            <img src="https://kinhtechungkhoan.vn/stores/news_dataimages/2023/022023/22/14/croped/co-phieu-ngan-hang20230222143949.jpg?230222033505" class="img-fluid" style="height: 250px" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                            </a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Bank</h5>
                            <p class="card-text">
                                A bank is a financial institution that accepts deposits from the public and creates a
                                demand deposit while simultaneously making loans.
                            </p>
                            <a href="https://en.wikipedia.org/wiki/Bank" class="btn btn-primary">see more</a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card">
                        <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                            <img src="https://bcp.cdnchinhphu.vn/334894974524682240/2023/3/13/san-chung-khoan-la-gi-16786796205201405665574.jpeg" class="img-fluid" style="height: 250px" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                            </a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Stock</h5>
                            <p class="card-text">
                                In finance, stock (also capital stock) consists of all the shares by which ownership
                                of a corporation or company is divided.
                            </p>
                            <a href="https://en.wikipedia.org/wiki/Stock" class="btn btn-primary">see more</a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card">
                        <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                            <img src="https://media.vneconomy.vn/w800/images/upload/2021/10/07/chung-khoan.jpeg" class="img-fluid" style="height: 250px" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                            </a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Macroeconomics</h5>
                            <p class="card-text">
                                Macroeconomics is a branch of economics that deals with the performance, structure,
                                behavior, and decision-making of an economy as a whole.
                            </p>
                            <a href="https://en.wikipedia.org/wiki/Macroeconomics" class="btn btn-primary">see more</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <hr class="my-5" />

    </div>
</main>
<!--Main layout-->

<!--Footer-->
<footer class="bg-light text-lg-start">
    <hr class="m-0" />

    <div class="text-center py-4 align-items-center">
        <p>Follow Hoàng on social media</p>
        <a href="https://www.youtube.com/channel/UC5CF7mLQZhvx8O5GODZAhdA" class="btn btn-primary m-1" role="button"
           rel="nofollow" target="_blank">
            <i class="fab fa-youtube"></i>
        </a>
        <a href="https://www.facebook.com/mdbootstrap" class="btn btn-primary m-1" role="button" rel="nofollow"
           target="_blank">
            <i class="fab fa-facebook-f"></i>
        </a>
        <a href="https://twitter.com/MDBootstrap" class="btn btn-primary m-1" role="button" rel="nofollow"
           target="_blank">
            <i class="fab fa-twitter"></i>
        </a>
        <a href="https://github.com/mdbootstrap/mdb-ui-kit" class="btn btn-primary m-1" role="button" rel="nofollow"
           target="_blank">
            <i class="fab fa-github"></i>
        </a>
    </div>

</footer>

</body>
</html>
