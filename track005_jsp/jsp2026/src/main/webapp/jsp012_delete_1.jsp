<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%
   // jsp012_insert.jsp
   	//1. utf-8 설정
   	request.setCharacterEncoding("UTF-8");		
   	//2. request.getParameter() 이용해서 데이터 받기   	
   	int ono = Integer.parseInt(request.getParameter("ono")); //out.println(oname + " / " + onum);	
   	//3. insert 구문처리
   	try{
   		Connection conn = null; PreparedStatement pstmt = null;
   		Class.forName("com.mysql.cj.jdbc.Driver");
   		String url  = "jdbc:mysql://localhost:3306/mbasic";
   		String sql = "delete from milk_order where ono=?";
   		conn = DriverManager.getConnection(url , "root" , "1234");
   		pstmt = conn.prepareStatement(sql);   		
   		pstmt.setInt(    1   , ono);   		
   		
   		int result = pstmt.executeUpdate();		// insert, update, delete 실행한 줄 수
   		//4. jsp012_milks.jsp 로 돌아가기		- 알림창			주소표시창줄
   		if (result > 0) {
   			out.println("<script> alert('우유주문 삭제 성공했습니다.');  location.href='jsp012_milk.jsp';	</script>");
   		}else{
   			out.println("<script> alert('관리자에게 문의해주세요!');  location.href='jsp012_milk.jsp';	</script>");   			
   		}

   		if (pstmt != null) { pstmt.close(); }
   		if (conn != null) { conn.close(); }
   	} catch (Exception e) { e.printStackTrace(); }
   %>    

<!-- 
//1. utf-8 설정
//2. request.getParameter() 이용해서 데이터 받기
//3. insert 구문처리
//4. jsp012_milks.jsp 로 돌아가기
 -->


