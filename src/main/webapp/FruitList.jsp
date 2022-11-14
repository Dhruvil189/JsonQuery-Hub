<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Fruits Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"></a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		

		<div class="container">
			<h3 class="text-center">List of Fruits</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Fruits</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Genus</th>
						<th>Name</th>
						<th>Fruit_Id</th>
						<th>Family</th>
						<th>Order</th>
						<th>Nutritions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="fruits" items="${listFruits}">

						<tr>
							<td><c:out value="${fruits.genus}" /></td>
							<td><c:out value="${fruits.name}" /></td>
							<td><c:out value="${fruits.fruit_id}" /></td>
							<td><c:out value="${fruits.family}" /></td>
							<td><c:out value="${fruits.order_name}" /></td>
							<td>
								<ul>
									<li>carbohydrates:"${fruits.carbohydrates}"</li>
									<li>protein:"${fruits.protein}"</li>
									<li>fat:"${fruits.fat}"</li>
									<li>calories:"${fruits.calories}"</li>
									<li>sugar:"${fruits.sugar}"</li>
								</ul>
							</td>
							<td><a href="edit?fruit_id=<c:out value='${fruits.fruit_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?fruit_id=<c:out value='${fruits.fruit_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>