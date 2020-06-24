<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:forEach items="${members}" var="member">
		<div>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>名前</p>
			<p>${member.family_name}${member. first_name}</p>
			<p>住所</p>
			<p>${member.address}</p>
			<p>電話番号</p>
			<p>${member.tel}</p>
			<p>メールアドレス</p>
			<p>${member.email}</p>
			<p>生年月日</p>
			<p>${member.birthday}</p>
			<form action="/tunnmals/AdminResignServlet" method="post">
				<input type="hidden" name="id" value="${member.id}">
				<input type="hidden" name="action" value="Admincheck">
				<input type="submit" value="削除">
			</form>
		</div>
	</c:forEach>
</div>


</body>
</html>