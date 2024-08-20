package com.techlabs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchCustomerServlet
 */
@WebServlet("/SearchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        String customerId = request.getParameter("customerId");
	        
	        CustomerDao customerDao = new CustomerDao();
	        Customer customer = customerDao.getCustomerById(customerId);

	        if (customer != null) {
	            request.setAttribute("customer", customer);
	            request.getRequestDispatcher("add-bank-account.jsp").forward(request, response);
	        } else {
	            response.getWriter().println("Customer not found!");
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
