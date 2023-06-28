<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
	ul{
		display: flex;
		list-style: none;
	}
	li{
		padding: 5px;
	}
</style>
<body>
	<h1>나의 친구들</h1>
	<c:forEach items="${ADDRS}" var="ADDR">
		<ul>
			<li>${ADDR.name}</li>
			<li>${ADDR.age}</li>
			<li>${ADDR.tel}</li>
			<li>${ADDR.address}</li>
		</ul>
	</c:forEach>
</body>
</html>