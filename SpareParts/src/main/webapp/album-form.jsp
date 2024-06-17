
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Computer Spare Part Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: pink">
			<div>
				<a href="#" class="navbar-brand"> Computer Spare Part Management</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Computer Spare Parts</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${album != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${album == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${album != null}">
            			Edit Parts
            		</c:if>
						<c:if test="${album == null}">
            			Add New Parts
            		</c:if>
					</h2>
				</caption>

				<c:if test="${album != null}">
					<input type="hidden" name="id" value="<c:out value='${album.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${album.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>PARTS</label> <input type="text"
						value="<c:out value='${album.parts}' />" class="form-control"
						name="parts">
				</fieldset>

				<fieldset class="form-group">
					<label>COUNTRY</label> <input type="text"
						value="<c:out value='${album.country}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
