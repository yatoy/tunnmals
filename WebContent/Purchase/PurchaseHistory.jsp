<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴</title>
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
	<a href="/tunnmals/MemberLoginServlet">マイページに戻る</a>
	<br>
	あなたの購入履歴<br>
	<c:forEach items="${purchase_history}" var="exhibit">
	<div class="container">
		<div class="alert alert-info">
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<br>
		<br>

		<p>購入日：${exhibit.buy_date}</p>
		<p>タイトル：${exhibit.book_name}</p>
		<p>ISBN番号：${exhibit.isbn}</p>
		<p>分類：${exhibit.category}</p>
		<p>状態：${exhibit.quality}</p>
		<p>価格：${exhibit.price}</p>
		</div>
	</div>
	</c:forEach>
	</div>
</div>
</body>
</html>