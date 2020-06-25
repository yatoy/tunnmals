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
	</div>
	<a href="/tunnmals/MemberLoginServlet">マイページに戻る</a>
	<br>

	<c:forEach items="${myexhibit}" var="exhibit">
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
		<form action="/tunnmals/ExhibitDeleteServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="book_id" value="${exhibit.book_id}">
			<input type="submit" value="削除">
		</form>
		<form action="/tunnmals/Servlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="hidden" name="book_id" value="${exhibit.book_id}">
			<input type="submit" value="更新">
		</form>
	</div>

	</c:forEach>


	<c:forEach items="${allexhibit}" var="exhibit">
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
	</div>
	</c:forEach>


</div>
</body>
</html>