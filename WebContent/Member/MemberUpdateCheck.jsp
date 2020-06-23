<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報確認</title>
</head>
<body>

<h1>会員情報変更の確認</h1>

<form action="/tonnmals/MemberServlet" method="get">
<div>氏名　tes</div>
<div>郵便番号　tes</div>
<div>住所　tes</div>
<div>電話番号　tes</div>
<div>Eメールアドレス　tes</div>
<div>生年月日　tes</div>
<div>パスワード　tes</div>
<input type="submit" value="前ページに戻る">
<input type="submit" value="会員情報の変更">
</form>

</body>
</html>