<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴の一覧</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	<a href="/tunnmals/AdminLoginServlet" class="btn btn-dark">管理者用ページに戻る</a>
	<%@ include file="/logoutAdmin.jsp"%>
	<br>
	<c:forEach items="${exhibits}" var="exhibit">
	<div>
		<div class="container">
		<div class="alert alert-dark">
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>購入日：${exhibit.buy_date}</p>
		<p>ISBN番号：${exhibit.isbn}</p>
		<p>タイトル：${exhibit.book_name}</p>
		<p>分類：${exhibit.category}</p>
		<p>状態：${exhibit.quality}</p>
		<p>買取値：${exhibit.price}</p>
		<p>購入者ID：${exhibit.buyer_id}</p>
		<p>出品者ID：${exhibit.seller_id}</p>
	</div>
	</div>
	</div>
	</c:forEach>

	</div>
</div>
</body>
</html>