<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>

<h1>Study Market</h1>
<form action="/tunnmals/AdminLoginServlet" method="post">
	ユーザーID :
	<input type="text" name="id">
	<br>
	パスワード :
	<input type="text" name="password">
	<br>
	<input type="submit" value="ログイン">

</form>
</body>
</html>