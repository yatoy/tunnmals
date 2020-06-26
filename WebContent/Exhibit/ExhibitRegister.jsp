<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//27行目
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>出品情報入力画面</title>
</head>
<body>

<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	<%@ include file="/header.jsp"%>
	</div>
	</div>
	<%@ include file="/gotomypage.jsp"%>
	<br>
	<div class="container">
		<div class="alert alert-dark">
		以下の情報を入力してください。<br>
		</div>
		<form>
		  <div class="form-group">
		    <label for="exampleFormControlFile1">画像：</label>
		    <input type="file" class="form-control-file" id="exampleFormControlFile1">
		  </div>
		</form>
		<form action="/tunnmals/ExhibitRegisterServlet" method="post">
			タイトル（必須）：<input type="text" name="book_name"><br>
			ISBN番号（必須）：<input type="text" name="isbn"><br>
			販売価格（必須）：
			<input type="text" name="price"><br>
			著者：
			<input type="text" name="author"><br>
			状態（必須）：<select name="quality">
			<option value="null">選択してください</option>
			<option value="新品">新品</option>
			<option value="未使用">未使用</option>
			<option value="中古">中古</option>
			</select>
			<br>
			分類（必須）：<select name="class">
			<option value="null">選択してください</option>
			<option value="文学部系">文学部系 </option>
			<option value="教育学部系">教育学部系</option>
			<option value="法学部系">法学部系</option>
			<option value="社会学部系">社会学部系</option>
			<option value="経済学部系">経済学部系</option>
			<option value="理学部系">理学部系</option>
			<option value="医学部系">医学部系</option>
			<option value="歯学部系">歯学部系</option>
			<option value="薬学部系">薬学部系</option>
			<option value="工学部系">工学部系</option>
			<option value="農学部系">農学部系</option>
			</select>
			<br>

			<br>
			<div class="text-center">
			<input type="hidden" name="action" value="check">
			<input class="btn btn-success" type="submit" value="確認画面へ">
			</div>
			<br>
		</form>

	</div>
</div>
</body>
</html>