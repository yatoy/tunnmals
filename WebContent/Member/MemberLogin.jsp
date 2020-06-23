<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<h1>ログイン画面</h1>

<form action="/tonnmals/MemberLoginServlet" method="post">
<input type="text" name="id" placeholder="会員ID"><br>
<input type="password" name="password" placeholder="パスワード"><br>
<input type="submit" value="ログイン">
</form>

<br>

<form action="/tonnmals/MemberRegisterServlet" method="get">
<input type="submit" value="新規会員登録">
</form>

</body>
</html>