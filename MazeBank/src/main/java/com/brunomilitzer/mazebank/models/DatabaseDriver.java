package com.brunomilitzer.mazebank.models;

import java.sql.*;
import java.time.LocalDate;

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

    public void createClient(String firstName, String lastName, String pAddress, String password, LocalDate date) {
        Statement statement;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO Clients (FirstName, LastName, PayeeAddress, Password, Date) " +
                    "VALUES ('" + firstName+ "', '" + lastName+ "', '" + pAddress + "', '" + password + "', '" + date.toString() + "');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCheckingAccount(String owner, String number, double limit, double balance) {
        Statement statement;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO CheckingAccounts (Owner, AccountNumber, TransactionLimit, Balance) " +
                    "VALUES ('" + owner + "', '" + number + "', '" + limit + "', '" + balance + "');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSavingsAccount(String owner, String number, double limit, double balance) {
        Statement statement;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("INSERT INTO SavingsAccounts (Owner, AccountNumber, WithdrawalLimit, Balance) " +
                    "VALUES ('" + owner + "', '" + number + "', '" + limit + "', '" + balance + "');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllClientsData() {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    /*
     * Utility Methods
     */
    public int getLastClientsId() {
        Statement statement;
        ResultSet resultSet;
        int id = 0;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name='Clients';");
            id = resultSet.getInt("seq");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public ResultSet getCheckingAccountData(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM CheckingAccounts WHERE Owner = '" + pAddress + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet getSavingsAccountData(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner = '" + pAddress + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
