<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品の表示（管理者）</title>
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
	<br>
		<br>
	<c:forEach items="${exhibits}" var="exhibit">
	<div>
	<div class="container">
		<div class="alert alert-dark">
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>タイトル：${exhibit.book_name}</p>
		<p>ISBN番号：${exhibit.isbn}</p>
		<p>販売価格：${exhibit.price}</p>
		<p>著者：${exhibit.author}</p>
		<p>状態：${exhibit.quality}</p>
		<p>分類：${exhibit.category}</p>
		<p>出品者ID：${exhibit.seller_id}</p>
		<p>出品日：${exhibit.sell_date}</p>
		</div>
		</div>
		<form action="/tunnmals/AdminDeleteExhibitServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="id" value="${exhibit.book_id}">
			<input type="submit"  class="btn btn-danger" value="削除">
		</form>
	</div>
	</c:forEach>
</div>
</div>

</body>
</html>