<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('images/customer-dashboard-background.jpg'); /* Update the path if necessary */
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
            width: 350px;
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
        <h1>Customer Dashboard</h1>
        <a href="PassbookServlet" class="btn dashboard-btn">Passbook</a>
        <a href="NewTransaction.jsp" class="btn dashboard-btn">New Transaction</a>
        <a href="EditProfile.jsp" class="btn dashboard-btn">Edit Profile</a>
    </div>
</body>
</html>
