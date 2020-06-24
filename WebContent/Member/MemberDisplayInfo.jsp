<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報表示</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card text-center">
	<div class="card text-white bg-info mb-3">
	  <div class="card-header">
		<h1>Study Market</h1>
	  </div>
	</div>
</div>

<h1>会員情報表示</h1>

<form action="/tonnmals/MemberServlet" method="get">
<div><label>氏名</label><p>tes</p></div>
<div><label>郵便番号</label><p>tes</p></div>
<div><label>住所</label><p>tes</p></div>
<div><label>電話番号</label><p>tes</p></div>
<div><label>Eメールアドレス</label><p>tes</p></div>
<div><label>生年月日</label><p>tes</p></div>
<div><label>パスワード</label><p>tes</p></div>
<input type="submit" value="会員情報の変更">
</form>

<form action="/tonnmals/MemberRegisterServlet" method="get">
<input type="submit" value="退会">
</form>

</body>
</html>