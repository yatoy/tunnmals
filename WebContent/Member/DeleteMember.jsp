<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会前Login</title>
</head>
<body>

<form action="/tunnmals/MemberResignServlet" method="post">
	ユーザーID :
	<input type="text" name="id">
	<br>
	パスワード :
	<input type="text" name="password">
	<br>
	<input type="hidden" name="action" value="check">
	<input type="submit" value="退会確認画面へ">

</form>
</body>
</html>