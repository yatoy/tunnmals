<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
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
	</div>


	<div class="text-center">
	<h2>ログインしてください</h2>

	<form action="/tunnmals/MemberLoginServlet" method="post">
	<input type="text" name="id" placeholder="会員ID"><br>
	<input type="password" name="password" placeholder="パスワード"><br>
	<input type="hidden" name="action" value="login">
	<input type="submit" value="ログイン">
	</form>

	<br>
	初めての方はこちら
	<form action="/tunnmals/MemberRegisterServlet" method="get">
	<input type="submit" value="新規会員登録">
	</form>
	</div>
	<br>
</div>
</body>
</html>