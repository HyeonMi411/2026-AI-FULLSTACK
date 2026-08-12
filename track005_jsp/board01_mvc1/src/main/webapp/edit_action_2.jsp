<%-- <%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%
	//1. utf-8 설정
	request.setCharacterEncoding("utf-8");		
	//2. request.getParameter() 이용해서 데이터 받기
	int    bno   = Integer.parseInt(request.getParameter("bno"));
   	String bname = request.getParameter("bname");
   	String bpass = request.getParameter("bpass");
   	String btitle = request.getParameter("btitle");
   	String bcontent = request.getParameter("bcontent");	//out.println(bname + "/" + bpass + "/" + btitle + "/" + bcontent);
	int    bhit   = Integer.parseInt(request.getParameter("bhit"));
	
	try{
		Connection conn = null; PreparedStatement pstmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "update  mvcboard1   set  btitle=? ,bcontent=? bhit=bhit+1  where  bno=?  and bpass=?";	//##	//3. update sql
		//String sql2 = "update  mvcboard1   set  bhit=bhit+1    where  bno=?";	//##	//3. update sql
		String user = "root"	, pass="1234";
		
		conn = DriverManager.getConnection(url , user , pass);
		pstmt = conn.prepareStatement(sql);
		//pstmt = conn.prepareStatement(sql2);
   		pstmt.setString( 1   , btitle);
   		pstmt.setString( 2   , bcontent);   		
   		//pstmt.setInt   ( 3   , bhit);
   		pstmt.setInt   ( 3   , bno);
   		pstmt.setString( 4   , bpass);   		
   		
		//int result = pstmt.executeUpdate();		// insert, update, delete 실행한 줄 수		   		
		//4. list.jsp 로 돌아가기		- 알림창			주소표시창줄
		if (pstmt.executeUpdate() > 0) {
			out.println("<script> alert('수정성공!'); location.href='list.jsp'; </script>");
		}else{
			out.println("<script> alert('수정실패!');  location.href='list.jsp'; </script>");   			
		}

		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
	} catch (Exception e) { e.printStackTrace(); }

   %>    
 --%>