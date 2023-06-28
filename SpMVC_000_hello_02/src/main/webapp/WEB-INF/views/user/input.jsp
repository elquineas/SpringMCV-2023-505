<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<table>
			<tr>
				<td>USERNAME</td>
				<td><input name="username" placeholder="USERNAME"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input name="password" type="password" placeholder="PASSWORD"></td>
			</tr>
			<tr>
				<td>RE PASSWORD</td>
				<td><input name="re_password" type="password" placeholder="PASSWORD 확인"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input name="name" placeholder="NAME"></td>
			</tr>
			<tr>
				<td>TEL</td>
				<td><input name="tel" placeholder="TEL"></td>
			</tr>
			<tr>
				<td>AGE</td>
				<td><input name="age" type="number" placeholder="AGE"></td>
			</tr>
			<tr>
				<td>ADDR</td>
				<td><input name="addr" placeholder="ADDRESS"></td>
			</tr>
			<tr>
				<td rowspan="2">
					<button>추가하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>