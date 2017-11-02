<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<title>Edit User - User Management System</title>
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
					<li class="nav-item"><a class="nav-link" href="./index.jsp">Logout</a></li>
					
				</ul>
			</div>
	</header>

	<section id="main" class="jumbotron">
		<div class="col-md-12 text-center">
			<h4>Edit User</h4>
		</div>

		<div class="row">
			<div style="margin-left: 33%;" class="col-md-push-4 col-md-4">
				<form action="UpdateUser" method="post">
							

					<div class="form-group">
						<label>UserID</label>
						<input required readonly="true" type="text" name="id" value="<%=request.getAttribute("id")%>" class="form-control">
					</div>

					<div class="form-group">
						<label>Username</label>
						<input required type="text" name="username" value="<%=request.getAttribute("username")%>" class="form-control">
					</div>

					<div class="form-group">
						<label>Full Name</label>
						<input required type="text" name="fullname" value="<%=request.getAttribute("fullname")%>" class="form-control">
					</div>

					<div class="form-group">
						<label>Password</label>
						<input required type="password" name="password" value="<%=request.getAttribute("password")%>" class="form-control">
					</div>

					<div class="form-group text-center">
						<input class="btn btn-primary" type="submit" value="Update">
					</div>
					
				</form>
			</div>
		</div>
	</section>


</body>
</html>