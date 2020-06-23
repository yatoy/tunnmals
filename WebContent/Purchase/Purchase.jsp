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
	<div class="container">
		<div class="alert alert-dark">
			<h1>お客様情報入力画面</h1>
		</div>
		<form action="/tunnmals/PurchaseRegisterServlet" method="post">

			お届け先氏名（必須）：<br>
			<input type="text" name="family_name">
			<input type="text" name="first_name"><br>
			お届け先ご住所（必須）：
			〒<input type="text" name="postal"><br>
			<input type="text" name="address"><br>
			ご連絡先（必須）：
			<input type="text" name="tel"><br>
			メールアドレス：
			<input type="text" name="email"><br>
			支払方法（必須）：
			<input type="radio" name="size" value="bank">銀行振込<br>
			<input type="hidden" name="action" value="check">
			<input class="btn btn-success" type="submit" value="確認画面へ">

		</form>

	</div>

</body>
</html>