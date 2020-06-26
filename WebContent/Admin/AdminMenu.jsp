<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-danger mb-3">
	<%@ include file="/header.jsp"%>
	</div>
<a href="/tunnmals/MemberListServlet"  class="btn btn-dark">全会員の表示</a>
<br><br>
<a href="/tunnmals/AdminExhibitDisplayServlet" class="btn btn-dark">出品の表示</a>
<br><br>
<a href="/tunnmals/AdminPurchaseDisplayServlet" class="btn btn-dark">購入履歴の表示</a>
<br><br>

	</div>
</div>
</body>
</html>