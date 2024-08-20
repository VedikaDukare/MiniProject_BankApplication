package com.techlabs.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PassbookServlet")
public class PassbookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String customerId = request.getParameter("customerId");

        // Print the customer ID to the console for debugging
        System.out.println("Customer ID: " + customerId);

        // Check if customer ID is null or empty
        if (customerId == null || customerId.isEmpty()) {
            request.setAttribute("errorMessage", "Customer ID is required.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Create an instance of TransactionDao to fetch transactions
        TransactionDao transactionDao = new TransactionDao();
        List<Transaction> transactions = transactionDao.getAllTransactions(customerId);

        // Check if transactions list is empty and set error message if needed
        if (transactions.isEmpty()) {
            request.setAttribute("errorMessage", "No transactions found for the provided customer ID.");
        }

        // Set the transactions list as a request attribute and forward to Passbook.jsp
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("Passbook.jsp").forward(request, response);
    }
}
