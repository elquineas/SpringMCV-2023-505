<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> --%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<t:insertAttribute name="head"/>
<body>
	<t:insertAttribute name="nav"/>
	<section class="main">
		<t:insertAttribute name="main-content">
		</t:insertAttribute>
	</section>
	<footer>
		<address>CopyRight &copy; All Right Reserved</address>
	</footer>
</body>
</html>