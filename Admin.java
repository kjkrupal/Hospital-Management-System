package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Account;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action"); //null
		
		if(action == null){
			request.setAttribute("msg", "");
			request.setAttribute("username", "");
			request.setAttribute("password", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			doPost(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		HttpSession session = request.getSession();
		if(action.equals("login")){
			
			String email = request.getParameter("email"); 
			String password = request.getParameter("password"); 
			
			Account account = new Account(); 

			int status=0;
			try {
				status = account.checkLogin(email, password);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if(status == 3){ 
				session.setAttribute("email", email);
				request.getRequestDispatcher("student-home.jsp").forward(request, response); 

			} 

			else{ 
				request.setAttribute("sid", email); 
				request.setAttribute("password", password); 
				request.setAttribute("msg", "Invalid Username/Password"); 
				request.getRequestDispatcher("login.jsp").forward(request, response); 
			}
			
		}
	}

}
