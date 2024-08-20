<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Transaction</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #d0f0fd; /* Light blue background color */
        }
        .container {
            max-width: 500px;
            margin-top: 50px;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
            color: #007bff;
            text-align: center;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>New Transaction</h2>
        <form id="transactionForm" action="TransactionController" method="post">
            <div class="form-group">
                <label for="transactionType">Transaction Type</label>
                <select class="form-control" id="transactionType" name="transactionType" required onchange="showTransactionDetails()">
                    <option value="">Select transaction type</option>
                    <option value="credit">Credit</option>
                    <option value="debit">Debit</option>
                </select>
            </div>
            <div class="form-group" id="amountGroup" style="display: none;">
                <label for="amount">Amount</label>
                <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter amount" required>
            </div>
            <div class="form-group" id="sourceAccountGroup" style="display: none;">
                <label for="sourceAccount">Source Account</label>
                <input type="text" class="form-control" id="sourceAccount" name="sourceAccount" placeholder="Enter source account number" required>
            </div>
            <div class="form-group" id="destinationAccountGroup" style="display: none;">
                <label for="destinationAccount">Destination Account</label>
                <input type="text" class="form-control" id="destinationAccount" name="destinationAccount" placeholder="Enter destination account number" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
            <button type="reset" class="btn btn-secondary btn-block">Cancel</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function showTransactionDetails() {
            var transactionType = document.getElementById('transactionType').value;
            var amountGroup = document.getElementById('amountGroup');
            var sourceAccountGroup = document.getElementById('sourceAccountGroup');
            var destinationAccountGroup = document.getElementById('destinationAccountGroup');

            if (transactionType === 'credit' || transactionType === 'debit') {
                amountGroup.style.display = 'block';
                sourceAccountGroup.style.display = 'block';
                destinationAccountGroup.style.display = 'block';
            } else {
                amountGroup.style.display = 'none';
                sourceAccountGroup.style.display = 'none';
                destinationAccountGroup.style.display = 'none';
            }
        }
    </script>
</body>
</html>
