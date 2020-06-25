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

<title>購入情報入力画面</title>
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	お客様情報入力画面
	</div>

	<div class="container">
	<div class="text-center">
		<div class="alert alert-dark">
			お支払方法を選択してください
		</div>
	</div>

		<form action="/tunnmals/PurchaseRegisterServlet" method="post">

			お届け先情報<br>
			ご氏名：
<input type="text" name="family_name" readonly="readonly" value="${purchase_buyer.family_name}">
<input type="text" name="first_name" readonly="readonly" value="${purchase_buyer.first_name}"><br>
			ご住所：〒<input type="text" name="postal" readonly="readonly" value="${purchase_buyer.postal}"><br>
			<input type="text" name="address" readonly="readonly" value="${purchase_buyer.address}"><br>
			ご連絡先：
			<input type="tel" name="tel" size="60" readonly="readonly" value="${purchase_buyer.tel}"><br>
			メールアドレス：
			<input type="email" name="email" readonly="readonly" value="${purchase_buyer.email }"><br>
			<br>
			お支払方法：
			<input type="radio" name="payment_method" value="銀行振込" checked="checked">銀行振込<br>
			<input type="hidden" name="action" value="check">
			<input class="btn btn-success" type="submit" value="確認画面へ">

		</form>

	</div>

<br>
</div>
</body>
</html>