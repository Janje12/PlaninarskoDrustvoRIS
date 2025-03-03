<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<head>
<title>Kontakt</title>
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
					<a href="index.jsp"> <img src="images/logo.png"
						alt="Your Happy Family">
					</a>
				</h1>
				<div class="menu_block">
					<sec:authorize access="isAuthenticated()">
						<p align="right">
							Dobrodosli
							<sec:authentication property="principal.username" />
							!
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
							<li><a href="/pdsWEB/Izvestaj/listaI">Li&#269na
									Iskustva!</a></li>
							<li><a href="/pdsWEB/PlaninarskiDom/listaPD">Sme&#353taj</a></li>
							<li class="current"><a href="index-4.jsp">Kontakt</a></li>
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
			<div class="grid_12">
				<h2>Nadji nas</h2>
				<div class="map">
					<figure class="">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d361048.6741113428!2d19.851273072034935!3d45.01086060086578!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475b10433eea2d49%3A0x1b7d6e01e07c4e32!2sPlaninarski%20savez%20Vojvodine!5e0!3m2!1ssr!2srs!4v1579717092307!5m2!1ssr!2srs"
							width="600" height="450" style="border: 0;"></iframe>
					</figure>
					<div class="grid_4 alpha">
						<h2>Adresa:</h2>
						<address>
							<span class="fa fa-home"></span> Masarikova 25, Novi Sad 21101 <br>
						</address>
					</div>
					<div class="grid_4">
						<h2>Telefoni:</h2>
						<div class="m_phone">
							<div class="fa fa-phone"></div>
							+381 021 125 456
						</div>
						<div class="m_phone">
							<div class="fa fa-print"></div>
							+381 060 558 789
						</div>
					</div>
					<div class="grid_4 omega">
						<h2>Email:</h2>
						<a href="#"><span class="fa fa-envelope-o"></span>
							pds@mail.org</a>
					</div>
					<div class="clear"></div>
				</div>
				<h2>Kontakt</h2>
				Ako imate problema popunite formu ispod i neko od nasih sekretara ce
				vam ubrzo odgovoriti!
				<form id="form">
					<div class="success_wrapper">
						<div class="success-message">Contact form submitted</div>
					</div>
					<label class="name"> <input type="text" placeholder="Ime:"
						data-constraints="@Required @JustLetters" /> <span
						class="empty-message">*Ovo polje je obavezno.</span> <span
						class="error-message">*Ovo nije validno ime.</span>
					</label> <label class="email"> <input type="text"
						placeholder="Email:" data-constraints="@Required @Email" /> <span
						class="empty-message">*Ovo polje je obavezno.</span> <span
						class="error-message">*Ovo nije validan email.</span>
					</label> <label class="subject"> <input type="text"
						placeholder="Naslov:" data-constraints="@Required @JustLetters" />
						<span class="empty-message">*Ovo polje je obavezno.</span> <span
						class="error-message">*Ovo nije validan telefon.</span>
					</label> <label class="message"> <textarea placeholder="Poruka:"
							data-constraints='@Required @Length(min=20,max=999999)'></textarea>
						<span class="empty-message">*Ovo polje je obavezno.</span> <span
						class="error-message">*Poruka je prekratka.</span>
					</label>
					<div>
						<div class="clear"></div>
						<div class="btns">
							<a href="#" data-type="reset" class="btn">Ocisti</a> <a href="#"
								data-type="submit" class="btn">Posalji</a>
						</div>
					</div>
				</form>
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