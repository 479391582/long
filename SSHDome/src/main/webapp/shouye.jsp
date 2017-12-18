<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="org.apache.taglibs.standard.*"%>
<%@ page language="java" import="javax.servlet.jsp.jstl.*" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>家电商城</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700"
	rel="stylesheet">
</head>
<body>
		<!-- PRE LOADER -->

	<div class="preloader">
		<div class="sk-spinner sk-spinner-wordpress">
			<span class="sk-inner-circle"></span>
		</div>
	</div>

	<!-- Navigation section  -->

	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div></div>
		<div class="container">
			
			<!-- Navigation section  -->
			<div class="navbar navbar-default navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
											
						<button class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon icon-bar"></span> <span class="icon icon-bar"></span>
							<span class="icon icon-bar"></span>
						</button>
							欢迎：${sessionScope.user.cname}&nbsp;&nbsp;
							<a href="login_zhuxiao.action">注销登陆</a>
						<a href="index.html" class="navbar-brand"><i
							class="fa fa-magnet"></i></a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="login_deng.action">登陆</a></li>
							<li><a href="login_deng.action">注册</a></li>
							<li><a href="login_shouye.action">家电首页</a></li>
							<li><a href="login_bingxiang.action">冰箱</a></li>
							<li><a href="login_dianshi.action">电视</a></li>
							<li><a href="login_diannao.action">电脑</a></li>
							<li><a href="login_gouwuche.action">我的购物车</a></li>
							<br>
						</ul>
					</div>
				</div>
			</div>

			<!-- Home Section -->

			<section id="home">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<h2>我们 是一家简洁与性价比于一身的网店，在这里你会遇见你喜欢的呢个‘它’， 希望您购物愉快。</h2>
							<hr>
						</div>
					</div>
				</div>
			</section>
			<!-- Portfolio Section -->
			
			<section id="portfolio">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/2.jpg" class="img-responsive" alt="Portfolio"
									style="height: 50%">
								<div class="portfolio-overlay">
									<div class="portfolio-item">

										<h1>冰箱</h1>
										<a href="login_bingxiang.action">点击查看</a>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/6.jpg" class="img-responsive" alt="Portfolio">
								<div class="portfolio-overlay">
									<div class="portfolio-item">
										<h1>电视</h1>
										<a href="login_dianshi.action">点击查看</a>
									</div>
								</div>
							</div>
							</a>
						</div>

						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/8.jpg" class="img-responsive" alt="Portfolio">
								<div class="portfolio-overlay">
									<div class="portfolio-item">
										<h1>电脑</h1>
										<a href="login_diannao.action">点击查看</a>
									</div>
								</div>
							</div>
							</a>
						</div>

						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/12.jpg" class="img-responsive" alt="Portfolio">
								<div class="portfolio-overlay">
									<div class="portfolio-item">
										<h2>洗衣机</h2>
										<a href="">点击查看</a>
									</div>
								</div>
							</div>
							</a>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/10.jpg" class="img-responsive" alt="Portfolio">
								<div class="portfolio-overlay">
									<div class="portfolio-item">
										<h2>吸尘器</h2>
										<a href="">点击查看</a>
									</div>
								</div>
							</div>
							</a>
						</div>

						<div class="col-md-4 col-sm-6">
							<div class="portfolio-thumb">
								<img src="images/11.jpg" class="img-responsive" alt="Portfolio">
								<div class="portfolio-overlay">
									<div class="portfolio-item">
										<h1>空调</h1>
										<a href="">点击查看</a>
									</div>
								</div>
							</div>
							</a>
						</div>
						<div class="col-md-12 col-sm-12 text-center">
							<h3>
								Welcome, happy shopping! 
							</h3>
						</div>
					</div>
				</div>
			</section>
			<!-- Footer Section -->
			<footer>
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-3">
							<i class="fa fa-magnet"></i>
						</div>
						<div class="col-md-4 col-sm-4">
							<p>Best wishes to you in this special day! Wish you forever
								young and beautiful! Best regards and a happy birthday to you!</p>
						</div>
						<div class="col-md-offset-1 col-md-4 col-sm-offset-1 col-sm-3">
							<p>
								hello 亲爱的客户
							</p>
							<p>欢迎您的到来，我们将为你至高的服务</p>
						</div>


					</div>
				</div>
		</div>

		</footer>
</body>
<!-- SCRIPTS -->
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/custom.js"></script>
		<script type="text/javascript">
</script>
</html>