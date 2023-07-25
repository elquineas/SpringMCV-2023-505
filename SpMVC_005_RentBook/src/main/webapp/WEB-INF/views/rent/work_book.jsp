<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/rent.css?ver_001"  rel="stylesheet">
</head>
<body class="rent input">
	<h1>도서검색</h1>
	<f:form  action="${rootPath}/rent/book" modelAttribute="RENT_WORK">
		<div><label>도서명</label><f:input path="b_name" /></div>
		<div><label>도서코드</label><f:input path="rent_bcode" /></div>
		<div><label>출판사</label><f:input path="b_comp" /></div>
		<div><button>다음 >></button></div>
	</f:form>
</body>
</html>