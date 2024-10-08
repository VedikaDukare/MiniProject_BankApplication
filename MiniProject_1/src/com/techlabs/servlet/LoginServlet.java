package com.techlabs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String role = request.getParameter("role");
	        System.out.println(username);
	       
	            if (username.equalsIgnoreCase("admin")&& password.equals("admin") && role.equalsIgnoreCase("Admin")) {
	                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
	                dispatcher.forward(request, response);
	            } else if ("customer".equals(username) && "customerpass".equals(password) && "Customer".equals(role)) {
	                RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerDashboard.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                response.sendRedirect("login.jsp?error=Invalid credentials or role");
	            }
	        } 
	    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
