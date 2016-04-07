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

			boolean statusAdmin = false;
			try {
				statusAdmin = account.checkLoginAdmin(email, password);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if(statusAdmin == true){ 
				session.setAttribute("email", email);
				request.getRequestDispatcher("admin-home.jsp").forward(request, response); 

			} 

			else{
				boolean statusUser = false;
				try {
					statusUser = account.checkLoginUser(email, password);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if(statusUser == true){ 
					String role = "";
					try {
						role = account.checkUserRole(email);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(role.equals("Receptionist")){
						session.setAttribute("email", email);
						request.getRequestDispatcher("reception-home.jsp").forward(request, response); 
					}
					else{
						session.setAttribute("email", email);
						request.getRequestDispatcher("pharmacy-home.jsp").forward(request, response);
					}
				}
				else{
					request.setAttribute("email", email); 
					request.setAttribute("password", password); 
					request.setAttribute("msg", "Invalid Username/Password"); 
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
		}
		if(action.equals("add-user")){
			request.getRequestDispatcher("add-user.jsp").forward(request, response);
		}
		if(action.equals("add-doctor")){
			request.getRequestDispatcher("add-doctor.jsp").forward(request, response);
		}
		if(action.equals("edit-user")){
			request.getRequestDispatcher("edit-user.jsp").forward(request, response);
		}
		if(action.equals("edit-doctor")){
			request.getRequestDispatcher("edit-doctor.jsp").forward(request, response);
		}
		
	}

}
