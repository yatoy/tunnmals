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
	</div>
	<a href="/tunnmals/MemberLoginServlet">マイページに戻る</a>
	<br>
	あなたの購入履歴<br>
	<c:forEach items="${purchase_history}" var="exhibit">
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
		<p>価格</p>
		<p>${exhibit.price}</p>

	</div>
	</c:forEach>

</div>
</body>
</html>