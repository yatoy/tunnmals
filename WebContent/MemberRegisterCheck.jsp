<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>

<h1>新規会員登録</h1>

<h2></h2>

<form action="/tonnmals/MemberRegisterServlet" method="post">
氏名
<input type="text" name="family_name" readonly="readonly" value="complete">
<input type="text" name="first_name" readonly="readonly" value="complete"><br>
郵便番号<input type="text" name="postal" readonly="readonly" value="0000000"><br>
住所<input type="text" name="address" readonly="readonly" value="complete"><br>
電話番号<input type="tel" name="tel" readonly="readonly" value="090-0000-0000"><br>
Eメールアドレス<input type="email" name="email" readonly="readonly" value="test@mail.jp"><br>
生年月日<input type="date" name="birthday" readonly="readonly" value="2020/01/01"><br>
設定パスワード<input type="password" name="password" readonly="readonly" value="complete"><br>
<input type="hidden" name="action" value="complete">
<input type="submit" value="前ページに戻る"> <input type="submit" value="会員登録">
</form>

</body>
</html>