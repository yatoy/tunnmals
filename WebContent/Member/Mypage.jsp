<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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
		<h3>${name}さん、こんにちは！</h3>
	</div>

<a href="/tunnmals/ExhibitDisplayServlet">出品の表示</a>

<br>
<a href="/tunnmals/ExhibitRegisterServlet">教科書の出品</a>

<br>
<a href="/tunnmals/Servlet">会員情報</a>

<br>
<a href="/tunnmals/Servlet">購入履歴</a>

<br>


</div>
</body>
</html>