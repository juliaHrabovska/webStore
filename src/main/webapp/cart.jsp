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
<!DOCTYPE html>
<html>
<head>
    <title>Shopin A Ecommerce Category Flat Bootstrap Responsive Website Template | Checkout :: w3layouts</title>
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
            </div>
            <div class="clearfix"></div>
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
                    <a href="cart">
                        <h3>
                            <div class="total">
                                <span class="simpleCart_total"></span></div>
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
        <h1>Cart</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Cart</h2>
    </div>
</div>
<!--login-->
<c:forEach var="product" items="${cart.getProducts()}">
<script>$(document).ready(function (c) {
    $('.close' + ${product.key.id}).on('click', function (c) {
        $('.cart-header').fadeOut('slow', function (c) {
            $('.cart-header').remove();
        });
    });
});
</c:forEach>
</script>
<div class="check-out">
    <div class="container">
        <c:if test="${not empty cart.getProducts()}">
            <div class="bs-example4" data-example-id="simple-responsive-table">
                <div class="table-responsive">
                    <table class="table-heading simpleCart_shelfItem">
                        <tr>
                            <th class="table-grid">Item</th>

                            <th>Price</th>
                            <th>Number</th>
                            <th>Total product price</th>
                        </tr>

                        <c:forEach var="product" items="${cart.getProducts()}">
                            <tr id="row-${product.key.id}'" class="cart-header">
                                <td class="ring-in"><a href="single.html" class="at-in"><img src="${product.key.image}"
                                                                                             class="img-responsive"
                                                                                             alt=""></a>
                                    <div class="sed">
                                        <h5><a href="single.html">${product.key.name}</a></h5>
                                        <p>(At vero eos et accusamus et iusto odio dignissimos ducimus ) </p>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="close${product.key.id}"
                                         onclick="removeProduct('${product.key.id }')"></div>
                                </td>
                                <td>${product.key.price}</td>
                                <td class='count-td'>
                                    <input onchange="manual('${product.key.id}')"
                                           name="quantity-${product.key.id }" size='3' class='cart-count'
                                           value="${product.value}">
                                </td>
                                <td id="total-${product.key.id }"><fmt:formatNumber
                                        value="${product.key.price * product.value}" currencySymbol=" "
                                        type="currency"/>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr class="cart-header">
                            <td>Total</td>
                            <td>
                                <span class="cart-total">
                                        ${cart.getTotal()}
                                </span>
                            </td>
                            <td>
                                <span class="cart-count">
                                        ${cart.getTotalCountOfProducts()}
                                </span>
                            </td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="produced">
                <a href="makeOrder" class="hvr-skew-backward">Produced To Buy</a>
            </div>
        </c:if>
        <c:if test="${empty cart.getProducts()}">
            <span id="empty">No such products</span>
        </c:if>
    </div>
</div>

<!--//login-->
<!--brands-->
<div class="container">
    <div class="brands">
        <div class="col-md-3 brands-grid">
            <img src="images/ic.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brands-grid">
            <img src="images/ic1.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brands-grid">
            <img src="images/ic2.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brands-grid">
            <img src="images/ic3.png" class="img-responsive" alt="">
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--//brands-->
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
                <filter>
                    <input type="text" value="Enter your E-mail" onfocus="this.value='';"
                           onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
                    <input type="submit" value="Subscribe">
                </filter>
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

<script type="text/javascript">
    function removeProduct(productId) {
        $
            .ajax({
                url: 'cart',
                type: 'post',
                data: 'command=remove&productId=' + productId,
                dataType: 'json',
                success: function (json) {
                    console.log(json);
                    if (json['count'] > 0) {
                        $('.cart-total').text(json['total'])
                        $('.cart-count').text(json['count']);
                        $('.simpleCart_total').text(json['total'])
                        $('#row-' + productId).detach();
                    } else {
                        $('.bs-example4').children().detach();
                        $(".bs-example4")
                            .html(
                                '<div class="table-responsive"><span id="empty">No such products</span></div>');
                    }
                }
            });
    }

    function manual(productId) {
        var quantity = parseInt($('input[name="quantity-' + productId + '"]')
            .val());
        if (quantity > 1) {
            updateCount(productId, quantity);
        } else {
            updateCount(productId, 1);
        }
    }

    function updateCount(productId, quantity) {
        $.ajax({
            url: 'cart',
            type: 'post',
            data: 'command=update&productId=' + productId + "&quantity="
            + quantity,
            dataType: 'json',
            success: function (json) {
                console.log(json);
                $('.cart-total').text(json['total'])
                $('.cart-count').text(json['count']);
                $('.simpleCart_total').text(json['total'])
                $('#total-' + productId).text(json['productTotal']);
                $('input[name="quantity-' + productId + '"]').val(
                    json['productQuantity']);
            }
        });
    }
</script>

</body>
</html>