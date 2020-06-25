<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>
	<a href="/tunnmals/AdminLoginServlet">管理者用ページに戻る</a>
	<br>
	<c:forEach items="${exhibits}" var="exhibit">
	<div>
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>タイトル</p>
		<p>${exhibit.book_name}</p>
		<p>ISBN番号</p>
		<p>${exhibit.isbn}</p>
		<p>販売価格</p>
		<p>${exhibit.price}</p>
		<p>著者</p>
		<p>${exhibit.author}</p>
		<p>状態</p>
		<p>${exhibit.quality}</p>
		<p>分類</p>
		<p>${exhibit.category}</p>
		<form action="/tunnmals/AdminDeleteExhibitServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="id" value="${exhibit.book_id}">
			<input type="submit" value="削除">
		</form>
	</div>
	</c:forEach>

</div>

</body>
</html>