<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

String book_name = request.getParameter("book_name");
String isbn = request.getParameter("isbn");
String price = request.getParameter("price");
String author = request.getParameter("author");
String quality = request.getParameter("quality");
String cl = "";
String clno = request.getParameter("class");

if("0".equals("clno")){
	cl="文学部系";
}else if("1".equals("clno")){
	cl="教育学部系";
}else if("2".equals("clno")){
	cl="法学部系";
}else if("3".equals("clno")){
	cl="社会学部系";
}else if("4".equals("clno")){
	cl="経済学部系";
}else if("5".equals("clno")){
	cl="理学部系";
}else if("6".equals("clno")){
	cl="医学部系";
}else if("7".equals("clno")){
	cl="歯学部系";
}else if("8".equals("clno")){
	cl="薬学部系";
}else if("9".equals("clno")){
	cl="工学部系";
}else if("10".equals("clno")){
	cl="農学部系";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>出品削除画面</title>
</head>
<body>
<div class="card">
	<div class="text-center">
	<div class="card text-white bg-info mb-3">
	  <div class="card-header">
		<h1 class="font-italic">📚 Study Market</h1>
	  </div>
	</div>

	<div class="container">
		<div class="alert alert-dark">
			以下の商品を削除してよろしいですか？
		</div>
		<form action="/tunnmals/ExhibitDeleteServlet" method="post">

	<div class="container">
		<div class="alert alert-dark">

			<div>

			<p></p>
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p></p>
			<p>ISBN番号：<%= isbn%></p>
			<p>タイトル：<%= book_name%></p>
			<p>著者：<%= author%></p>
			<p>分類：<%= cl%></p>
			<p>状態：<%= quality%></p>
			<p>価格：<%= price%></p>
			</div>

		</div>
	</div>
			<input type="hidden" name="action" value="complete">
			<input class="btn btn-success" type="submit" value="削除する">

		</form>
		</div>


	</div>
</div>
</body>
</html>