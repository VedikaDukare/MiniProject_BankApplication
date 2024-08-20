package com.techlabs.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "root");
    }

    public List<Transaction> getAllTransactions(String customerId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT customerId, senderAccNo, receiverAccNo, transactionType, amount, date FROM transactions WHERE senderAccNo = ? OR receiverAccNo = ? ORDER BY date DESC";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customerId);
            ps.setString(2, customerId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setCustomerId(rs.getString("customerId"));
                    transaction.setSenderAccNo(rs.getString("senderAccNo"));
                    transaction.setReceiverAccNo(rs.getString("receiverAccNo"));
                    transaction.setTransactionType(rs.getString("transactionType"));
                    transaction.setAmount(rs.getDouble("amount"));
                    transaction.setDate(rs.getDate("date"));
                    transactions.add(transaction);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
