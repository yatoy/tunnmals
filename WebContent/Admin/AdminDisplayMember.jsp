<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	<a href="/tunnmals/AdminLoginServlet" class="btn btn-dark">管理者用ページに戻る</a>
	<%@ include file="/logoutAdmin.jsp"%>
	<c:forEach items="${members}" var="member">
		<div>
			<div class="container">
			<div class="alert alert-dark">
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>会員ID：${member.id}</p>
			<p>名前：${member.family_name}${member. first_name}</p>
			<p>住所：〒${member.postal}　${member.address}</p>
			<p>電話番号：${member.tel}</p>
			<p>メールアドレス：${member.email}</p>
			<p>生年月日：${member.birthday}</p>
			</div>
		</div>
			<form action="/tunnmals/AdminResignServlet" method="post">
				<input type="hidden" name="id" value="${member.id}">
				<input type="hidden" name="action" value="Admincheck">
				<input type="submit" class="btn btn-danger" value="削除">
			</form>
		</div>
		<br><br>
	</c:forEach>
</div>
</div>


</body>
</html>