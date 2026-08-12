<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="inc/header.jsp"  %>
<!--    header       -->
<!--    header       -->
<%@page import="java.sql.*"%>
<% 
   //1. bno 넘겨받기
   request.setCharacterEncoding("UTF-8");
   int bno = Integer.parseInt(request.getParameter("bno")); 
  	String btitle = request.getParameter("btitle");
   //int bpass = Integer.parseInt(request.getParameter("bpass"));  	
  	String bcontent = request.getParameter("bcontent");   
  	String bpass = request.getParameter("bpass");
   //2. sql 구문 2개 처리
   //String bname = "",  btitle="", bcontent=""; 
   int bhit=0; 
   try{ 
       Connection conn = null;  PreparedStatement pstmt = null;   ResultSet rset = null;
       
       String sql1="update  mvcboard1   set  bhit=bhit+1    where  bno=?";
       String sql2="update  mvcboard1   set  btitle=? ,bcontent=?  where  bno=?  and bpass=?";
       
       String url="jdbc:mysql://localhost:3306/mbasic";   
       String user ="root" , pass="1234"; 
       
       Class.forName("com.mysql.cj.jdbc.Driver");      //1. 드라이버로딩
       conn = DriverManager.getConnection(url, user, pass);//2. jdbc연동
       //3. sql 구문처리
       pstmt = conn.prepareStatement(sql1);   pstmt.setInt(1, bno);
       if( pstmt.executeUpdate() > 0){   pstmt.close();    }
   
       pstmt = conn.prepareStatement(sql2);   
       pstmt.setString(1, btitle);
       pstmt.setString(2, bcontent);
       pstmt.setInt(3, bno);
       pstmt.setString(4, bpass);
  		if (pstmt.executeUpdate() > 0) {//4. 처리후 성공알림창 후 list.jsp 로 				주소표시창줄
   			out.println("<script> alert('글수정 성공했습니다.');  location.href='list.jsp';	</script>");
   		}else{ out.println("<script> alert('관리자에게 문의해주세요!');  location.href='list.jsp';	</script>"); }    // 실패시 수정폼으로 
       //4. jdbc끊기
       if(rset != null) {  rset.close();  }
       if(pstmt != null){  pstmt.close();  }
       if(conn != null) {  conn.close();  }
    }catch(Exception e){e.printStackTrace();}
%>

<!--    footer       -->
<!--    footer       -->
<%@include file="inc/footer.jsp"  %>
