//package com.the703.users;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/MyAction")
//public class MyAction_1 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public MyAction_1() { super();  }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1. 로그인한정보확인
//		//2. sql- 내정보가져오기
//		//3. mypage.jsp 로 경로 넘기기		
//		
//		// 회원가입기능
//		//1. 데이터 넘겨받기
//	       request.setCharacterEncoding("UTF-8");
//	       response.setContentType("text/html; charset=UTF-8");
//			
//			String nickname = request.getParameter("nickname");
//			String bpass    = request.getParameter("bpass");
//			String email    = request.getParameter("email");
//			String mobile   = request.getParameter("mobile");
//			
//			//2. sql (드커프리) 처리			
//		   	try{ //-1) list.jsp    전체 리스트 출력	select * from mvcboard1 order bno desc
//		   		Connection conn = null; PreparedStatement pstmt = null;		//ResultSet rset = null;
//		   		String sql = "insert into mvcboard1 (nickname , bpass , email ,mobile)  values  (?,?,?,?,?)";
//		   		String url  = "jdbc:mysql://localhost:3306/mbasic";
//		   		String user = "root"	, pass="1234";
//		   		
//		   		Class.forName("com.mysql.cj.jdbc.Driver");				//1. 드라이버로딩
//		   		conn = DriverManager.getConnection(url , user , pass);	//2. jdbc연동   		
//		   		pstmt = conn.prepareStatement(sql);
//		   		pstmt.getString( 1   , nickname);
//		   		pstmt.getString( 2   , bpass);
//		   		pstmt.getString( 3   , email);
//		   		pstmt.getString( 4   , mobile);
//		   		//5. jdbc끊기 if (rset != null) { rset.close(); }
//		   		if (pstmt != null) { pstmt.close(); }
//		   		if (conn != null) { conn.close(); }
//		   	} catch (Exception e) { e.printStackTrace(); }			
//			//3. 해당처리화면  - 로그인 폼으로 (LoginAction - Get)
//			request.getAttribute("nickname", nickname);
//			request.getAttribute("bpass"   , bpass);
//			request.getAttribute("email"   , email);
//			request.getAttribute("mobile"  , mobile);
//			request.getRequestDispatcher("LoginAction").forward(request, response);			
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		
//		
//		
//		
//		
//	}
//
//}
