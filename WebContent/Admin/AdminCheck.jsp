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
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>


	<div class="text-center">
	<h4>ログインしてください</h4>
	<form action="/tunnmals/AdminResignServlet" method="post">
	ユーザーID :
	<input type="text" name="id">
	<br>
	パスワード :
	<input type="text" name="password">
	<input type="hidden" name="action" value="check">
	<br>
	<input type="submit" value="ログイン">
</form>
</div>
</div>
</body>
</html>