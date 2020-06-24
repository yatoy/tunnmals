<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String id = request.getParameter("id");
String family_name = request.getParameter("family_name");
String first_name = request.getParameter("first_name");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	</div>
	</div>
<h1>マイページ</h1>
	</div>

	<div class="container">
		<div class="alert alert-dark">
		<h3><%= family_name%>さん、こんにちは！</h3>
	</div>
<form action="/tunnmals/Servlet" method="get">
<input type="submit" value="出品の表示">
</form><br>

<form action="/tunnmals/Servlet" method="get">
<input type="submit" value="教科書の出品">
</form><br>

<form action="/tunnmals/Servlet" method="get">
<input type="submit" value="会員情報">
</form>

<form action="/tunnmals/Servlet" method="get">
<input type="submit" value="購入履歴">
</form>
<br>
</div>
</body>
</html>