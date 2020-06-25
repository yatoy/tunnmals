<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報表示</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>

<h1>会員情報表示</h1>

<form action="/tonnmals/MemberServlet" method="get">
<div><label>氏名</label><p>${ family_name}${ first_name}</p></div>
<div><label>郵便番号</label><p>${ postal}</p></div>
<div><label>住所</label><p>${ address}</p></div>
<div><label>電話番号</label><p>${ tel}</p></div>
<div><label>Eメールアドレス</label><p>${ email}</p></div>
<div><label>生年月日</label><p>${ birthday}</p></div>
<br>

<a href="/tunnmals/MemberResignServlet" class="btn btn-danger">退会</a>
<a href="/tunnmals/MemberUpdateServlet" class="btn btn-info">会員情報の変更</a>

</form>
</form>

<br>

	</div>
</div>
</body>
</html>