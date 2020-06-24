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
<div class="card text-center">
	<div class="card text-white bg-info mb-3">
<img class="card-img-bottom" src="3234900_s.jpg" alt="Card image cap">
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">みんなの教科書売買システム（仮）</h5>
	    <p class="card-text">学生同士でやり取りしよう！（仮）</p>
	    <a href="/tunnmals/MemberLoginServlet" class="btn btn-primary">ログインする</a>
	    <a href="/tunnmals/ExhibitDisplayServlet" class="btn btn-primary">出品一覧</a>

	  </div>
	</div>
</div>
	<div class="dropdown">
	  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    早速はじめる
	  </button>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenu">
		<a class="dropdown-item" href="/tunnmals/MemberLoginServlet">ログインする</a>
	  	<a class="dropdown-item" href="/tunnmals/ExhibitDisplayServlet">出品一覧</a>
	  </div>
	</div>


</div>
</body>
</html>