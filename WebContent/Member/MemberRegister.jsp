<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
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

	<h2>新規会員登録</h2>

	</div>

	<%
	String type = request.getParameter("action");
	String message="登録する情報を入力してください";
	if ("check".equals(type)) {
		message="必須項目を入力してください";
	}
	%>

	<div class="container">
		<div class="alert alert-dark">
	<%= message%>
	</div>
	<form action="/tunnmals/MemberRegisterServlet" method="post">
	氏名：<input type="text" name="family_name" placeholder="氏"><input type="text" name="first_name" placeholder="名"><br>
	郵便番号：<input type="text" name="postal" placeholder="ハイフンなし、7桁"><br>
	住所：<input type="text" name="address" placeholder="都道府県市区町村マンション名号室"><br>
	電話番号：<input type="tel" name="tel" placeholder="***-****-****"><br>
	Eメールアドレス：<input type="email" name="email" placeholder="sample@sample.com"><br>
	生年月日：<input type="date" name="birthday" max="9999-12-31"><br>
	設定パスワード：<input type="password" name="password1"><br>
	設定パスワード（再確認）：<input type="password" name="password2" placeholder=""><br>
	<br>
	<input type="hidden" name="action" value="check">
	<input type="submit" value="登録情報の確認">
	</form>

	</div>

</div>
</body>
</html>