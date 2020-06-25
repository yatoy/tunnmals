<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>
<form action="/tunnmals/AdminLoginServlet" method="post">
	ユーザーID :
	<input type="text" name="id">
	<br>
	パスワード :
	<input type="text" name="password">
	<input type="hidden" name="action" value="login">
	<br>
	<input type="submit" value="ログイン">

</form>
</div>
</body>
</html>