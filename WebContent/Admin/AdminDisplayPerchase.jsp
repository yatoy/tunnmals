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
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	</div>
	</div>
	<a href="/tunnmals/AdminLoginServlet">管理者用ページに戻る</a>
	<br>
	<c:forEach items="${exhibits}" var="exhibit">
	<div>
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>購入日</p>
		<p>${exhibit.buy_date}</p>
		<p>ISBN番号</p>
		<p>${exhibit.isbn}</p>
		<p>タイトル</p>
		<p>${exhibit.book_name}</p>
		<p>分類</p>
		<p>${exhibit.category}</p>
		<p>状態</p>
		<p>${exhibit.quality}</p>
		<p>買取値</p>
		<p>${exhibit.price}</p>
		<p>購入者ID</p>
		<p>${exhibit.buyer_id}</p>
		<p>出品者ID</p>
		<p>${exhibit.seller_id}</p>
	</div>
	</c:forEach>

</div>
</body>
</html>