<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

String id = request.getParameter("id");
String family_name = request.getParameter("family_name");
String first_name = request.getParameter("first_name");
String postal = request.getParameter("postal");
String address = request.getParameter("address");
String tel = request.getParameter("tel");
String email = request.getParameter("email");
String birthday = request.getParameter("birthday");
String password = request.getParameter("password");

%>
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
	会員情報の変更
	</div>
		<div class="container">
		<div class="alert alert-dark">
		変更する情報を入力してください
	</div>

<form action="/tunnmals/MemberUpdateServlet" method="post">
氏名：<input type="text" name="<%= family_name%>"><input type="text" name="<%= first_name%>"><br>
郵便番号：<input type="text" name="<%= postal%>"><br>
住所：<input type="text" name="<%= address%>"><br>
電話番号：<input type="tel" name="<%= tel%>"><br>
Eメールアドレス：<input type="email" name="<%= email%>"><br>
設定パスワード：<input type="password" name="password1"><br>
設定パスワード（再確認）：<input type="password" name="password2"><br>
<br>
	現在のパスワード：<input type="password" name="password"><br>

	<input type="hidden" name="id" value="<%= id%>">
	<input type="hidden" name="birthday" value="<%= birthday%>">

	<div class="text-center">
	<input type="hidden" name="action" value="check">
	<input type="submit"  class="btn btn-success" value="登録情報の変更">
	</div>
</form>
<br>
</div>
</div>
</body>
</html>