package com.techlabs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {
    private Connection connection = null;   
    private Statement statement = null;
    private PreparedStatement preparedStatement = null; 

    public void connectToDb() {
        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");	        	
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "root");           
            statement = connection.createStatement();            
            System.out.println("Connected successfully..");
        } catch (ClassNotFoundException | SQLException e) {            
            e.printStackTrace();
        }   
    }

    public Statement getStatement() {  
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement; 
    }

    public PreparedStatement getPreparedStatement() {  
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeResources() {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

