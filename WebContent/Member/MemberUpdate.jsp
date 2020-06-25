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
			会員情報の変更
		</div>
		<div class="container">
			<div class="alert alert-dark">変更する情報を入力してください</div>

			<form action="/tunnmals/MemberUpdateServlet" method="post">
				<p>
					氏名：
					<input type="text" name="family_name" value="${member.family_name}">
					<input type="text" name="first_name" value="${member.first_name}">
				</p>
				<p>
					郵便番号：
					<input type="text" name="postal" value="${member.postal}">
				</p>
				<p>
					住所：
					<input type="text" name="address" value="${member.address}">
				</p>
				<p>
					電話番号：
					<input type="tel" name="tel" value="${member.tel}">
				</p>
				<p>
					Eメールアドレス：
					<input type="email" name="email" value="${member.email}">
				</p>
				<p>
					誕生日 :
					<input type="date" name="birthday" value="${member.birthday}">
				</p>
				<p>
					設定パスワード：
					<input type="password" name="password1">
				</p>
				<p>
					設定パスワード（再確認）：
					<input type="password" name="password2">
				</p>
				<p>
				現在のパスワード：
				${member.password}
				</p>

				<div class="text-center">
					<input type="hidden" name="register_date" value="${member.register_date}">
					<input type="hidden" name="action" value="check">
					<input type="submit" class="btn btn-success" value="登録情報の変更">
				</div>
			</form>
			<br>
		</div>
	</div>
</body>
</html>