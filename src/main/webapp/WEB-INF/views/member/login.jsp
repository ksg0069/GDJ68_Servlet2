<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>

<section class="container mt-5">
	<form action="./login.do" method="POST">
		<h1 class="mb-5">로그인</h1>
		<div class="mb-3 ">
		<label for="id" class="form-label">ID</label>
		<input  type="text" class="form-control" id="id" name="id" placeholder="id 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<div class="mb-3 ">
		<label for="pw" class="form-label">PW</label>
		<input type="password" class="form-control" id="pw" name="pw" placeholder="pw 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		
		<button  type="submit" class="btn btn-outline-primary text-decoration-none "> 로그인</button>
	</form>
</section>
</body>
</html>