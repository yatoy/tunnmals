<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>出品情報更新画面</title>
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	</div>
	</div>
	<div class="container">
		<div class="alert alert-dark">
		変更する内容を入力してください。<br>
		</div>
		<form action="/tunnmals/ExhibitUpdateServlet" method="post">
			画像：<img height="100" width="100" src="/tunnmals/noimage.png"><br>
			タイトル（必須）：<br><input type="text" name="book_name"><br>
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
			<option value="0">文学部系 </option>
			<option value="1">教育学部系</option>
			<option value="2">法学部系</option>
			<option value="3">社会学部系</option>
			<option value="4">経済学部系</option>
			<option value="5">理学部系</option>
			<option value="6">医学部系</option>
			<option value="7">歯学部系</option>
			<option value="8">薬学部系</option>
			<option value="9">工学部系</option>
			<option value="10">農学部系</option>
			</select>
			<br>
			<input type="hidden" name="action" value="check">
			<input class="btn btn-success" type="submit" value="確認画面へ">
		</form>

	</div>
</div>
</body>
</html>