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

<title>購入確認画面</title>
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
		<form action="/tunnmals/PurchaseRegisterServlet" method="post">
	<div class="container">
		<div class="alert alert-info">

			<div>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<br><br>
			<p>ISBN番号：${purchase_book.isbn}</p>
			<p>タイトル：${purchase_book.book_name}</p>
			<p>分類：${purchase_book.category}</p>
			<p>状態：${purchase_book.quality}</p>
			<p>価格：${purchase_book.price}</p>
			</div>
		</div>
	</div>
			お届け先<br>
			ご氏名：${purchase_buyer.family_name} ${purchase_buyer.first_name}<br>
			ご住所：〒${purchase_buyer.postal}<br>
			${purchase_buyer.address}<br>
			ご連絡先：${purchase_buyer.tel}<br>
			メールアドレス：${purchase_buyer.email }<br>
			お支払方法：${purchase.payment_method }<br>
			<br>
			<input type="hidden" name="action" value="complete">
			<input class="btn btn-success" type="submit" value="購入する">

		</form>

	</div>
	</div>
</div>
</body>
</html>