<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<head>
<title>Iskustva</title>
<meta charset="ISO-8859-2">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/thumbs.css">
<link rel="stylesheet" href="css/slider.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.2.1.js"></script>
<script src="js/script.js"></script>
<script src="js/superfish.js"></script>
<script src="js/sForm.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.iosslider.min.js"></script>
<script>
	$(document).ready(function() {
		$().UItoTop({
			easingType : 'easeOutQuart'
		});
	});
</script>
</head>

<body class="" id="top">
	<!--==============================header=================================-->
	<header>
		<div class="container_12">
			<div class="grid_12">
				<h1>
					<a href="index.jsp"> <img src="images/logo.png" alt="logo">
					</a>
				</h1>
				<div class="menu_block ">
					<c:url value="/logout" var="logoutUrl" />
					<sec:authorize access="isAuthenticated()">
						<p align="right">
							Dobrodosli
							<sec:authentication property="principal.username" />
							!
							<sec:authorize access="hasRole('sekretar')">
								<a href="/pdsWEB/admin/panela?naziv=Admin">Admin panela</a>
							</sec:authorize>
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
							<li><a href="/pdsWEB/Planina/listaP">Planine</a></li>
							<li class="current"><a href="/pdsWEB/Izvestaj/listaI">Li&#269na
									Iskustva!</a></li>
							<li><a href="/pdsWEB/PlaninarskiDom/listaPD">Sme&#353taj</a></li>
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
		<div class="container_12">
			<h2>Izvestaji</h2>
			<div class="grid_7">
				<c:forEach items="${izvestaji}" var="i">
					<div class="block2">
						<h4>${i.naslov}</h4>
						<h5>${i.datumNastanka}&#9737${i.korisnik.username}</h5>
						<p style="text-align: justify;">${i.sadrzaj}</p>
					</div>
				</c:forEach>
				<h2>Opisi svoje iskustvo!</h2>
				<form id="izvestaj" action="/pdsWEB/Izvestaj/dodaj" method="POST">
					<input type="text" name="naslov" placeholder="Naslov"> <input
						type="submit" value="Post">
				</form>
				<textarea style="width: 100%; height: 350px;" name="sadrzaj"
					form="izvestaj">Opisite vase iskustvo ovde...</textarea>
			</div>
			<div class="grid_4 prefix_1">
				<h2>Slike</h2>
				<ul class="list2 col2">
					<c:forEach items="${slike}" var="s">
						<li><h5>${s.datumNastanka}&#9737${s.korisnik.username}</h5> <img
							src="${s.putanja}"></li>
					</c:forEach>
				</ul>
				<h2>Okaci sliku</h2>
				<ul class="list col2 l1">
					<sform:form action="/pdsWEB/Slika/dodaj"
						enctype="multipart/form-data" method="POST">
						<input type="file" name="slika">
						<input type="submit" value="Okaci">
					</sform:form>
			</div>
		</div>
	</div>
	<!--==============================footer=================================-->
	<footer>
		<div class="bottom_block">
			<div class="container_12">
				<div class="grid_4 ">
					<h3>Ostanite informisani</h3>
					<div class="text1">Dobijajte email-ove o ponudama, akcijama i
						dogadjajima</div>
					<form id="newsletter">
						<div class="rel">
							<div class="success">Poslato</div>
							<label class="email"> <input type="email"
								value="Unesite vas email"> <span class="error">Ovo
									nije validna email adresa.</span>
							</label>
						</div>
						<a href="#" class="btn" data-type="submit">Prijavi se</a>
					</form>
				</div>
				<div class="grid_5 prefix_3">
					<h3>Ostanite povezani</h3>
					<div class="text1">Pratite nas na Socijalnim mrezama!</div>
					<div class="socials">
						<a href="#">
							<div class="fa fa-twitter"></div>
						</a> <a href="#">
							<div class="fa fa-facebook"></div>
						</a> <a href="#">
							<div class="fa fa-pinterest-square"></div>
						</a> <a href="#">
							<div class="fa fa-google-plus"></div>
						</a> <a href="#">
							<div class="fa fa-instagram"></div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>