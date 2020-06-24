<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	</div>
	</div>
	<a href="/tunnmals/AdminLoginServlet">管理者用ページに戻る</a>
	<br>
	<div>
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>名前</p>
		<p>住所</p>
		<p>電話番号</p>
		<p>メールアドレス</p>
		<p>生年月日</p>
		<form action="/tunnmals/AdminResignServlet" method="post">
			<input type="hidden" name="action" value="check">
			<input type="submit" value="削除">
		</form>
	</div>
</div>


</body>
</html>