<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

String family_name = request.getParameter("family_name");
String first_name = request.getParameter("first_name");
String postal = request.getParameter("postal");
String address = request.getParameter("address");
String tel = request.getParameter("tel");
String email = request.getParameter("email");
String birthday = request.getParameter("birthday");
String password = request.getParameter("password1");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>

	<h4>新規会員登録</h4>

	</div>
		<div class="container">
		<div class="alert alert-dark">
		以下の情報でよろしいですか？
		</div>
	<form action="/tunnmals/MemberRegisterServlet" method="post">
	氏名
	<input type="text" name="family_name" readonly="readonly" value="<%=family_name%>">
	<input type="text" name="first_name" readonly="readonly" value="<%=first_name%>"><br>
	郵便番号<input type="text" name="postal" readonly="readonly" value="<%=postal%>"><br>
	住所<input type="text" name="address" size="60" readonly="readonly" value="<%=address%>"><br>
	電話番号<input type="tel" name="tel" readonly="readonly" value="<%=tel%>"><br>
	Eメールアドレス<input type="email" size="30" name="email" readonly="readonly" value="<%=email%>"><br>
	生年月日<input type="date" name="birthday" readonly="readonly" value="<%=birthday%>"><br>
	設定パスワード<input type="password" name="password" readonly="readonly" value="<%=password%>"><br>
	<div class="text-center">
	<br>
	<input type="hidden" name="action" value="complete">
	<a href="/tunnmals/MemberRegisterServlet?action=check" class="btn btn-default">前ページに戻る</a>
	<input type="submit"  class="btn btn-success" value="会員登録">
	</div>
	</form>
</div>
</div>
</body>
</html>