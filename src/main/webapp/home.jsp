<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	trang home shopee
	<%-- 	<% ArrayList<String> productList = (ArrayList) request.getAttribute("ProductList"); %>
	<% for (String product : productList) { %>
	<%= product %>
	<% } %> --%>

	<c:forEach items="${ProductList}" var="product">
	  ${product}
	</c:forEach>
</body>
</html>