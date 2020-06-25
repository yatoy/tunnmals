<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>出品確認画面</title>
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	<div class="container">
		<div class="alert alert-dark">
			以下の情報でよろしいですか？
		</div>
		<div>
			<div class="container">
			<div class="alert alert-dark">
			<h2>商品情報</h2>
			<div>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>ISBN番号：${exhibit.isbn}</p>
			<p>タイトル：${exhibit.book_name}</p>
			<p>著者：${exhibit.author}</p>
			<p>分類：${exhibit.category}</p>
			<p>状態：${exhibit.quality}</p>
			<p>価格：${exhibit.price}</p>
			</div>
			</div>
			</div>
			<form action="/tunnmals/ExhibitRegisterServlet" method="post">
				<input type="hidden" name="action" value="complete">
				<input class="btn btn-success" type="submit" value="出品する">

			</form>
		</div>
	</div>

	</div>
</div>
</body>
</html>