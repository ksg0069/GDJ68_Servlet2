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



<h1>Add page</h1>

	<form action="./add.do" method="post">
		<div class="mb-3">
		<label for="bookName" class="form-label">상품명</label>
		<input type="text" class="form-control" id="bookName" name="bookName"> <br>  <!-- dto의 setter의 이름을 씀-->
		</div>
		<div class="mb-3">
		<label for="bookContents" class="form-label">상세설명</label>
		<textarea rows="" cols="" class="form-control" id="bookContents" name="bookContents"></textarea>
		</div>
		<div class="mb-3">
		<label for="bookRate" class="form-label">이자율</label>
		<input type="text" class="form-control" id="bookRate" name="bookRate"> <br>
		</div>
		<div class="form-check">
		<p>
			판매가능 <input class="form-check-input" type="radio" checked name="bookSale" value="1"> <br>
			판매중지 <input class="form-check-input" type="radio" name="bookSale" value="0"> <br>
		</p>
		</div>
		
		<!-- <p>
		<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>	
		</select>
		</p> -->
		
		
		<button class="btn btn-danger" type="submit">등록</button>
		<input class="btn btn-danger" type="submit" value="ADD">
		<input class="btn btn-danger" type="reset" value="reset">
		<input class="btn btn-danger" type="button" value="ADD">
	
	</form>
	

</body>
</html>