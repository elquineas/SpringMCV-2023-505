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
<link href="${rootPath}/static/css/rent.css?ver_004"  rel="stylesheet">
<link href="${rootPath}/static/css/input.css?ver_004"  rel="stylesheet">
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main.js?ver_004"></script>
<script src="${rootPath}/static/js/book.js?ver_004"></script>
</head>
<body class="rent input">
	<h1>도서검색</h1>
	<f:form  action="${rootPath}/rent/go/member" modelAttribute="RENT_WORK">
		<div>
			<label>도서명</label>
			<div class="search container">
				<f:input path="b_name" />
				<div class="search list">Search List</div>
			</div>
		</div>
		<div><label>도서코드</label><f:input path="rent_bcode" /></div>
		<div><label>출판사</label><f:input path="b_comp" /></div>
		<div><button>다음 >></button></div>
	</f:form>
</body>
</html>