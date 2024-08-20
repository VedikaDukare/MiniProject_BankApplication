package com.techlabs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GeneartBankAccountController
 */
@WebServlet("/GeneartBankAccountController")
public class GeneartBankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneartBankAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String customerId = request.getParameter("customerId");

	        // Generate a random account number (you can customize this logic)
	        String accountNo = "AC" + System.currentTimeMillis();

	        CustomerDao customerDao = new CustomerDao();
	        customerDao.updateCustomerAccountNumber(customerId, accountNo);

	        response.getWriter().println("Account number generated and updated for customer ID: " + customerId);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


}
