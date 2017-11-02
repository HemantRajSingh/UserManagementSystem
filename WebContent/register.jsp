<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Register - User Management System</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/tether.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/tether.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>

	<style>
		.jumbotron {
		    padding: 2rem 2rem;
		    margin-top:20px;
		}

		body{
			margin-top: 15px;
		}

		.topspace {
			margin-top:10px;
		}
	</style>

</head>

<body class="container">

	<header class="row">
			<div class="col-md-6">
				<h3 class="text-muted">User Management System</h3>
			</div>

			<div class="col-md-6 ">
				<ul class="nav nav-pills float-right">
					<li class="nav-item"><a class="nav-link " href="">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="./index.jsp">Login</a></li>
					
				</ul>
			</div>
	</header>

	<section id="main" class="jumbotron">
		<div class="col-md-12 text-center">
			<h4>Register</h4>
		</div>

		<div class="row">
			<div style="margin-left: 33%;" class="col-md-push-4 col-md-4">
				<form action="CreateUser" method="post">
					<div class="form-group">
						<label>Username</label>
						<input required type="text" name="username" class="form-control">
					</div>

					<div class="form-group">
						<label>Full Name</label>
						<input required type="text" name="fullname" class="form-control">
					</div>

					<div class="form-group">
						<label>Password</label>
						<input required type="password" name="password" class="form-control">
					</div>

					<div class="form-group">
						<label> Retype Password</label>
						<input required type="password" name="repassword" class="form-control">
					</div>

					<div class="form-group text-center">
						<input class="btn btn-primary" type="submit" value="Sign up">
					</div>
				</form>
			</div>
		</div>
	</section>


</body>
</html>