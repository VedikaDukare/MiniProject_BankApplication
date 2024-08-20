package com.techlabs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Customer;

public class CustomerDao extends ConnectionDb {

   
    public boolean addCustomer(Customer customer) {
        PreparedStatement userPreparedStatement = null;
        PreparedStatement customerPreparedStatement = null;
        connectToDb();
        boolean isAdded = false;

        try {
            setPreparedStatement(getConnection().prepareStatement("INSERT INTO user (userName, userPassword, userType) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS));
            getPreparedStatement().setString(1, customer.getFirstName());
            getPreparedStatement().setString(2, customer.getPassword());
            getPreparedStatement().setString(3, "customer");
            getPreparedStatement().executeUpdate();

            ResultSet userdb = getPreparedStatement().getGeneratedKeys();
            int userId = 0;
            if (userdb.next()) {
                userId = userdb.getInt(1);
            }

            setPreparedStatement(getConnection().prepareStatement("INSERT INTO customers (userId, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?)"));
            getPreparedStatement().setInt(1, userId);
            getPreparedStatement().setString(2, customer.getFirstName());
            getPreparedStatement().setString(3, customer.getLastName());
            getPreparedStatement().setString(4, customer.getEmail());
            getPreparedStatement().setString(5, customer.getPassword());

            getPreparedStatement().executeUpdate();
            isAdded = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    
    public List<Customer> getAllCustomers() {
        connectToDb();
        ResultSet dbCustomers = null;
        List<Customer> customers = new ArrayList<>();

        try {
            dbCustomers = getStatement().executeQuery("SELECT customerId, firstName, lastName, email FROM customers ORDER BY customerId DESC");
            while (dbCustomers.next()) {
                int customerId = dbCustomers.getInt("customerId");
                String firstName = dbCustomers.getString("firstName");
                String lastName = dbCustomers.getString("lastName");
                String email = dbCustomers.getString("email");

                Customer customer = new Customer(firstName, lastName, email, null);
                customer.setCustomerId(customerId);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

   
    public Customer getCustomerById(int customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            connectToDb();
            conn = getConnection();

            String sql = "SELECT c.customerId, c.firstName, c.lastName, c.email, c.userId, u.userPassword "
                       + "FROM customers c "
                       + "JOIN user u ON c.userId = u.userId "
                       + "WHERE c.customerId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("customerId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("userPassword");
                int userId = rs.getInt("userId");

                customer = new Customer(firstName, lastName, email, password);
                customer.setCustomerId(id);
                customer.setUserId(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return customer;
    }

  
//    public boolean validatePassword(int userId, String currentPassword) {
//        connectToDb();
//        try {
//            setPreparedStatement(getConnection().prepareStatement("SELECT userPassword FROM user WHERE userId = ?"));
//            getPreparedStatement().setInt(1, userId);
//            ResultSet resultSet = getPreparedStatement().executeQuery();
//
//            if (resultSet.next()) {
//                String storedPassword = resultSet.getString("userPassword");
//                return storedPassword.equals(currentPassword);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//


   
    public boolean isCustomerExists(String email) {
        connectToDb();
        ResultSet rs = null;
        try {
            setPreparedStatement(getConnection().prepareStatement("SELECT email FROM customer WHERE email = ?"));
            getPreparedStatement().setString(1, email);
            rs = getPreparedStatement().executeQuery();
            return rs.next(); // If email exists, rs.next() will return true
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return false;
    }
}
