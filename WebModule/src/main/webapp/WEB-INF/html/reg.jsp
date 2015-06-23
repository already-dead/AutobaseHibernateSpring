<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  
  <title>Регистрация</title>

    <meta charset="utf-8">

  <meta name="format-detection" content="telephone=no">

  <link rel="icon" href="${pageContext.servletContext.contextPath}/images/favicon.ico">

  <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/images/favicon.ico">


 <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/booking/css/booking.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/camera.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/owl.carousel.css">

<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/style.css">

  <script src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/jquery-migrate-1.2.1.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/script.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/superfish.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/jquery.ui.totop.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/jquery.equalheights.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/jquery.mobilemenu.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/owl.carousel.js"></script>
  <script src="${pageContext.servletContext.contextPath}/js/camera.js"></script><!--[if (gt IE 9)|!(IE)]><!-->
  <script src="${pageContext.servletContext.contextPath}/js/jquery.mobile.customized.min.js"></script><!--<![endif]-->
  <script src="${pageContext.servletContext.contextPath}/booking/js/booking.js"></script>
		
  
  <script>
			$(document).ready(function(){
				jQuery('#camera_wrap').camera({
					loader: false,
					pagination: false ,
					minHeight: '444',
					thumbnails: false,
					height: '28.28125%',
					caption: true,
					navigation: true,
					fx: 'mosaic'
				});
				$().UItoTop({ easingType: 'easeOutQuart' });
			});
		</script><!--[if lt IE 8]>
			<div style=' clear: both; text-align:center; position: relative;'>
				<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
					<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
				</a>
			</div>
			<![endif]--><!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
</head>


<body class="page1" id="top">


		
<div class="main">
<!--==============================header=================================-->
			<header>
				</header>
<div class="menu_block">
					
<div class="container_12">
						
<div class="grid_12">
							<nav class="horizontal-nav full-width horizontalNav-notprocessed">
								</nav>
<ul class="sf-menu">


									<li class="current"><a href="index.html">Главная</a></li>


									<li><a href="index-1.html">О нас</a></li>


									<li><a href="index-2.html">Автомобили</a></li>


									<li><a href="index-3.html">Услуги</a></li>


									<li><a href="index-4.html">Контакты</a></li>


								
</ul>


							
							
<div class="clear"></div>


						</div>


						
<div class="clear"></div>


					</div>


				</div>


				
<div class="container_12">
					
<div class="grid_12">
						
<h1>
							<a href="index.html">
								<br>


							</a>
						</h1>


					</div>


				</div>
<br>
<div class="slider_wrapper">
				
<div class="grid_4">
					
<div data-src="images/slide.jpg"></div>


					
<div data-src="images/slide1.jpg"></div>


					
<div data-src="images/slide2.jpg"></div>

<br>

</div>

</div>


			
<div class="container_12">
				
				
				
<div class="grid_4"><br>

</div>


				
			</div>

<br>


			
<div class="content">


				
<div class="container_12">
<div class="grid_5">
  
  
<h3>Регистрация</h3>



<form action="/AutoBase/login/" method="post" id="bookingForm"><br>


  <input name="mode" value="reg" type="hidden">

  <strong>Тип доступа</strong>

  
  <div class="fl1">
  
  <select name="role" class="tmSelect2 auto" data-constraints=""><!--data-class="tmSelect auto"-->
  <option>ROLE_DRIVER</option>
  <option>ROLE_DISPATCHER</option>
  </select>
	
  </div>
					
  
  
  <div class="clear"></div>

  
  <div class="clear"></div>

  
  <strong>Имя</strong>
  
  <div class="tmInput"> <input name="name" placeholder="Иван" data-constraints="@NotEmpty @Required" required> </div>

  
  
  <div class="clear"></div>

  
  <strong>Фамилия</strong>
  
  <div class="tmInput"> <input name="surname" placeholder="Иванов" data-constraints="@NotEmpty @Required" required> </div>

  
  
  <div class="clear"></div>

  
  <strong>Логин</strong>
  
  <div class="tmInput"> <input name="login" type="email" placeholder="sample@gmail.com" data-constraints="@NotEmpty @Required" required> </div>


  
  <div class="clear"></div>


  <strong>Пароль</strong>
  
  <div class="tmInput"> <input name="password1" placeholder="********" data-constraints="@NotEmpty @Required" type="password" required> </div>

   
  <div class="clear"></div>

   <strong>  </strong>
  
  <div class="tmInput"> <input name="password2" placeholder="********" data-constraints="@NotEmpty @Required" type="password" required> </div>

  
  

  
  <div class="clear"></div>

  
  <div class="clear"></div>


  <button type="submit" class="btn" style="width: 258px;">Отправить</button>
  &nbsp;&nbsp;
  <button type="reset" class="btn" style="width: 160px;">Сброс</button>
</form>

<br>

<form action="/AutoBase/menu/driver/?id=0" method="post"> 
  <button type="submit" class="btn" style="width: 440px;">Отмена</button>
</form>


	  </div>

<br>

<div class="clear"></div>


				</div>


			</div>


		</div>


<!--==============================footer=================================-->
		<footer>
			</footer>
<div class="container_12">
				
<div class="grid_12">
					
<div class="f_phone"><span>Позвоните нам:</span> + 1800 559 6580</div>


					
<div class="socials">
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>


					
<div class="copy">
						
<div class="st1">
						
<div class="brand">Tour<span class="color1">T</span>axi </div>


						&copy; 2014	| <a href="#">Privacy Policy</a> </div>

 Шаблон сайта от <a href="http://www.templatemonster.com/ru/" rel="nofollow">TemplateMonster.ru</a>
					</div>


				</div>


				
<div class="clear"></div>


			</div>


		
		
<script>
			$(function (){
				$('#bookingForm').bookingForm({
					ownerEmail: '#'
				});
			})
			$(function() {
				$('#bookingForm input, #bookingForm textarea').placeholder();
			});
		</script>
	
</body>
</html>
