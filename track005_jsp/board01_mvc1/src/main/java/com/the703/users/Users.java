package com.the703.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Users() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기
	       request.setCharacterEncoding("UTF-8");
	       response.setContentType("text/html; charset=UTF-8");
			
			String nickname = request.getParameter("nickname");
			String bpass    = request.getParameter("bpass");
			String email    = request.getParameter("email");
			String mobile   = request.getParameter("mobile");
			
			//2. sql
			//3. 경로 넘기기
			request.setAttribute("nickname", nickname);
			request.setAttribute("bpass"   , bpass);
			request.setAttribute("email"   , email);
			request.setAttribute("mobile"  , mobile);
			request.getRequestDispatcher("users.jsp").forward(request, response);
	}

}
