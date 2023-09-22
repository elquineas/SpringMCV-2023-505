<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/res/css/main.css?2023-09-22" rel="stylesheet">
<link href="${rootPath}/res/css/order.css?2023-09-22-029" rel="stylesheet">
</head>
<body>
	<header>header</header>
	<section class="order section">
		<div class="order list_box">
			<div class="order table">${TABLE_NUM}</div>
			<div class="order list">
				<table>
					<colgroup>
						<col width="35%">
						<col width="25%">
						<col width="15%">
						<col width="25%">
					</colgroup>
					<thead class="order thead">
						<tr>
							<td>품목</td>
							<td>단가</td>
							<td>수량</td>
							<td>금액</td>
						</tr>
					</thead>
				</table>
				<table>
					<colgroup>
						<col width="35%">
						<col width="25%">
						<col width="15%">
						<col width="25%">
					</colgroup>
					<tbody>
						<tr>
							<td>1000 김밥</td>
							<td>1000</td>
							<td>2</td>
							<td>2000</td>
						</tr>
						<tr>
							<td>2000 김밥</td>
							<td>2000</td>
							<td>10</td>
							<td>20000</td>
						</tr>
						<tr>
							<td>3</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>4</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>5</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>6</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>7</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>8</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>8</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>8</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>8</td><td></td><td></td><td></td>
						</tr>
						<tr>
							<td>합계</td>
							<td></td>
							<td></td>
							<td>22000</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="order payment">결제하기</div>
		</div>
		<div class="order menu_box">
			<div class="order space_box"></div>
			<div class="order menu_list">
				<div>1000 김밥</div>
				<div>1100 김밥</div>
				<div>1200 김밥</div>
				<div>1300 김밥</div>
				
				<div>1400 김밥</div>
				<div>1500 김밥</div>
				<div>1600 김밥</div>
				<div>1700 김밥</div>
				
				<div>2000 김밥</div>
				<div>2100 김밥</div>
				<div>2200 김밥</div>
				<div>2300 김밥</div>
				
				<div>2400 김밥</div>
				<div>2500 김밥</div>
				<div>2600 김밥</div>
				<div>2700 김밥</div>
				
				<div>3000 김밥</div>
				<div>3100 김밥</div>
				<div>3200 김밥</div>
				<div>3300 김밥</div>
				
				<div>3400 김밥</div>
				<div>3500 김밥</div>
				<div>3600 김밥</div>
				<div>3700 김밥</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>