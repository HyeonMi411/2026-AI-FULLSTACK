<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@include file="inc/header.jsp" %>     
<!--  header -->
<!--  header -->
    
   <div class="container card my-5">
      <h3 class="card-header">로그인</h3>
     <form action="delete_action.jsp?bno=<%=request.getParameter("bno")%>" method="post" 
     		onsubmit="return checkForm()">
      <div class="my-3">
         <label for="bemail"		class="form-label">이메일</label> 
         <input type="email" class="form-control" placeholder="" id="bemail" name="bemail" />
      </div>
      <div class="my-3">
         <label for="bpass"		class="form-label">비밀번호</label> 
         <input type="password" class="form-control" placeholder="" id="bpass" name="bpass" />
      </div>
      <div  class="my-3  text-end"> 
         <button type="reset"   class="btn btn-outline-primary"  title="글취소">취소</button>         
         <button type="submit"  class="btn btn-primary"  title="로그인">로그인</button>
      </div>
     </form>

      <script>
      function checkForm() {    	  	    	      	  
    	  let bpass = document.getElementById("bpass");    	      	  
    	  if(bpass.value.trim() == ""){ alert("빈칸입니다. \n확인해주세요"); bpass.focus(); return false; }    	  
    	  return true;
	  }
      </script>        
   </div>
   

<!--  footer -->
<!--  footer -->
<%@include file="inc/footer.jsp" %>