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
	<h1>���� ����Ʈ</h1>
	<%
	/*
		UserController ���� ������ USERS Attribute�� 
		Table�� ����Ͽ� ȭ�鿡 Rendering �ϱ�
	*/
	%>
	<table>
		<tr>
			<th>USER NAME</th>
			<th>�̸�</th>
			<th>��ȭ��ȣ</th>
			<th>����</th>
			<th>�ּ�</th>
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
	<a href="${rootPath}/user/input">�߰��ϱ�</a>
</body>
</html>