<%--  <%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@include file="inc/header.jsp" %>     
<!--  header -->
<!--  header --> 

<% //1. 데이터 넘겨받기	- bname, bpass, btitle, bcontent / bip - InetAddress .getLocalHost().getHostAddress()
	String bname = "", btitle="", bcontent=""; int bhit=0;
   	request.setCharacterEncoding("UTF-8");
   	//String bname = request.getParameter("bname");
   	//String bpass = request.getParameter("bpass");
   	//String btitle = request.getParameter("btitle");
   	//String bcontent = request.getParameter("bcontent");	//out.println(bname + "/" + bpass + "/" + btitle + "/" + bcontent);   	
//2. sql처리
   	try{ //-1) list.jsp    전체 리스트 출력	select * from mvcboard1 order bno desc
   		Connection conn = null; PreparedStatement pstmt = null;		//ResultSet rset = null;
   		
   		String sql1 = "update  mvcboard1   set  bhit=bhit+1    where  bno=?";
   		String sql2 = "select * from   mvcboard1  where  bno=?";
   		
   		String url  = "jdbc:mysql://localhost:3306/mbasic";
   		String user = "root"	, pass="1234";
   		
   		Class.forName("com.mysql.cj.jdbc.Driver");				//1. 드라이버로딩
   		conn = DriverManager.getConnection(url , user , pass);	//2. jdbc연동
   		
   		pstmt = conn.prepareStatement(sql1);	pstmt.setInt(1, bno);
   		if( pstmt.executeUpdate() > 0){	pstmt.close();	}
   		
   		pstmt = conn.prepareStatement(sql2);	pstmt.setInt(1, bno);
   		rset = pstmt.executeQuery();
   		if(rset.next()){
   			bname = rset.getString("bname");	btitle = rset.getString("bname");
   			bcontent = rset.getString("bname");	bhit = rset.getString("bname");   			
   		}

   		//5. jdbc끊기 if (rset != null) { rset.close(); }
   		if (pstmt != null) { pstmt.close(); }
   		if (conn != null) { conn.close(); }
   	} catch (Exception e) { e.printStackTrace(); }
   %> 
    
   <div class="container card my-5">
      <h3 class="card-header">글 상세보기</h3>
      <form  action ="#"  method="post"   onsubmit="return checkForm()">
         <div  class="my-3">
            <label for="bname"   class="form-label">이름</label>
            <input type="text"   class="form-control"	value="<%=bname%>"    id="bname"  name="bname"	readonly	/>
         </div>
         <div  class="my-3">
            <label for="btitle"  class="form-label">제목</label>
            <input type="text"   class="form-control"	value="<%=btitle%>"    id="btitle"  name="btitle"	readonly	/>
         </div>
         <div  class="my-3">
            <label for="bcontent"  class="form-label">내용</label>
            <textarea  class="form-control"    id="bcontent"	readonly	></textarea>
         </div>
         <div  class="my-3  text-end"> 
            <a href="edit.jsp?bno=<%=bno%>"             class="btn btn-outline-primary"  title="글수정">수정</a>
            <a href="delete.jsp"             class="btn btn-outline-primary"  title="글삭제">삭제</a>
            <a href="list.jsp"             class="btn btn-outline-success"  title="목록보러가기">목록</a>
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
<%@include file="inc/footer.jsp" %> --%>