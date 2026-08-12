<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% /*	jsp016_result.jsp	*/
	//1. 데이터 넘겨받기
	request.setCharacterEncoding("UTF-8");
	String email	= request.getParameter("email");
	String bpass	= request.getParameter("bpass");
	
	//2. sql 구문처리 - select * from users where  email=? and bpass=?
	// 로그인성 성공했다면
	
       
/*         try{//1. 드라이버연동 - Class.forName
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn=null;  PreparedStatement pstmt = null;  ResultSet rset = null;
          
          //2. JDBC 연동 - DriverManager.getConnection
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
          //3. PreparedStatement pstmt 이용해서 users 테이블의 데이터가져오기 - 가격이 낮은순으로 
          pstmt = conn.prepareStatement("select * from users");
          
          rset = pstmt.executeQuery(); //표
          while(rset.next()){ //줄
             out.println("<tr><td>"+rset.getString("email")+"</td><td>"                              
                              +rset.getString("pass")+"</td></tr>");
          } 
          //4. JDBC 끊기 
          if(rset  != null){ rset.close();       }
          if(pstmt != null){ pstmt.close();      }
          if(conn  != null){ conn.close();       }
       }catch(Exception e){ e.printStackTrace();                }   */

       	
	
	session.setAttribute("email", email);
	//3. 로그인성공시 - session 설정 (session.setAttribute) / jsp016_login.jsp	페이지로 넘어가기
	session.setAttribute("email", email);
	out.println("<script> location.href='jsp016_login.jsp'; </script>");
%>    
