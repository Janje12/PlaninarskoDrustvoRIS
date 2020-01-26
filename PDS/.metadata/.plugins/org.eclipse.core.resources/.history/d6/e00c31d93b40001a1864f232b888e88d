<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Smestaj</title>
		<meta charset="iso-8859-2">
		<meta name = "format-detection" content = "telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/form.css">
		<link rel="stylesheet" href="css/touchTouch.css">
		<link rel="stylesheet" href="css/style.css">
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
		$(document).ready(function(){
			$().UItoTop({ easingType: 'easeOutQuart' });
			$('.gallery a.gal').touchTouch();
			});
		</script>
	</head>
	<body class="" id="top">
<!--==============================header=================================-->
		<header>
			<div class="container_12">
				<div class="grid_12">
					<h1>
						<a href="index.jsp">
							<img src="images/logo.png" alt="Your Happy Family">
						</a>
					</h1>
					<div class="menu_block ">
						<sec:authorize access="isAuthenticated()">
					 	<p align="right">Dobrodosli <sec:authentication property="principal.username"/>!</p>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
						<a href="/pdsWEB/login.jsp" class="donate">LOGIN</a>
						</sec:authorize>
						<c:url value="/logout" var="logoutUrl"/>
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
								<li class="current"><a href="index-3.jsp">Sme&#353taj</a></li>
								<li><a href="index-4.jsp">Kontakt</a></li>	</ul>
						</nav>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</header>
<!--==============================Content=================================-->
		<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - March 24, 2014!</div>
			<div class="container_12">
				<div class="gallery">
					<div class="grid_3">
						<h2>Aliquam nibh antd dictum</h2>
						<a href="images/big1.jpg" class="gal"><img src="images/page4_img1.jpg" alt=""></a>
						Broin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis masser
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Praesent faucibus malesu</h2>
						<a href="images/big2.jpg" class="gal"><img src="images/page4_img2.jpg" alt=""></a>
						Kroin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis mass
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Hraesenibus malesua</h2>
						<a href="images/big3.jpg" class="gal"><img src="images/page4_img3.jpg" alt=""></a>
						Groin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis massylo
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Tam nibh antd dictumer</h2>
						<a href="images/big4.jpg" class="gal"><img src="images/page4_img4.jpg" alt=""></a>
						Xasroin pharetra luctudiamesque eros convallikoaecenas vehicula egestas venenatisss
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="clear"></div>
					<div class="grid_3">
						<h2>Stibuluantd dictumertol</h2>
						<a href="images/big5.jpg" class="gal"><img src="images/page4_img5.jpg" alt=""></a>
						Kroin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis mass
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Vestibulum volutpat turpi</h2>
						<a href="images/big6.jpg" class="gal"><img src="images/page4_img6.jpg" alt=""></a>
						Froin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis massolo
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Ferquam nibh antd dictuo</h2>
						<a href="images/big7.jpg" class="gal"><img src="images/page4_img7.jpg" alt=""></a>
						Rein pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatisis massde
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Deram nibh antd dictumo</h2>
						<a href="images/big8.jpg" class="gal"><img src="images/page4_img8.jpg" alt=""></a>
						Jroin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis masolo
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="clear"></div>
					<div class="grid_3">
						<h2>Gertolobh antd dictumew</h2>
						<a href="images/big9.jpg" class="gal"><img src="images/page4_img9.jpg" alt=""></a>
						Geroin pharetra luctusdiamesque erosallikoaecenas vehicul egestas venenatis. Duis masswertloi
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
					<div class="grid_3">
						<h2>Aliquam nibh antd dictum</h2>
						<a href="images/big10.jpg" class="gal"><img src="images/page4_img10.jpg" alt=""></a>
						Kroin pharetra luctus diamesque eros convallikoaecenas vehicula egestas venenatis. Duis mass
						<br>
						<a href="#" class="btn">Learn More</a>
					</div>
				</div>
			</div>
		</div>
	<div class="bottom_block">
		<div class="container_12">
			<div class="grid_4 ">
				<h3>Ostanite informisani</h3>
				<div class="text1">Dobijajte email-ove o ponudama, akcijama i dogadjajima</div>
				<form id="newsletter">
					<div class="rel">
						<div class="success">Poslato</div>
						<label class="email"> <input type="email"
							value="Unesite vas email"> <span class="error">Ovo nije validna email adresa.</span>
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
					<div class="fa fa-twitter"></div></a> <a href="#">
					<div class="fa fa-facebook"></div></a> <a href="#">
					<div class="fa fa-pinterest-square"></div></a> <a href="#">
					<div class="fa fa-google-plus"></div></a> <a href="#">
					<div class="fa fa-instagram"></div></a>
				</div>
			</div>
		</div>
	</div>
	<!--==============================footer=================================-->
	<footer>

	</footer>
	</body>
</html>