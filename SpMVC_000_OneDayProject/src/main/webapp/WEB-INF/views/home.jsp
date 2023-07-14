<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차계부</title>
<link href="${rootPath }/res/css/main.css?2023-07-14-049" rel="stylesheet">

</head>
<body>
	<header>MY CAR MANAGER</header>
	<section>
		<c:if test="${CAR == 'INSERT'}">
			<form class="main" method="POST" action="${rootPath}/insert">
				<table class="main insert">
						<tr>
							<td>운행등록</td>
							<td><input name="c_division" placeholder="구분"/></td>
							<td><input name="c_sDistance" placeholder="시작거리(km)"/></td>
							<td><input name="c_place" placeholder="장소"/></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><input name="c_eDistance" placeholder="종료거리(km)" readonly="readonly"/></td>
							<td><input name="c_cost" placeholder="소요비용"/></td>
							<td><button class="main save">저장</button></td>
						</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${CAR == 'UPDATE'}">
			<form class="main" method="POST" action="${rootPath}/update">
				<table class="main insert">
					<tr>
						<td>운행등록</td>
						<td><input name="c_division" value="${CAR_UPDATE.c_division}" placeholder="구분"  readonly="readonly"/></td>
						<td><input name="c_sDistance" value="${CAR_UPDATE.c_sDistance}"  placeholder="시작거리(km)" readonly="readonly"/></td>
						<td><input name="c_place" value="${CAR_UPDATE.c_place}"  placeholder="장소"/></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input name="c_seq" type=hidden value="${CAR_UPDATE.c_seq}"/></td>
						<td><input name="c_eDistance" value="${CAR_UPDATE.c_eDistance}"  placeholder="종료거리(km)"/></td>
						<td><input name="c_cost" value="${CAR_UPDATE.c_cost}"  placeholder="소요비용"/></td>
						<td><button class="main save">저장</button></td>
					</tr>
				</table>
			</form>
		</c:if>
		<table class="main list">
			<tr>
				<th>No.</th>
				<th>구분</th>
				<th>출발일자</th>
				<th>출발시간</th>
				<th>출발거리(km)</th>
				<th>도착일자</th>
				<th>도착시간</th>
				<th>도착거리(km)</th>
				<th>장소</th>
				<th>소요비용</th>
			</tr>
			
			<c:forEach items="${CAR_LIST}" var="CAR">
				<tr>
					<td>${CAR.c_seq}</td>
					<td>${CAR.c_division}</td>
					<td>${CAR.c_sDate}</td>
					<td>${CAR.c_sTime}</td>
					<td>${CAR.c_sDistance}</td>
					<td>${CAR.c_eDate}</td>
					<td>${CAR.c_eTime}</td>
					<td>${CAR.c_eDistance}</td>
					<td>${CAR.c_place}</td>
					<td>${CAR.c_cost}</td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>