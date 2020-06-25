<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品の表示（会員）</title>
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
	<div class="text-right">
	<a href="/tunnmals/MemberLoginServlet" class="btn btn-success">マイページに戻る</a>
	</div>
	<br>

	<c:forEach items="${myexhibit}" var="exhibit">
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
		<form action="/tunnmals/ExhibitDeleteServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="book_id" value="${exhibit.book_id}">
			<input type="submit" class="btn btn-danger" value="削除">
		</form>
		<form action="/tunnmals/ExhibitUpdateServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="book_id" value="${exhibit.book_id}">
			<input type="submit" class="btn btn-info" value="更新">

		</form>

		</div>
		</div>
	</div>

	</c:forEach>


	<c:forEach items="${allexhibit}" var="exhibit">
	<div>
		<div class="container">
		<div class="alert alert-info">
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>タイトル：${exhibit.book_name}</p>
		<p>ISBN番号：${exhibit.isbn}</p>
		<p>販売価格：${exhibit.price}</p>
		<p>著者：${exhibit.author}</p>
		<p>状態：${exhibit.quality}</p>
		<p>分類：${exhibit.category}</p>
		<form action="/tunnmals/PurchaseRegisterServlet" method="get">
		<input type="hidden" name="book_id" value="${exhibit.book_id}">
		<input type="submit" class="btn btn-success" value="購入">
		</form>

		</div>
		</div>
	</div>
	</c:forEach>


	</div>
</div>
</body>
</html>