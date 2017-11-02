<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>User Management System</title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

	<style>
		body{
			margin-top: 15px;
		}
	</style>	

</head>
<body>
	<div class="container">

		<header class="row">
			<div class="col-md-6">
				<h3 class="text-muted">User Management System</h3>
			</div>

			<div class="col-md-6 ">
				<ul class="nav nav-pills float-right">
					<li class="nav-item"><a class="nav-link active" href="">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="./register.jsp">Register</a></li>
				</ul>
			</div>
		</header>

		<div class="jumbotron">
			<h1>Welcome to the User Management System</h1>
			<hr>
			<div class="row">
				<div class="col-sm-6">
					<p>What this system will do!
						<ul>
							<li>Signin or Register</li>
							<li>List all the registered Users and update them
						</ul>
					</p>

					<a class="btn btn-primary" href="register.jsp">Signup</a>
					<a class="btn btn-primary"  href="https://github.com/coolgeek7/usermanagementsystem">GitHub</a>
				</div>

				<div class="col-sm-6">

					<div class="text-center">
						<h4>Login</h4>
					</div>

					<div class="row">
							<form style="margin-left:33%;margin-top:10px;" action="LoginUser" method="post">
							<%request.getAttribute("data"); %>
							<c:out value="${data}"></c:out>
								<div class="form-group">
									<label>Username</slabel>
									<input required type="text" name="username" class="form-control">
								</div>

								<div class="form-group">
									<label>Password</label>
									<input required type="password" name="password" class="form-control">
								</div>

								<div class="form-group">
									<input class="text-center btn btn-primary" type="submit" value="Login">
								</div>
							</form>
					</div>
				</div>
			</div>
		</div>


		<hr>



	</div>

</body>
</html>