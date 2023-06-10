<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<form action="login" method="post">
		<c:if test="${error != null}">
			<h2 style="color: red" >${error}</h2>
		</c:if>
	
		<!-- Email input -->
		<div class="form-outline mb-4">
			<input type="text" id="form2Example1" class="form-control" name="username"/> <label
				class="form-label" for="form2Example1">Email address</label>
		</div>

		<!-- Password input -->
		<div class="form-outline mb-4">
			<input type="password" id="form2Example2" class="form-control" name="password"/> <label
				class="form-label" for="form2Example2">Password</label>
		</div>

		<button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
	</form>
</body>
</html>