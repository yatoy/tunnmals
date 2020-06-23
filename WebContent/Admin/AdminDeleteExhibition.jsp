<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>

	<h1>Study Market</h1>
	<h2>本当に削除しますか？</h2>
	<br>
	<div>
		<img height="100" width="100" src="/tunnmals/noimage.png">
		<p>タイトル</p>
		<p>ISBN番号</p>
		<p>販売価格</p>
		<p>著者</p>
		<p>状態</p>
		<p>分類</p>
	</div>
	<form action="/tunnmals/ExhibitDeleteServlet" method="post">
		<input type="hidden" name="action" value="complete">
		<input type="submit" value="削除">
	</form>

	<a href="/tunnmals/ExhibitDisplayServlet">キャンセル</a>



</body>
</html>