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
	<div class="container">
		<div class="alert alert-dark">
			以下の情報でよろしいですか？
		</div>
		<form action="/tonnmals/PurchaseRegisterServlet" method="post">

			商品情報<br>
			<div>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>ISBN番号</p>
			<p>5555555567</p>
			<p>タイトル</p>
			<p>******</p>
			<p>分類</p>
			<p>*****</p>
			<p>状態</p>
			<p>*****</p>
			<p>価格</p>
			<p>*******</p>
			</div>
			お届け先氏名（必須）：*** ***<br>
			お届け先ご住所（必須）：〒***-****
			**********************************<br>
			ご連絡先（必須）：***-****-****<br>
			メールアドレス：*************@************<br>
			支払方法（必須）：銀行振込<br>
			<input type="hidden" name="action" value="purchase">
			<input class="btn btn-success" type="submit" value="購入する">

		</form>

	</div>

</body>
</html>