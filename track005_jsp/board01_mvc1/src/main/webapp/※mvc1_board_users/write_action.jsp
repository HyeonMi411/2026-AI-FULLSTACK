<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<% //1. 데이터 넘겨받기	- bname, bpass, btitle, bcontent / bip - InetAddress .getLocalHost().getHostAddress()
   	request.setCharacterEncoding("UTF-8");
   	String bname = request.getParameter("bname");
   	String bpass = request.getParameter("bpass");
   	String btitle = request.getParameter("btitle");
   	String bcontent = request.getParameter("bcontent");	//out.println(bname + "/" + bpass + "/" + btitle + "/" + bcontent);   	
//2. sql처리
   	try{ //-1) list.jsp    전체 리스트 출력	select * from mvcboard1 order bno desc
   		Connection conn = null; PreparedStatement pstmt = null;		//ResultSet rset = null;
   		String sql = "insert into mvcboard1 (bname , bpass , btitle ,bcontent , bip)  values  (?,?,?,?,?)";
   		String url  = "jdbc:mysql://localhost:3306/mbasic";
   		String user = "root"	, pass="1234";
   		
   		Class.forName("com.mysql.cj.jdbc.Driver");				//1. 드라이버로딩
   		conn = DriverManager.getConnection(url , user , pass);	//2. jdbc연동   		
   		pstmt = conn.prepareStatement(sql);
   		pstmt.setString( 1   , bname);
   		pstmt.setString( 2   , bpass);
   		pstmt.setString( 3   , btitle);
   		pstmt.setString( 4   , bcontent);
   		pstmt.setString( 5   , InetAddress.getLocalHost().getHostAddress());	//Ip 주소가져오기   		
   		//int result = pstmt.executeUpdate();		// insert, update, delete 실행한 줄 수   		
   		if (pstmt.executeUpdate() > 0) {//4. 처리후 성공알림창 후 list.jsp 로 				주소표시창줄
   			out.println("<script> alert('글쓰기 성공했습니다.');  location.href='list.jsp';	</script>");
   		}else{ out.println("<script> alert('관리자에게 문의해주세요!');  location.href='list.jsp';	</script>"); }
   		//5. jdbc끊기 if (rset != null) { rset.close(); }
   		if (pstmt != null) { pstmt.close(); }
   		if (conn != null) { conn.close(); }
   	} catch (Exception e) { e.printStackTrace(); }
   %>    

<!-- 
//1. utf-8 설정
//2. request.getParameter() 이용해서 데이터 받기
//3. insert 구문처리
//4. list.jsp 로 돌아가기
 -->


