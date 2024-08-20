package com.techlabs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.techlabs.servlet.Customer;
import com.techlabs.servlet.CustomerDao;

@WebServlet("/BankAccountController")
public class BankAccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addCustomer".equals(action)) {
            addCustomer(request, response);
        } else if ("generateAccount".equals(action)) {
            generateAccountNumber(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("searchCustomer".equals(action)) {
            searchCustomer(request, response);
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(firstName, lastName, email, password);

        response.sendRedirect("AddBankAccount.jsp");
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");

        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(customerId);

        if (customer != null) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("AddBankAccount.jsp").forward(request, response);
        } else {
            response.getWriter().println("Customer not found!");
        }
    }

    private void generateAccountNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");

        // Generate a random account number (customize this logic as needed)
        String accountNo = "AC" + System.currentTimeMillis();

        CustomerDao customerDao = new CustomerDao();
        customerDao.updateCustomerAccountNumber(customerId, accountNo);

        response.getWriter().println("Account number generated and updated for customer ID: " + customerId);
    }
}

