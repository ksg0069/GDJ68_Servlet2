<%@page import="com.iu.main.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<% MemberDTO memberDTO =(MemberDTO) request.getAttribute("member"); %>
<h1>mypage</h1>
<h2>id: ${member.id}</h2>
<h2>name: ${member.name }</h2>
<h2>${member.pw }</h2>
</body>
</html>