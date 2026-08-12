<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp"  %>
    
    <section class="container  my-5">
        <h3> 마이페이지 </h3>
<!-- 3. Mypage
> 마이페이지 - Get 
1) 처리서블릿   : MyAction
2) 로그인한정보로 서버에서 해당이메일의 정보가져오기
3) 처리후  mypage.jsp로 사용자 정보 넘겨주기 -->    
                
        <table  class="table  table-striped  table-bordered table-hover">            
<!--             <thead>
                <tr>
                    <th scope="col">닉네임</th>
                    <th scope="col">이메일</th>
                    <th scope="col">휴대폰</th>
                    <th scope="col">가입일</th>
                    <th scope="col">가입IP</th>
                </tr>
            </thead> -->
            <tbody>
            	<tr><th scope="row">닉네임</th>       <td><%=pageContext.getAttribute("name")%></td></tr>
         	    <tr><th scope="row">이메일</th>    <td><%=request.getAttribute("name")%></td></tr>
                <tr><th scope="row">휴대폰</th>    <td><%=session.getAttribute("name")%></td></tr>
                <tr><th scope="row">가입일</th><td><%=application.getAttribute("name")%></td></tr>            
                <tr><th scope="row">가입IP</th><td><%=application.getAttribute("name")%></td></tr>            
            <%@page import="java.sql.*"%>
            <%
            try{
               ///////////////////////////   
               //-1) list.jsp   전체 리스트 출력   select * from   mvcboard1 order bno desc
            Connection conn = null;  PreparedStatement pstmt = null;   ResultSet rset = null;
            //String sql1="select count(*) from   mvcboard1 order by bno desc";            
            //String sql2="select *        from   mvcboard1 order by bno desc";
            
            String sql="select b.* , ( select count(*)  from mvcboard1 ) `cnt` "
                    +" from   mvcboard1 b  order by bno desc";
            String url="jdbc:mysql://localhost:3306/mbasic";   
            String user ="root" , pass="1234";
            
               //1. 드라이버로딩
               Class.forName("com.mysql.cj.jdbc.Driver");
               //2. jdbc연동
               conn = DriverManager.getConnection(url, user, pass);
               //3. sql 구문처리
               pstmt = conn.prepareStatement(sql , ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                          ResultSet.CONCUR_READ_ONLY);
               
               
               
               
               // select:executeQuery / insert, update, delete:executeUpdate    
            rset = pstmt.executeQuery(); //표
            //1) 먼저 전체글 갯수 출력
            int cnt =-1; 
            //      줄
            if(rset.next()){ 
               cnt = rset.getInt("cnt");  //칸
               rset.beforeFirst();        // 다시 처음으로 표부터 처리
            } 
            //2) 
            while(rset.next()) { //줄
               out.println("<tr><td>"                                
                + rset.getString("nickname") +"</td><td>"
                + rset.getString("email") +"</td><td>"
                + rset.getString("mobile") +"</td><td>"
                + rset.getString("udate") +"</td><td>"
                + rset.getString("bip") +"</td></tr>");
            } 
               //4. jdbc끊기
               if(rset != null) {  rset.close();  }
               if(pstmt != null){  pstmt.close();  }
               if(conn != null) {  conn.close();  }
            }catch(Exception e){e.printStackTrace();}
            %>
            </tbody>
        </table>

    </section>

 
<!--    footer       -->
<!--    footer       -->
<%@include file="inc/footer.jsp"  %>