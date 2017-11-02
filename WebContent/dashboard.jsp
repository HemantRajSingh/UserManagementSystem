<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
	<title>Dashboard - User Management System</title>
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
		}

		body{
			margin-top: 15px;
		}

		.topspace {
			margin-top:10px;
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
					<li class="nav-item"><a class="nav-link" href="./index.jsp">Logout</a></li>
					
				</ul>
			</div>
		</header>

		<section style="margin-top:20px;" id="main" class="jumbotron">

			<div class="row">
				<div class="col-sm-6">
					<h4>All Registered Users</h4>
				</div>
				<div class="col-sm-6 input-group">
				    	<input type="text" class="form-control offset-sm-6" placeholder="Search">
				      	<span class="input-group-btn">
				        	<button class="btn btn-secondary" type="button">Go!</button>
				      	</span>
				</div>
			</div>
			<hr>
			<div class="userslist">

				<table class="table">
					<thead>
					<tr>
						<th width="119"><b>ID</b></td>
						<th width="168"><b>Username</b></td>
						<th width="168"><b>Fullname</b></td>
						<th width="168"><b>Password</b></td>
						<th width="168"><b>Action</b></th>
					</tr>
					</thead>

					<div class="bodycontainer scrollable">
					<tbody>
					
					<% List data = (List)request.getAttribute("data"); %>

						<c:forEach items="${data}" var="user">
						
							
							<tr>

								<th width="119">${user.id}</th>
								
								<td width="168">${user.username}</td>
								
								<td width="168">${user.fullname}</td>
								
								<td width="168">${user.password}</td>
								
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
									
									
  										<button type="button" class="btn btn-secondary"><a style="color:black;" href="SelectUser?id=${user.id}">Edit</a></button>

  										<button type="button" class="btn btn-danger"><a style="color:black;" onclick="return confirm('Are you sure you want to delete this user?')" href="DeleteUser?id=${user.id}">Remove</a></button>

  										<!--   //<input type="text" name="id" value="${user.id}"> -->


  									</div>
								</td>

							</tr>
							</c:forEach>
					</tbody>
					</div>

				</table>

				

			</div> 



		</section>


	</div>

</body>
</html>