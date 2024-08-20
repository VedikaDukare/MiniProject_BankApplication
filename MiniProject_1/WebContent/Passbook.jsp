<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Passbook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <!-- Display error message if available -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">
                <strong>Error:</strong> ${errorMessage}
            </div>
        </c:if>

        <!-- Display success message if available -->
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">
                <strong>Success:</strong> ${successMessage}
            </div>
        </c:if>

        <h2>Transaction History</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Sender Account No</th>
                    <th>Receiver Account No</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.customerId}</td>
                        <td>${transaction.senderAccNo}</td>
                        <td>${transaction.receiverAccNo}</td>
                        <td>${transaction.transactionType}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="PassbookServlet?customerId=${customerId}" class="btn btn-primary">View Passbook</a>
        
    </div>
</body>
</html>
