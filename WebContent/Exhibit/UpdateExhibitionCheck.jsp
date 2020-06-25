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

<title>出品更新確認画面</title>
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>
	<div class="container">
		<div class="alert alert-dark">
			以下の情報でよろしいですか？
		</div>
		<form action="/tunnmals/ExhibitUpdateServlet" method="post">

			商品情報<br>
			<div>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>ISBN番号</p>
			<p>5555555567</p>
			<p>タイトル</p>
			<p>******</p>
			<p>著者</p>
			<p>*****</p>
			<p>分類</p>
			<p>*****</p>
			<p>状態</p>
			<p>*****</p>
			<p>価格</p>
			<p>*******</p>
			</div>
			<input type="hidden" name="action" value="complete">
			<input class="btn btn-success" type="submit" value="更新する">

		</form>

	</div>
</div>
</body>
</html>