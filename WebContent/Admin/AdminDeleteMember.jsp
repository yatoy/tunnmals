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
		<p>名前</p>
		${member.family_name} ${member.first_name}]
		<p>住所</p>
		${member.address}
		<p>電話番号</p>
		${member.tel}
		<p>メールアドレス</p>
		${member.email}
		<p>生年月日</p>
		${member.birthday}
	</div>
	<form action="/tunnmals/AdminResignServlet" method="post">
		<input type="hidden" name="action" value="complete">
		<input type="submit" value="削除">
	</form>

	<a href="/tunnmals/MemberListServlet">キャンセル</a>



</body>
</html>