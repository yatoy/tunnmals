<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品の削除（管理者）</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
		<div class="container">
			<div class="alert alert-dark">
				本当に削除しますか？
			</div>
		</div>
	<br>
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
	</div>
	</div>
	</div>
	<form action="/tunnmals/AdminDeleteExhibitServlet" method="post">
		<input type="hidden" name="action" value="complete">
		<input type="submit" class="btn btn-danger" value="削除">
	</form>

	<a href="/tunnmals/AdminExhibitDisplayServlet" class="btn btn-success">キャンセル</a>


	</div>
</div>
</body>
</html>