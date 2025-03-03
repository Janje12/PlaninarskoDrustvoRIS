<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>${p.naziv}</title>
<meta charset="ISO-8859-2">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="../images/favicon.ico">
<link rel="shortcut icon" href="../images/favicon.ico" />
<link rel="stylesheet" href="../css/form.css">
<link rel="stylesheet" href="../css/thumbs.css">
<link rel="stylesheet" href="../css/slider.css">
<link rel="stylesheet" href="../css/style.css">
<script src="../js/jquery.js"></script>
<script src="../js/jquery-migrate-1.2.1.js"></script>
<script src="../js/script.js"></script>
<script src="../js/superfish.js"></script>
<script src="../js/sForm.js"></script>
<script src="../js/jquery.ui.totop.js"></script>
<script src="../js/jquery.equalheights.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script src="../js/jquery.iosslider.min.js"></script>
<script>
	$(document).ready(function(){
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
</head>
<body class="" id="top">
	<!--==============================header=================================-->
	<header>
		<div class="container_12">
			<div class="grid_12">
				<h1>
					<a href="../index.jsp"> <img src="../images/logo.png"
						alt="logo">
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
							<li class="current"><a href="../index.jsp">Po&#269etna</a></li>
							<li><a href="/pdsWEB/Planina/listaP">Planine</a></li>
							<li><a href="/pdsWEB/Izvestaj/listaI">Li&#269na
									Iskustva!</a></li>
							<li><a href="/pdsWEB/PlaninarskiDom/listaPD">Sme&#353taj</a></li>
							<li><a href="../index-4.jsp">Kontakt</a></li>
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
			<div class="grid_8">
				<h2>${p.naziv}</h2>
				<c:if test="${!empty p}">
					<img src="../images/${p.naziv}/1.png" alt="${p.naziv}"
						class="img_inner fleft">
					<p stlye="text-align: justify; ">${p.opis}</p>
					<br>
					<div class="grid_12">
						<h3>Planinarski domovi</h3>
						<c:forEach items="${pds}" var="pd">
							<div class="grid_3">
								<h4>${pd.naziv}</h4>
								<img src="../images/${pd.naziv}/1.png" alt="${pd.naziv}"
									class="img_inner fleft">
								<p stlye="text-align: justify; ">${pd.opis}</p>
								<br> <a
									href="/pdsWEB/Rezervacija/stranica?id=${pd.idPlaninarskiDom}&vrsta=planinarskidom"
									class="btn">Rezervisi</a>
							</div>
						</c:forEach>
					</div>
					<div class="clear cl1"></div>
					<div class="grid_12">
						<h3>Staze</h3>
						<c:forEach items="${stz}" var="s">
							<div class="grid_3">
								<h4>${s.naziv}</h4>
								<img src="../images/${s.naziv}/1.png" alt="${s.naziv}"
									class="img_inner fleft">
								<p stlye="text-align: justify; ">Duzina staze: ${s.duzina}</p>
								<br> <a
									href="/pdsWEB/Staza/znamenitosti?idStaza=${s.idStaza}"
									class="btn">Pogledaj znamenitosti duz staze</a>
							</div>
						</c:forEach>
					</div>
					<div class="clear cl1"></div>
				</c:if>
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