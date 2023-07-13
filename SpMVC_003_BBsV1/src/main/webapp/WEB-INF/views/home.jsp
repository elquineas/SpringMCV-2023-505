<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/main.css?2023-07-11-003" rel="stylesheet">
</head>
<body>
	<header class="main">
		<h1>이미지 겔러리</h1>
	</header>
	<section class="main">
		<c:if test="${empty BODY}">
			<table class="main">
				<tr>
					<th>No.</th>
					<th>작성일자</th>
					<th>작성시간</th>
					<th>작성자ID</th>
					<th>제목</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${BBS_LIST}" var="BBS">
					<tr>
						<td>${BBS.b_seq}</td>
						<td>${BBS.b_date}</td>
						<td>${BBS.b_time}</td>
						<td><a href="${rootPath}/search/user?username=${BBS.b_username}">${BBS.u_nickname}</a></td>
						<td><a href="${rootPath}/detail?seq=${BBS.b_seq}">${BBS.b_subject}</a></td>
						<td>${BBS.b_count}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="main button_box">
				<a>글쓰기</a>
			</div>
		</c:if>
		<c:if test="${BODY == 'DETAIL'}">
			<table class="detail">
<%-- 				<tr>
					<td>${BBS.b_seq}</td>
					<td>${BBS.b_pseq}</td>
					<td>${BBS.b_username}</td>
					<td>${BBS.b_content}</td>
					<td>${BBS.b_count}</td>
				</tr> --%>
				<tr>
					<td>작성일자</td><td>${BBS.b_date}</td>
					<td>작성시각</td><td>${BBS.b_time}</td>
				</tr>
				<tr>	
					<td>작성자</td><td>${BBS.u_nickname}</td>
					<!-- <td></td><td></td> -->
				</tr>
				<tr>	
					<td>제목</td><td colspan="3">${BBS.b_subject}</td>
				</tr>
				<tr>	
					<td>내용</td><td colspan="3">${BBS.b_content}</td>
				</tr>
			</table>
		</c:if>
	</section>
</body>
</html>