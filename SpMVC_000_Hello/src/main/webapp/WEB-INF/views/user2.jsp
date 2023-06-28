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
	table{
		border-collapse: collapse;
		width:80%;
		margin: 20px auto;
	}
	td, th{
		text-align: left;
		padding: 12px 16px;
	}
	tr:nth-child(even) {
		background-color: #bbb;
	}
	tr:nth-child(odd) {
		background-color: #eee;
	}
	tr:hover{
		cursor: pointer;
		background: #aaa;
	}
	header{
	 background
		background-color: green;
		padding: 2rem;
		text-align: center;
		text-shadow: 1px 1px 1px black;
		color: yellow;
	}
}
	
</style>
<body>
	<header>
		<h1>���� ģ����2</h1>
		<h2>2023�� ���� ���� ��ģ��</h2>
	</header>
	<table>
		<tr>
			<th>�̸�</th>
			<th>����</th>
			<th>��ȭ��ȣ</th>
			<th>�ּ�</th>
		</tr>
		<c:forEach items="${ADDRS}" var="ADDR">
			<tr>
				<td>${ADDR.name}</td>
				<td>${ADDR.age}</td>
				<td>${ADDR.tel}</td>
				<td>${ADDR.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>