<%@ page import="com.techlabs.model.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Customer Details</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                    if (customers != null && !customers.isEmpty()) {
                        for (Customer customer : customers) {
                %>
                <tr>
                    <td><%= customer.getCustomerId() %></td>
                    <td><%= customer.getFirstName() %></td>
                    <td><%= customer.getLastName() %></td>
                    <td><%= customer.getEmail() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">No customer found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a href="AdminDashboard.jsp" class="btn btn-primary">Back to Dashboard</a>
    </div>
</body>
</html>

