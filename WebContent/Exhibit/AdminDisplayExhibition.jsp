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
	<a href="/tunnmals/AdminLoginServlet">管理者用ページに戻る</a>
	<br>
	<c:forEach items="${textbook}" var="employee">
		<div class="container">
			<div class="alert alert-dark">
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>タイトル：${textbook.book_name}</p>
			<p>ISBN番号：${textbook.isbn}</p>
			<p>販売価格：${textbook.price}</p>
			<p>著者：${textbook.author}</p>
			<p>状態：${textbook.quality}</p>
			<p>分類：${textbook.class}</p>
			<form action="/tunnmals/ExhibitDeleteServlet" method="post">
				<input type="hidden" name="action" value="check">
				<input type="submit" class="btn btn-danger" value="削除">
			</form>
			</div>
		</div>
	</c:forEach>

	</div>
</div>

</body>
</html>