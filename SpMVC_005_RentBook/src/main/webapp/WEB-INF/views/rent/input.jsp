<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/member.css?ver_001"  rel="stylesheet">
</head>
<body class="rent input">
	<h1>도서대여 정보 ${empty MEMBER.m_code ? '추가' : '수정' }</h1>
	<c:if test="${not empty MESSAGE && MESSAGE == 'NAME_TEL'}">
		<h2>* 이름과 전화번호 데이터가 이미 등록되어 있습니다.</h2>
	</c:if>
	<f:form modelAttribute="RENTBOOK" >
		<div><label>일련번호	</label><f:input path="rent_seq" /></div>
		<div><label>대출일		</label><f:input path="rent_date" /></div>
		<div><label>반납예정일	</label><f:input path="rent_return_date" /></div>
		<div><label>도서코드	</label><f:input path="rent_bcode" /></div>
		<div><label>회원코드	</label><f:input path="rent_mcode" /></div>
		<div><label>도서반납여부</label><f:input path="rent_return_yn" /></div>
		<div><label>포인트		</label><f:input path="rent_point" /></div>
		<div><label>대여금액	</label><f:input path="rent_price" /></div>
		<div>
			<button type="button">리스트로가기</button>
			<button type="submit">저장하기</button>
			<button type="reset">새로작성</button>
		</div>
	</f:form>
</body>
</html>







