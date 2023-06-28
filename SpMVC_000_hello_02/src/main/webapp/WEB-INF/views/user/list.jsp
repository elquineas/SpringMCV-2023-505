<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 리스트</h1>
	<%
	/*
		UserController 에서 설정한 USERS Attribute를 
		Table을 사용하여 화면에 Rendering 하기
	*/
	%>
	<table>
		<tr>
			<th>USER NAME</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${USERS}" var="USER">
			<tr>
				<td>${USER.username}</td>
				<td>${USER.name}</td>
				<td>${USER.tel}</td>
				<td>${USER.age}</td>
				<td>${USER.addr}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${rootPath}/user/input">추가하기</a>
</body>
</html>