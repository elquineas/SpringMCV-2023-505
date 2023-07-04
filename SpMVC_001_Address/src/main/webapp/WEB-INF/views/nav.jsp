<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="main">
	<ul>
		<li class="home">Home</li>
		<c:if test="${empty USER}">
			<li class="user login">Login</li>
			<li class="user join">Join</li>
		</c:if>
		<c:if test="${not empty USER}">
			<li class="user mypage">My Page( ${USER.username} )</li>
			<li class="user logout">Logout</li>
		</c:if>
		<c:if test="${USER.role == 'ROLE_ADMIN'}">
			<li class="admin">admin</li>
		</c:if>
		
	</ul>
</nav>