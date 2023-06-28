<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>입력받은 데이터</h1>
	<table>
			<tr>
				<td>USERNAME</td>
				<td>${USER.username}</td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td>${USER.password}</td>
			</tr>
			<tr>
				<td>RE PASSWORD</td>
				<td>${REPW}</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${USER.name}</td>
			</tr>
			<tr>
				<td>TEL</td>
				<td>${USER.tel}</td>
			</tr>
			<tr>
				<td>AGE</td>
				<td>${USER.age}</td>
			</tr>
			<tr>
				<td>ADDR</td>
				<td>${USER.addr}</td>
			</tr>
		</table>
</body>
</html>