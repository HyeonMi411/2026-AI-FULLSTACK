<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp" %>    
<!--  header -->
<!--  header -->
    
   <div class="container card my-5">
      <h3 class="card-header">회원가입</h3>
      <!--	1. 처리 : write_action.jsp	2. 데이터 주소표시창줄 노출 x	3. 보관용기이름 file이름 
       -->
      <form  action ="write_action.jsp"  method="post"   onsubmit="return checkForm()">
         <div  class="my-3">
            <label for="bname"   class="form-label">닉네임</label>
            <input type="text"   class="form-control"    id="bname"  name="bname"  />
         </div> 
         <div  class="my-3">
            <label for="bpass"   class="form-label">비밀번호</label>
            <input type="password"   class="form-control"    id="bpass"  name="bpass"  />
         </div>
         <div  class="my-3">
            <label for="bemail"  class="form-label">이메일</label>
            <input type="email"   class="form-control"    id="bemail"  name="bemail"  />
         </div>
         <div  class="my-3">
            <label for="bcontent"  class="form-label">휴대폰</label>
            <textarea  class="form-control"    id="bcontent"  name="bcontent"  ></textarea>
         </div>
         <div  class="my-3  text-end"> 
            <button type="reset"   class="btn btn-outline-primary"  title="글취소">취소</button>            
            <button type="submit"  class="btn btn-primary"  title="가입하기">가입하기</button>
         </div>
      </form> 
      <script>
      function   checkForm(){
         let bname = document.getElementById("bname");
         let bpass = document.getElementById("bpass");
         let btitle = document.getElementById("btitle");
         let bcontent = document.getElementById("bcontent");
         
         if(bname.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");  bname.focus();  return false; }
         if(bpass.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");  bpass.focus();  return false; }
         if(btitle.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요"); btitle.focus();  return false; }
         if(bcontent.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");bcontent.focus();  return false;}
         return true;
      }
      </script>
   </div>

<!--  footer -->
<!--  footer -->
<%@include file="inc/footer.jsp" %>