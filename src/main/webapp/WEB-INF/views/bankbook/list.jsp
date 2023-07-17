
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- 표현식 -->
	
	<table>
		<thead>
		<th>상품명</th> <th>이자율</th>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i"> <!-- 서버에서 보낸 arrylist를(콜렉션 계열) items에 넣는다 , items의 갯수만큼 꺼내서 돌림 var=d->dto의미  -->
			
				 <tr>
					<td><a href="./detail.do?bookNum=${d.bookNum}">${d.bookName}</a></td>	
					<td>${d.bookRate} </td>
					<td>${i.index }</td> 	 
	 			</tr>
								
			</c:forEach>	
	
		</tbody>
	</table>
	
	<a href="./add.do"> 상품등록 </a>
	
<%-- 	<c:forEach begin="1" end="10" step="2" var="num"> <!--  증가만 됨 -->
		<h1>${num}</h1>              
	</c:forEach> --%>
</body>
</html>