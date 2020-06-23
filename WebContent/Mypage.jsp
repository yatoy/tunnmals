<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>

<h1>マイページ</h1>

<h3>名前　ID</h3>

<form action="/tonnmals/Servlet" method="get">
<input type="submit" value="出品の表示">
</form><br>

<form action="/tonnmals/Servlet" method="get">
<input type="submit" value="教科書の出品">
</form><br>

<form action="/tonnmals/Servlet" method="get">
<input type="submit" value="会員情報">
</form>

<form action="/tonnmals/Servlet" method="get">
<input type="submit" value="購入履歴">
</form>

</body>
</html>