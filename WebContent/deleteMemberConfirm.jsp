<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認画面</title>
</head>
<body>

<form action="/tunnmals/MemberResignServlet" method="post">
	本当に退会しますか？
	<br>
	<input type="submit" value="退会する">

</form>
</body>
</html>