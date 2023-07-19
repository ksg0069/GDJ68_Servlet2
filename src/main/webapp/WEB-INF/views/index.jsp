<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./temp/bootstrap.jsp"></c:import>


</head>

<body>
<c:import url="./temp/header.jsp"></c:import>

<c:if test="${member ne null }"><h1>로그인 상태</h1> </c:if>
<%-- <c:if test="${not empty member}"> 로그인상태</c:if> --%>

<c:if test="${member eq null }"><h1>비로그인 상태</h1> </c:if>
<%-- <c:if test="${empty member}"> 비로그인상태</c:if> --%>

	
	
	

	

</body>
</html>


























