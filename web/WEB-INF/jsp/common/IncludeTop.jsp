<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/4
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen"/>
    <link type="text/css" href="css/swiper.min.css" rel="stylesheet" />
    <link type="text/css" href="css/f-nav.css" rel="stylesheet" />


    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/swiper.min.js"></script>
    <script type="text/javascript" src="js/snow.js"></script>
    <script type="text/javascript" src="js/index-style.js"></script>

</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent" class="main-color">
            <a href="main"><img src="images/logo-topbar.gif"/></a>
        </div>
    </div>

    <div id="Menu" class="text-color">
        <div id="MenuContent" class="main-color text-color">
            <a href="viewCart">
                <img align="middle" name="img_cart" src="images/cart.gif"/>
            </a>
            <img align="middle" src="images/separator.gif"/>
            <c:if test="${sessionScope.account == null}">
                <a href="SignonForm">Sign On</a>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <a href="Signout">Sign Out</a>
                <img align="middle" src="images/separator.gif"/>
                <a href="editAccountForm">My Account</a>
            </c:if>
            <img align="middle" src="images/separator.gif"/>
            <a href="help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent" class="main-color text-color">
            <form action="search" method="post">
                <input type="text" id="keyword" name="keyword" size="14" autocomplete="off" disableautocomplete/>
                <ul  id="completion" class="completion"></ul>
                <input type="submit" name="searchProducts" value="Search"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks" class="text-color">
        <a href="viewCategory?categoryId=FISH">
            <img src ="images/sm_fish.gif"/>
        </a>
        <img src="images/separator.gif"/>
        <a href="viewCategory?categoryId=DOGS">
            <img src="images/sm_dogs.gif"/>
        </a>
        <img src="images/separator.gif"/>
        <a href="viewCategory?categoryId=REPTILES">
            <img src="images/sm_reptiles.gif"/>
        </a>
        <img src="images/separator.gif"/>
        <a href="viewCategory?categoryId=CATS">
            <img src="images/sm_cats.gif"/>
        </a>
        <img src="images/separator.gif"/>
        <a href="viewCategory?categoryId=BIRDS">
            <img src="images/sm_birds.gif"/>
        </a>
    </div>

</div>

<div id="Content">
