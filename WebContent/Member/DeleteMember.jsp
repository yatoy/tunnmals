<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会前Login</title>
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

<form action="/tunnmals/MemberResignServlet" method="post">
	<div class="text-center">
	<div class="container">
		<div class="alert alert-dark">
		パスワードを入力してください
		</div>
	</div>
	<input type="password" name="password" placeholder="パスワード"><br>
	<br>
	<input type="hidden" name="action" value="check">
	<input type="submit"  class="btn btn-danger" value="退会確認画面へ">
	</div>
</form>
<br>
</div>

</body>
</html>