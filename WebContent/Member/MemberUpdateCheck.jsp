<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
	<div class="card">
		<div class="text-center">
			<div class="card text-white bg-info mb-3">
				<%@ include file="/header.jsp"%>
			</div>

			<h4>会員情報変更</h4>

		</div>
		<div class="container">
			<div class="alert alert-dark">以下の情報でよろしいですか？</div>
				<p>
					氏名 : ${member.family_name} ${member.first_name}
				</p>

				<p>
					郵便番号 : ${member.postal}
				</p>

				<p>
					住所 : ${member.address}
				</p>

				<p>
					電話番号 : ${member.tel}
				</p>

				<p>
					Eメールアドレス : ${member.email}
				</p>
				<p>
					生年月日 : ${member.birthday}
				</p>


				<div class="text-center">
					<form action="/tunnmals/MemberUpdateServlet" method="post">
						<input type="hidden" name="action" value="complete">
						<input type="submit" class="btn btn-success" value="更新">
					</form>
					<a href="/tunnmals/MemberUpdateServlet" class="btn btn-default">前ページに戻る</a>
				</div>


		</div>
	</div>
</body>
</html>