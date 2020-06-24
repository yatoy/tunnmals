<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card text-center">
	<div class="card text-white bg-info mb-3">
<img class="card-img-bottom" src="3234900_s.jpg" alt="Card image cap">
	  <div class="card-header">
		<h1><p class="font-italic">Study Market</p></h1>
	  </div>
	</div>

	<h1>会員登録完了</h1>

	<h2>会員登録が完了しました</h2>
	<h2>あなたの会員番号は${id}です</h2>

	<h3>下のボタンを押すと<br>マイページに進みます</h3>

	<form action="/tunnmals/MemberLoginServlet" method="get">
	<input type="submit" value="ログインページ">
	</form>
</div>
</body>
</html>