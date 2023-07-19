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
<style>

</style>
<body>
<c:import url="../temp/header.jsp"></c:import>
 
 
 <section class="container mt-5">
 
 <form action="./join.do" method="POST">
 		<h1 class="mb-5">회원가입</h1>
 		<!-- id -->
		<div class="mb-3 ">
		<label for="id" class="form-label">ID</label>
		<input  type="text" class="form-control" id="id" name="id" placeholder="id 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<!-- pw -->
		<div class="mb-3 ">
		<label for="pw" class="form-label">PW</label>
		<input type="password" class="form-control" id="pw" name="pw" placeholder="pw 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<!-- name -->
		<div class="mb-3 ">
		<label for="name" class="form-label">NAME</label>
		<input type="text" class="form-control" id="name" name="name" placeholder="이름 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<!-- email  -->
		<div class="mb-3 ">
		<label for="email" class="form-label">Email</label>
		<input type="email" class="form-control" id="email" name="email" placeholder="Email 입력"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<!-- birth -->
		<div class="mb-3 ">
		<label for="birth" class="form-label">생년월일</label>
		<input type="date" class="form-control" id="birth" name="birth">   <!-- dto의 setter의 이름을 씀-->
		</div>
		
		<button  type="submit" class="btn btn-outline-primary"><a  class="text-dark text-decoration-none "  >회원가입</a></button>
		
		
</form>		
 
 </section>
 

</body>
</html>