<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리김밥 POS</title>
<link href="${rootPath}/res/css/main.css?2023-09-22-002" rel="stylesheet">
<script>var rootPath = "${rootPath}" </script>
<script src="${rootPath}/res/js/home.js?2023-09-22-004""></script>
</head>
	<body>
		<header>header</header>
		<section class="main section">
			<div class="main table_box">
				<div>01</div>
				<div>02</div>
				<div>03</div>
				<div>04</div>
			</div>
			<div class="main table_box">
				<div>05</div>
				<div>06</div>
				<div>07</div>
				<div>08</div>
			</div>
			<div class="main table_box">
				<div>09</div>
				<div>10</div>
				<div>11</div>
				<div>12</div>
			</div>
		</section>
		<footer>footer</footer>
	</body>
</html>