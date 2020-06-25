<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品の表示（会員）</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

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
	<a href="/tunnmals/MemberLoginServlet">マイページに戻る</a>
	<br>
	<div>
	あなたの出品した商品
	<c:forEach items="${textbook}" var="employee">
		<div class="container">
			<div class="alert alert-dark">
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>タイトル：${textbook.book_name}</p>
			<p>ISBN番号：${textbook.isbn}</p>
			<p>販売価格：${textbook.price}</p>
			<p>著者：${textbook.author}</p>
			<p>状態：${textbook.quality}</p>
			<p>分類：${textbook.class}</p>
	    <a href="/tunnmals/ExhibitUpdateServlet" class="btn btn-success">更新</a>
	    <a href="/tunnmals/ExhibitDeleteServlet?action=check" class="btn btn-danger">削除</a>
			</div>
		</div>
	</c:forEach>
	</div>
	<br><br>
	出品されている商品
	<c:forEach items="${textbook}" var="employee">
		<div class="container">
			<div class="alert alert-dark">
			<img height="100" width="100" src="/tunnmals/noimage.png">
			<p>タイトル：${textbook.book_name}</p>
			<p>ISBN番号：${textbook.isbn}</p>
			<p>販売価格：${textbook.price}</p>
			<p>著者：${textbook.author}</p>
			<p>状態：${textbook.quality}</p>
			<p>分類：${textbook.class}</p>
	    <a href="/tunnmals/PurchaseRegisterServlet" class="btn btn-success">購入</a>
			</div>
		</div>
	</c:forEach>
</div>
</body>
</html>