<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('images/bank-background.png'); /* Update the path if necessary */
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .dashboard-container {
            background-color: rgba(255, 255, 255, 0.8); /* Slightly transparent white background */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            width: 300px;
            text-align: center;
        }
        .dashboard-container h1 {
            margin-bottom: 30px;
        }
        .dashboard-btn {
            width: 100%;
            margin-bottom: 15px;
            background-color: #b3e5fc;
            color: #000;
            border: none;
        }
        .dashboard-btn:hover {
            background-color: #81d4fa;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>
        <a href="AddNewController" class="btn dashboard-btn">Add New Customer</a>
        <a href="ViewController" class="btn dashboard-btn">View Customers</a>
        <a href="TransactionController.jsp" class="btn dashboard-btn">View Transactions</a>
    </div>
</body>
</html>
