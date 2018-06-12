<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopin A Ecommerce Category Flat Bootstrap Responsive Website Template | Products :: w3layouts</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--theme-style-->
    <link href="css/style4.css" rel="stylesheet" type="text/css" media="all"/>
    <!--//theme-style-->
    <script src="js/jquery.min.js"></script>
    <!--- start-rate---->
    <script src="js/jstarbox.js"></script>
    <link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8"/>
    <script type="text/javascript">
        jQuery(function () {
            jQuery('.starbox').each(function () {
                var starbox = jQuery(this);
                starbox.starbox({
                    average: starbox.attr('data-start-value'),
                    changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                    ghosting: starbox.hasClass('ghosting'),
                    autoUpdateAverage: starbox.hasClass('autoupdate'),
                    buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                    stars: starbox.attr('data-star-count') || 5
                }).bind('starbox-value-changed', function (event, value) {
                    if (starbox.hasClass('random')) {
                        var val = Math.random();
                        starbox.next().text(' ' + val);
                        return val;
                    }
                })
            });
        });
    </script>
    <!---//End-rate---->
    <link href="css/form.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="index.html"><img src="images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <div class="header-top">
        <div class="container">
            <div class="col-sm-5 col-md-offset-2  header-login">
                <ul>
                    <%@ include file="/WEB-INF/jspf/header.jspf" %>
                </ul>
            </div>
            <div class="col-sm-2 header-social">
                <cp:localization />
            </div>
            <div class="col-sm-3 header-social">
                <ul>
                    <li><a href="#"><i></i></a></li>
                    <li><a href="#"><i class="ic1"></i></a></li>
                    <li><a href="#"><i class="ic2"></i></a></li>
                    <li><a href="#"><i class="ic3"></i></a></li>
                    <li><a href="#"><i class="ic4"></i></a></li>
                </ul>
            </div>            <div class="clearfix"></div>
        </div>
    </div>

    <div class="container">

        <div class="head-top">

            <div class="col-sm-8 col-md-offset-2 h_menu4">
                <nav class="navbar nav_bottom" role="navigation">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse"
                                data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a class="color" href="index.html">Home</a></li>

                            <li class="dropdown mega-dropdown active">
                                <a class="color1" href="#" class="dropdown-toggle" data-toggle="dropdown">Women<span
                                        class="caret"></span></a>
                                <div class="dropdown-menu ">
                                    <div class="menu-top">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu1</h4>
                                                <ul>
                                                    <li><a href="product.html">Accessories</a></li>
                                                    <li><a href="product.html">Bags</a></li>
                                                    <li><a href="product.html">Caps & Hats</a></li>
                                                    <li><a href="product.html">Hoodies & Sweatshirts</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu2</h4>
                                                <ul>
                                                    <li><a href="product.html">Jackets & Coats</a></li>
                                                    <li><a href="product.html">Jeans</a></li>
                                                    <li><a href="product.html">Jewellery</a></li>
                                                    <li><a href="product.html">Jumpers & Cardigans</a></li>
                                                    <li><a href="product.html">Leather Jackets</a></li>
                                                    <li><a href="product.html">Long Sleeve T-Shirts</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu3</h4>
                                                <ul>
                                                    <li><a href="product.html">Shirts</a></li>
                                                    <li><a href="product.html">Shoes, Boots & Trainers</a></li>
                                                    <li><a href="product.html">Sunglasses</a></li>
                                                    <li><a href="product.html">Sweatpants</a></li>
                                                    <li><a href="product.html">Swimwear</a></li>
                                                    <li><a href="product.html">Trousers & Chinos</a></li>

                                                </ul>

                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu4</h4>
                                                <ul>
                                                    <li><a href="product.html">T-Shirts</a></li>
                                                    <li><a href="product.html">Underwear & Socks</a></li>
                                                    <li><a href="product.html">Vests</a></li>
                                                    <li><a href="product.html">Jackets & Coats</a></li>
                                                    <li><a href="product.html">Jeans</a></li>
                                                    <li><a href="product.html">Jewellery</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1 col5">
                                            <img src="images/me.png" class="img-responsive" alt="">
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown mega-dropdown active">
                                <a class="color2" href="#" class="dropdown-toggle" data-toggle="dropdown">Men<span
                                        class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu">
                                    <div class="menu-top">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu1</h4>
                                                <ul>
                                                    <li><a href="product.html">Accessories</a></li>
                                                    <li><a href="product.html">Bags</a></li>
                                                    <li><a href="product.html">Caps & Hats</a></li>
                                                    <li><a href="product.html">Hoodies & Sweatshirts</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu2</h4>
                                                <ul>
                                                    <li><a href="product.html">Jackets & Coats</a></li>
                                                    <li><a href="product.html">Jeans</a></li>
                                                    <li><a href="product.html">Jewellery</a></li>
                                                    <li><a href="product.html">Jumpers & Cardigans</a></li>
                                                    <li><a href="product.html">Leather Jackets</a></li>
                                                    <li><a href="product.html">Long Sleeve T-Shirts</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu3</h4>

                                                <ul>
                                                    <li><a href="product.html">Shirts</a></li>
                                                    <li><a href="product.html">Shoes, Boots & Trainers</a></li>
                                                    <li><a href="product.html">Sunglasses</a></li>
                                                    <li><a href="product.html">Sweatpants</a></li>
                                                    <li><a href="product.html">Swimwear</a></li>
                                                    <li><a href="product.html">Trousers & Chinos</a></li>

                                                </ul>

                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu4</h4>
                                                <ul>
                                                    <li><a href="product.html">T-Shirts</a></li>
                                                    <li><a href="product.html">Underwear & Socks</a></li>
                                                    <li><a href="product.html">Vests</a></li>
                                                    <li><a href="product.html">Jackets & Coats</a></li>
                                                    <li><a href="product.html">Jeans</a></li>
                                                    <li><a href="product.html">Jewellery</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1 col5">
                                            <img src="images/me1.png" class="img-responsive" alt="">
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </li>
                            <li><a class="color3" href="product.html">Sale</a></li>
                            <li><a class="color4" href="404.html">About</a></li>
                            <li><a class="color5" href="typo.html">Short Codes</a></li>
                            <li><a class="color6" href="contact.html">Contact</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">
                <ul class="heart">
                    <li>
                        <a href="wishlist.html">
                            <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        </a></li>
                    <li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i
                            class="glyphicon glyphicon-search"> </i></a></li>
                </ul>
                <div class="cart box_1">
                    <a href="showCart">
                        <h3>
                            <div class="total">
                                <span class="simpleCart_total">
                                    ${sessionScope.cart.getTotal()}
                                </span></div>
                            <img src="images/cart.png" alt=""/></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

                </div>
                <div class="clearfix"></div>

                <!----->

                <!---pop-up-box---->
                <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
                <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
                <!---//pop-up-box---->
                <div id="small-dialog" class="mfp-hide">
                    <div class="search-top">
                        <div class="login-search">
                            <input type="submit" value="">
                            <input type="text" value="Search.." onfocus="this.value = '';"
                                   onblur="if (this.value == '') {this.value = 'Search..';}">
                        </div>
                        <p>Shopin</p>
                    </div>
                </div>
                <script>
                    $(document).ready(function () {
                        $('.popup-with-zoom-anim').magnificPopup({
                            type: 'inline',
                            fixedContentPos: false,
                            fixedBgPos: true,
                            overflowY: 'auto',
                            closeBtnInside: true,
                            preloader: false,
                            midClick: true,
                            removalDelay: 300,
                            mainClass: 'my-mfp-zoom-in'
                        });

                    });
                </script>
                <!----->
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--banner-->
<div class="banner-top">
    <div class="container">
        <h1>Products</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Products</h2>
    </div>
</div>
<!--content-->
<div class="product">
    <div class="container">
        <div class="col-md-9">
            <div class="mid-popular">
                <c:if test="${not empty pageBean.products}">
                    <cp:sortsAndLimits/>
                    <c:forEach var="product" items="${pageBean.getProducts()}">
                        <div class="col-md-4 item-grid1 simpleCart_shelfItem">
                            <div class=" mid-pop">
                                <div class="pro-img">
                                    <img src="${product.getImage()}" class="img-responsive" alt="">
                                    <div class="zoom-icon ">
                                        <a class="picture" href="images/pc.jpg" rel="title"
                                           class="b-link-stripe b-animate-go thickbox"><i
                                                class="glyphicon glyphicon-search icon "></i></a>
                                        <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                                    </div>
                                </div>
                                <div class="mid-1">
                                    <div class="women">
                                        <div class="women-top">
                                            <span>${pageBean.categories[product.categoryId-1].name}</span>
                                            <h6><a href="single.html">${product.getName()}</a></h6>
                                        </div>
                                        <div class="img item_add">
                                            <img productId="${product.id}" class="addToCart" alt="add to cart"
                                                 src="images/ca.png">
                                                <%-- <a href="#"><img src="images/ca.png" alt=""></a> --%>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="mid-2">
                                        <p><em class="item_price">${product.getPrice()}$</em></p>
                                        <div class="block">
                                            <div class="starbox small ghosting"></div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </c:if>
                <c:if test="${empty pageBean.products}">
                    <span id="empty">No such products</span>
                </c:if>
                <div class="clearfix"></div>
            </div>
        </div>
        <form action="product" method="get">
            <input type='hidden' name='limit' value='${filter.limit}'>
            <input type='hidden' name='sort' value='${filter.sort}'>
            <div class="col-md-3 product-bottom login-do">

                <section class="sky-form">
                    <h4 class="cate">Name</h4>
                    <br>
                    <div class="login-mail">
                        <input type="text" name="name" placeholder="Name" value="${filter.name}">
                    </div>
                </section>

                <section class=" sky-form">
                    <h4 class="cate">Categories</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <c:forEach items="${pageBean.categories}" var="category">
                                <c:set var="contains" value="false"/>
                                <c:forEach var="item" items="${filter.category}">
                                    <c:if test="${item eq category.id}">
                                        <c:set var="contains" value="true"/>
                                    </c:if>
                                </c:forEach>
                                <label class="checkbox"><input type="checkbox"
                                <c:if test="${contains}">
                                    <c:out value="checked='checked'"/>
                                </c:if>
                                                               name="category"
                                                               value="${category.id}"><i></i>${category.name}</label>
                            </c:forEach>
                        </div>
                    </div>
                </section>
                <!--initiate accordion-->
                <script type="text/javascript">
                    $(function () {
                        var menu_ul = $('.menu-drop > li > ul'),
                            menu_a = $('.menu-drop > li > a');
                        menu_ul.hide();
                        menu_a.click(function (e) {
                            e.preventDefault();
                            if (!$(this).hasClass('active')) {
                                menu_a.removeClass('active');
                                menu_ul.filter(':visible').slideUp('normal');
                                $(this).addClass('active').next().stop(true, true).slideDown('normal');
                            } else {
                                $(this).removeClass('active');
                                $(this).next().stop(true, true).slideUp('normal');
                            }
                        });

                    });
                </script>

                <section class="sky-form">
                    <h4 class="cate">Brand</h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                            <c:forEach items="${pageBean.brands}" var="brands">
                                <c:set var="contains" value="false"/>
                                <c:forEach var="item" items="${filter.brands}">
                                    <c:if test="${item eq brands.id}">
                                        <c:set var="contains" value="true"/>
                                    </c:if>
                                </c:forEach>
                                <label class="checkbox"><input type="checkbox"
                                <c:if test="${contains}">
                                    <c:out value="checked='checked'"/>
                                </c:if>
                                                               name="brands" value="${brands.id}"><i></i>${brands.name}
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </section>

                <section class="sky-form">
                    <h4 class="cate">Price</h4>
                    <br>
                    <div class="login-mail filter">
                        <input type="text" name="priceFrom" placeholder="From"
                               value="${(not empty filter.priceFrom ) ? filter.priceFrom:0}">
                    </div>

                    <div class="login-mail filter">
                        <input type="text" name="priceTo" placeholder="To" value="${filter.priceTo}">
                    </div>
                </section>
                <label class="hvr-skew-backward">
                    <input type="submit" value="Filter">
                </label>
            </div>
        </form>
        <div class="clearfix">
            <cp:pagination bottom="false"/>
        </div>
    </div>
    <!--products-->

    <!--//products-->
    <!--brand-->
    <div class="container">
        <div class="brand">
            <div class="col-md-3 brand-grid">
                <img src="images/ic.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="images/ic1.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="images/ic2.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="images/ic3.png" class="img-responsive" alt="">
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!--//brand-->


</div>
<!--//content-->
<!--//footer-->
<div class="footer">
    <div class="footer-middle">
        <div class="container">
            <div class="col-md-3 footer-middle-in">
                <a href="index.html"><img src="images/log.png" alt=""></a>
                <p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique
                    nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
            </div>

            <div class="col-md-3 footer-middle-in">
                <h6>Information</h6>
                <ul class=" in">
                    <li><a href="404.html">About</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="#">Returns</a></li>
                    <li><a href="contact.html">Site Map</a></li>
                </ul>
                <ul class="in in1">
                    <li><a href="#">Order History</a></li>
                    <li><a href="wishlist.html">Wish List</a></li>
                    <li><a href="login">Login</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Tags</h6>
                <ul class="tag-in">
                    <li><a href="#">Lorem</a></li>
                    <li><a href="#">Sed</a></li>
                    <li><a href="#">Ipsum</a></li>
                    <li><a href="#">Contrary</a></li>
                    <li><a href="#">Chunk</a></li>
                    <li><a href="#">Amet</a></li>
                    <li><a href="#">Omnis</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Newsletter</h6>
                <span>Sign up for News Letter</span>
                <form>
                    <input type="text" value="Enter your E-mail" onfocus="this.value='';"
                           onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <ul class="footer-bottom-top">
                <li><a href="#"><img src="images/f1.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="images/f2.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="images/f3.png" class="img-responsive" alt=""></a></li>
            </ul>
            <p class="footer-class">&copy; 2016 Shopin. All Rights Reserved | Design by <a href="http://w3layouts.com/"
                                                                                           target="_blank">W3layouts</a>
            </p>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//footer-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="js/simpleCart.min.js"></script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>
<!--light-box-files -->
<script src="js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
<!--light-box-files -->
<script type="text/javascript" charset="utf-8">
    $(function () {
        $('a.picture').Chocolat();
    });


    $(".addToCart").click(function () {
        var productId = $(this).attr("productId");
        $.ajax({
            url: 'cart',
            type: 'post',
            data: 'productId=' + productId + '&command=add',
            dataType: 'json',
            success: function (json) {
                $('.simpleCart_total').text(json['total']);
            }
        });
    });

</script>
</body>
</html>