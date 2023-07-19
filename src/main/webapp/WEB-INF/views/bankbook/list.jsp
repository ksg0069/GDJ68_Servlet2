
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/index.css">
<c:import url="../temp/bootstrap.jsp"></c:import>

</head>
<body>
<c:import url="../temp/header.jsp"></c:import>


	<section class="container mt-5">
	<h1 class="mb-4 text-center"  > BankBook List</h1>
	<!-- 표현식 -->
	
	<table class="table table-dark table-striped">
		<thead>
		<th>상품명</th> <th>이자율</th>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i"> <!-- 서버에서 보낸 arrylist를(콜렉션 계열) items에 넣는다 , items의 갯수만큼 꺼내서 돌림 var=d->dto의미  -->
			
				 <tr>
					<td ><a class="text-decoration-none" href="./detail.do?bookNum=${d.bookNum}">${d.bookName}</a></td>	
					<td> ${d.bookRate} ${i.index } </td>
						 
	 			</tr>
								
			</c:forEach>	
	
		</tbody>
	</table>
	
	<a class="btn btn-danger" href="./add.do"> 상품등록 </a>
	</section>
	
<%-- 	<c:forEach begin="1" end="10" step="2" var="num"> <!--  증가만 됨 -->
		<h1>${num}</h1>              
	</c:forEach> --%>

</body>
</html>