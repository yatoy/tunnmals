<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品削除Login（管理者）</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>


	<div class="text-center">
	<h4>再度ログインしてください</h4>
	<form action="/tunnmals/AdminResignServlet" method="post">
	<input type="text" name="id" placeholder="管理者ID"><br>
	<input type="password" name="password" placeholder="パスワード"><br>
	<input type="hidden" name="action" value="check">
	<input type="submit"  class="btn btn-dark" value="ログイン">
</form>
</div>
</div>
</body>
</html>