<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<h1>Trang ADD PRODUCT</h1>
	<form action="admin-add-product" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Name</label> <input type="text"
				class="form-control" id="exampleInputEmail1" name="name"
				aria-describedby="emailHelp" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Price</label> <input name="price"
				type="number" class="form-control" id="exampleInputPassword1">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">image url</label> <input
				name="imageUrl" type="text" class="form-control"
				id="exampleInputPassword1">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Description</label> <input
				name="description" type="text" class="form-control"
				id="exampleInputPassword1">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>