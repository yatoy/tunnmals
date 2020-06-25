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
	<%@ include file="/header.jsp"%>
		</div>
	<%@ include file="/logout.jsp"%>
<br>
	<div class="container">
		<div class="alert alert-dark">
		<h3>${name}さん、こんにちは！</h3>
	</div>
	</div>

<a href="/tunnmals/ExhibitDisplayServlet" class="btn btn-info">出品の表示</a>

<br>
<br>

<a href="/tunnmals/ExhibitRegisterServlet" class="btn btn-info">教科書の出品</a>

<br>
<br>
<a href="/tunnmals/PurchaseHistoryServlet" class="btn btn-info">購入履歴</a>

<br>
<br>
<a href="/tunnmals/MemberDisplayServlet" class="btn btn-success">会員情報</a>

<br>



</div>
</div>>
</body>
</html>