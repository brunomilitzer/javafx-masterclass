package com.brunomilitzer.mazebank.models;

import java.sql.*;

public class DatabaseDriver {

    private Connection connection;

    public DatabaseDriver() {

        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:./MazeBank/mazebank.db");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /*
     * Client Section
     */
    public ResultSet getClientData(String pAddress, String password) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM Clients WHERE PayeeAddress = ? AND Password = ?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, pAddress);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
     * Admin Section
     */
    public ResultSet getAdminData(String username, String password) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM Admins WHERE Username = ? AND Password = ?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
     * Utility Methods
     */
}
