<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%
/*	jsp016_logout.jsp	sesson.invalidator()	*/
// jsp016_login.jsp 페이지로 넘어가기
	session.invalidate();	// 로그아웃할때 - 모든 세션의 정보 지우기	
	out.println("<script>	alert('로그아웃 성공!'); location.href='jsp016_login.jsp'; </script>");
%>