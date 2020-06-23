<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了</title>
</head>
<body>

<h1>会員登録完了</h1>

<h2>会員登録が完了しました</h2>

<h3>下のボタンを押すと<br>マイページに進みます</h3>

<form action="/tonnmals/MemberRegisterServlet" method="get">
<input type="submit" value="マイページ">
</form>

</body>
</html>