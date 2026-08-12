<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- 			header			 -->
<!-- 			header			 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_jumbotron.php -->
<!-- bg-primary(파랑)  bg-danger(빨강)  warning(노랑)  -->
<div class="p-5 bg-primary text-white">
	<h1>Milk Order Project</h1>
	<p>MVC1 - PreparedStatemtnt Ex</p>
</div>

<!-- 			메뉴판테이블			 -->
<!-- 			메뉴판테이블			 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_tables.php -->
   <div class="container card my-5 bg-primary text-white ">
      <h2 class="card-header">Milk Menu</h2>
      
		<form  action=""  method="post" onsubmit="return check()">
			<div class="my-3">
				<label for="no"   class="form-label">NO : </label>
				<input type="number"  class="form-control"  id="no"  name="no"
					   min="0"   max="100"  value="0"
				 />      
			</div><!-- end kor -->
			<div class="my-3">
				<label for="name"   class="form-label">NAME : </label>
				<input type="number"  class="form-control"  id="name"  name="name"
					   min="0"   max="100" />      
			</div><!-- end kor -->
			<div class="my-3">
				<label for="price"   class="form-label">PRICE : </label>
				<input type="number"  class="form-control"  id="price"  name="price" 
					   min="0"   max="100"/>      
			</div><!-- end kor -->
			<div class="my-3"  style="text-align:right" > 
				<button type="submit"    class="btn btn-success" 
					  title="성적처리하러가기"       >성적처리</button>
			</div><!-- end kor    text-end-->			
		</form>
		<script>
      	function check(){
      		let kor = document.getElementById("no");
      		if(kor.value.trim() ==""){
      			alert("번호를 입력해주세요!");
      			kor.focus();	//커서
      			return false;      			
      		}
      		let eng = document.getElementById("name");
      		if(eng.value.trim() ==""){
      			alert("이름을 입력해주세요!");
      			eng.focus();	//커서
      			return false;      			
      		}
      		let math = document.getElementById("price");
      		if(math.value.trim() ==""){
      			alert("가격을 입력해주세요!");
      			math.focus();	//커서
      			return false;      			
      		}
      		return true;      			
      	}
		</script>
      	<%@page import="java.sql.*"%>      
      	<%
      	
      		//1. 드라이버연동
      		//2. JDBC 연동
      		//3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기
      		//	 가격이 낮은순으로
      		//4. JDBC 끊기
      		
			/* 			1	white	1500
			      		2	choco	1800
			      		3	banana	1800 */
			      		
			      		
			      		int no = Integer.parseInt(	request.getParameter("no"));
			      		String name = request.getParameter("name");
			      		int price = Integer.parseInt(	request.getParameter("price"));		      		
      


	      %>      
      
      <table class="table table-bordered table-striped table-hover">
      	<caption>우유메뉴</caption>
      	<thead>
   			<tr>
   				<th scope="col">NO</th>
   				<th scope="col">NAME</th>
   				<th scope="col">PRICE</th>      			
   			</tr>      				
      	</thead>
      	<tbody>
      		<tr>
      			<td><%=no%></td>
      			<td><%=name%></td>
      			<td><%=price%></td>      		
      		</tr>

   		
   		
      	</tbody>
      
      </table>
      
   </div>
         





<!-- 			주문현황표			 -->
<!-- 			주문현황표			 -->

   <div class="container card my-5 bg-primary text-white ">
      <h2 class="card-header">Milk Order</h2>
      
      <table class="table table-bordered table-striped table-hover">
      	<caption>우유메뉴</caption>
      	<thead>
   			<tr>
   				<th scope="col">NO</th>
   				<th scope="col">NAME</th>
   				<th scope="col">NUM</th>      			
   				<th scope="col">주문날짜</th>      			
   			</tr>      				
      	</thead>
      	<tbody>
  	
      

   		
   		
      	</tbody>
      
      </table>
      
   </div>



<!-- 			주문삽입, 수정, 삭제			 -->
<!-- 			주문삽입, 수정, 삭제			 -->

   <div class="container card my-5 bg-primary text-white ">
      <h2 class="card-header">Milk 주문하러가기</h2>
      
      <table class="table table-bordered table-striped table-hover">
      	<caption>우유메뉴</caption>
      	<thead>
   			<tr>
      			<td>주문할 우유이름</td>
      			<td>주문할 우유갯수</td>   			
  			
   			</tr>      				
      	</thead>
      	<tbody>
   	
      

   		
   		
      	</tbody>
      
      </table>
      
   </div>
      
      
      
</body>
</html>
<!--    <div>
	   	<table>
	   	<h4>Milk Menu</h4>
	   		<tr>
	   			<td>no</td>
	   			<td>name</td>
	   			<td>price</td>     		
	   		</tr>      	
	   	</table>
   
   </div>

   <div>
   
      	<table>
      	<h4>MILK ORDER</h4>      	
      		<tr>
      			<td>no</td>
      			<td>name</td>
      			<td>price</td>     		
      		</tr>      	
      	</table>
   </div>
      
      
       
      
      
      
      	<h4>MILK 주문하러가기</h4>      	
      	<table>
      		<h5>주문하기</h5>
      		<tr>
      			<td>주문할 우유이름</td>
      			<td>주문할 우유갯수</td>
      		</tr>
      	
      	</table>
      	<table>
      		<h5>주문수정</h5>
  	
      	</table>
      	<table>
      		<h5>주문삭제</h5>
     	
      	</table> -->