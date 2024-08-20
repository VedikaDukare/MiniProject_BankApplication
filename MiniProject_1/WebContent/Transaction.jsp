<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.techlabs.servlet.Transaction" %>
<%@ page import="com.techlabs.servlet.TransactionDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Transactions</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Transaction List</h2>
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer ID</th>
                    <th>Amount</th>
                    <th>Transaction Type</th>
                    <th>Sender Account No</th>
                    <th>Receiver Account No</th>
                    <th>Transaction Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                	TransactionDao transactionDb = new TransactionDao();
                                    List<Transaction> transactions = transactionDb.getAllTransactions();
                                    
                                    if (transactions != null && !transactions.isEmpty()) {
                                        for (Transaction transaction : transactions) {
                %>
                    <tr>
                        <td><%= transaction.getId() %></td>
                        <td><%= transaction.getCustomerId() %></td>
                        <td><%= transaction.getAmount() %></td>
                        <td><%= transaction.getTransactionType() %></td>
                        <td><%= transaction.getSenderAccNo() %></td>
                        <td><%= transaction.getReceiverAccNo() %></td>
                        <td><%= transaction.getTransactionDate() %></td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7" class="text-center">No transactions found</td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
