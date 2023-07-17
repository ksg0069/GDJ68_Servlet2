<%@page import="com.iu.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- c= 태그명을 c라고 하겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail page</h1>
	<% BankBookDTO bankBookDTO = (BankBookDTO ) request.getAttribute("dto");%>
	
	<h3><%= bankBookDTO.getBookName() %></h3>
	
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째 글자를 소문자로 바꾼것-->
	<h1> ${ requestScope.dto.bookName }</h1>
	
	<div>
	<h1>${ dto.bookContents }</h1>
	</div>
	
	<h1> ${ dto.bookRate } </h1>
	
	<c:choose>   
		<c:when test="${dto.bookSale eq 1 }">
		<h1>판매중</h1>
		</c:when>
		<c:otherwise>
		<h1>판매종료</h1>
		</c:otherwise>
	</c:choose>
	
	<a href="./update.do?bookNum=${dto.bookNum}"> 수정 </a>
	<a href="./delete.do?bookNum=${dto.bookNum }">삭제</a>

	
	<%-- <c:if test="${dto.bookSale == 1}"> 
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale == 0}"> 
		<h1>판매 종료</h1>
	</c:if> --%>

</body>
</html>