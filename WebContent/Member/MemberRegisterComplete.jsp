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
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>

	会員登録が完了しました
	<br><br>
	<div class="container">
		<div class="alert alert-dark">
		<h2>あなたの会員番号は${id}です</h2>
		❕　更新ボタンを押さないでください　❕
		</div>
	</div>

   <a href="/tunnmals/toppage.jsp" class="btn btn-default">トップページに戻る</a>
   <a href="/tunnmals/MemberLoginServlet" class="btn btn-success">ログインページへ</a>



	</div>
</div>
</body>
</html>