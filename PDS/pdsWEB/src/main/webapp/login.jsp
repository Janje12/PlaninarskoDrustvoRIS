<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Uloguj se!</title>
<meta charset="iso-8859-2">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/touchTouch.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.2.1.js"></script>
<script src="js/script.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/touchTouch.jquery.js"></script>
<script>
	$(document).ready(function() {
		$().UItoTop({
			easingType : 'easeOutQuart'
		});
		$('.gallery a.gal').touchTouch();
	});
</script>
<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
			<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
		<![endif]-->
<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
</head>
<body class="" id="top">
	<!--==============================header=================================-->
	<header>
		<div class="container_12">
			<div class="grid_12">
				<h1>
					<a href="index.jsp"> <img src="images/logo.png"
						alt="Your Happy Family">
					</a>
				</h1>
				<div class="menu_block ">
					<sec:authorize access="isAuthenticated()">
						<p align="right">
							Dobrodosli <sec:authentication property="principal.username" />!
						</p>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<a href="/pdsWEB/login.jsp" class="donate">LOGIN</a>
					</sec:authorize>
					<c:url value="/logout" var="logoutUrl" />
					<sec:authorize access="isAuthenticated()">
						<form name="logoutForm" action="${logoutUrl}" method="GET">
							<a href="JAVASCRIPT:logoutForm.submit()" class="donate">LOGOUT</a>
						</form>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<a href="/pdsWEB/auth/register.jsp" class="donate">REGISTER</a>
					</sec:authorize>
					<div class="clear"></div>
					<nav class="horizontal-nav full-width horizontalNav-notprocessed">
						<ul class="sf-menu">
							<li><a href="index.jsp">Po&#269etna</a></li>
							<li><a href="index-1.jsp">Planine</a></li>
							<li><a href="index-2.jsp">Li&#269na Iskustva!</a></li>
							<li><a href="index-3.jsp">Sme&#353taj</a></li>
							<li><a href="index-4.jsp">Kontakt</a></li>
						</ul>
					</nav>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</header>
	<!--==============================Content=================================-->
	<div class="content">
		<c:url var="loginUrl" value="/login" />
		<div class="form">
			<form class="login-form" action="${loginUrl}" method="POST">
				<table>
					<tr>
						<td><input type="text" name="username"
							placeholder="Unesi Korisnicko ime" required></td>
					</tr>
					<tr>
						<td><input type="password" name="password"
							placeholder="Unesi Sifru" required></td>
					</tr>
					<tr>
						<td>Zapamti me:</td>
						<td><input type="checkbox" name="zapamti-me" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /></td>
						<td><input class="button" type="submit" value="Log in"></td>
					</tr>
				</table>
				<p class="message">
					Nemate nalog? <a href="/auth/register.jsp">Registrujte se</a>
				</p>
			</form>
		</div>
	</div>
	<div class="bottom_block">
		<div class="container_12">
			<div class="grid_4 ">
				<h3>Stay Informed</h3>
				<div class="text1">Subscribe to Our Newsletter</div>
				<form id="newsletter">
					<div class="rel">
						<div class="success">Your subscribe request has been sent!</div>
						<label class="email"> <input type="email"
							value="Enter your Email"> <span class="error">*This
								is not a valid email address.</span>
						</label>
					</div>
					<a href="#" class="btn" data-type="submit">Submit</a>
				</form>
			</div>
			<div class="grid_5 prefix_3">
				<h3>Stay Connected</h3>
				<div class="text1">Follow Us on Social Media Accounts</div>
				Cras facilisis, nulla vel viverra auctor, leo magna sodales felis,
				quis malesuada nibh odio ut velit. Proin pharetra
				<div class="socials">
					<a href="#"><div class="fa fa-twitter"></div></a> <a href="#"><div
							class="fa fa-facebook"></div></a> <a href="#"><div
							class="fa fa-pinterest-square"></div></a> <a href="#"><div
							class="fa fa-google-plus"></div></a> <a href="#"><div
							class="fa fa-instagram"></div></a>
				</div>
			</div>
		</div>
	</div>
	<!--==============================footer=================================-->
	<footer>
		<div class="container_12">
			<div class="grid_12">
				<div class="copy">
					Life &copy; 2014 | <a href="#">Privacy Policy</a> <br> Website
					designed by <a href="http://www.templatemonster.com/"
						rel="nofollow">TemplateMonster.com </a>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>