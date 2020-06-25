<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認画面</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>


	<h4>本当に退会しますか？</h4>

	<form action="/tunnmals/MemberResignServlet" method="post">
	<input type="hidden" name="action" value="complete">
	<input type="submit" class="btn btn-danger" value="退会する">

	</form>

	<br>
	<form action="/tunnmals/MemberLoginServlet" method="post">
	<input type="hidden" name="action" value="complete">
	<input type="submit" class="btn btn-success" value="退会しない">

	</form>

	</div>
</div>
</body>
</html>