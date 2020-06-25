<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Study Market toppage</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>

<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">

	<%@ include file="/header.jsp"%>
	<img class="card-img-bottom" src="3234900_s.jpg" alt="Card image cap">
	  <div class="card-body">
	    <h5 class="card-title">みんなの教科書売買システム</h5>
	    <p class="card-text">学生同士でやり取りしよう！</p>

	  </div>
	</div>
	    <a href="/tunnmals/MemberLoginServlet" class="btn btn-success">ログインする</a>
	    <a href="/tunnmals/ExhibitDisplayServlet" class="btn btn-info">出品一覧</a>

	</div>
<br>


</div>
</body>
</html>