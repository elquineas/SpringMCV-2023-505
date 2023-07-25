<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li class="home"><a href="${rootPath}/">Home</a></li>
			<li class="rent"><a href="${rootPath}/">도서대여</a></li>
			<li class="book"><a href="${rootPath}/">도서정보</a></li>
			<li class="member"><a href="${rootPath}/">회원정보</a></li>
			<li class="login"><a href="${rootPath}/">로그인</a></li>
			<li class="admin"><a href="${rootPath}/">관리자</a></li>
		</ul>
	</nav>
	<section class="main"></section>
	<footer>
		<address>CopyRight &copy; elquineas@naver.com All Right Reserved</address>
	</footer>
</body>
</html>