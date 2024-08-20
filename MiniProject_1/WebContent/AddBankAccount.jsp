<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.techlabs.model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Add Bank Account</h1>
        <!-- Search Form -->
        <form action="BankAccountController" method="GET">
            <input type="hidden" name="action" value="searchCustomer">
            <div class="form-group">
                <label for="customerId">Customer ID:</label>
                <input type="text" id="customerId" name="customerId" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>

        <!-- Display Customer Details if Available -->
        <%
            Customer customer = (Customer) request.getAttribute("customer");
            if (customer != null) {
        %>
            <h2>Customer Details</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Customer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%= customer.getCustomerId() %></td>
                        <td><%= customer.getFirstName() %></td>
                        <td><%= customer.getLastName() %></td>
                        <td><%= customer.getEmail() %></td>
                    </tr>
                </tbody>
            </table>
            <!-- Generate Account Number Button -->
            <form action="BankAccountController" method="POST">
                <input type="hidden" name="action" value="generateAccount">
                <input type="hidden" name="customerId" value="<%= customer.getCustomerId() %>">
                <button type="submit" class="btn btn-success">Generate Account Number</button>
            </form>
        <% 
            } else {
        %>
            <p>No customer found with the given ID. Please try again.</p>
        <% 
            } 
        %>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
