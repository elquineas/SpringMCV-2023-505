<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<div><input name="username" placeholder="USERNAME"></div>
		<div><input name="password" placeholder="PASSWORD" type="password" ></div>
		<div><button>LOGIN</button></div>
		<%/*
		a tag �� ����Ͽ� ������ Request �� ��û�Ҷ��� context(����) Path��
		ȥ���Ǿ� �� ��ũ�� ������� �ʴ� ��찡 ����
		�̶��� ��ũ �ּ� �տ� ${pageContext.request.contextPath} �� �����ϸ� 
		��ũ�� ȥ������ �ʰ� ������ ���� �ȴ�
		*/%>
		<div><a href="${pageContext.request.contextPath}/user/join">JOIN</a></div>
	</form>
</body>
</html>