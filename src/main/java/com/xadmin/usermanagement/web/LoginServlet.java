package com.xadmin.usermanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.bean.LoginBean;


@WebServlet({ "/LoginServlet","/userlogin"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		  if ("Admin".equals(username) && "A@123".equals(password)) {
		     
		        request.getSession().setAttribute("username", username);
		        
		        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
		    } else {
		        request.setAttribute("error", "Incorrect username or password");
		        
		        request.getRequestDispatcher("Login.jsp").forward(request, response);
		    }
		}

	private boolean authenticate(String username, String password) {
		
		return true;
	}

}
