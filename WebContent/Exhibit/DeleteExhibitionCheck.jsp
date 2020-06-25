<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>出品削除画面</title>
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

		<div class="container">
			<div class="alert alert-dark">以下の商品を削除してよろしいですか？</div>

				<div>
					<h2>商品情報</h2>
					<img height="100" width="100" src="/tunnmals/noimage.png">
					<p>ISBN番号</p>
					<p>${exhibit.isbn}</p>
					<p>タイトル</p>
					<p>${exhibit.book_name}</p>
					<p>著者</p>
					<p>${exhibit.author}</p>
					<p>分類</p>
					<p>${exhibit.category}</p>
					<p>状態</p>
					<p>${exhibit.quality}</p>
					<p>価格</p>
					<p>${exhibit.price}</p>
				</div>

		</div>
				<form action="/tunnmals/ExhibitDeleteServlet" method="post">
					<input type="hidden" name="action" value="complete">
					<input class="btn btn-success" type="submit" value="削除する">
				</form>
		<a href="/tunnmals/ExhibitDisplayServlett">キャンセル</a>
	</div>
</body>
</html>