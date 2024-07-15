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

    public ResultSet getTransactions(String pAddress, int limit) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Transactions WHERE Sender = '" + pAddress + "' OR Receiver='" + pAddress + "' LIMIT " + limit + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // Method returns savings account balance
    public double getSavingsAccountBalance(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;
        double balance = 0;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner = '" + pAddress + "';");
            balance = resultSet.getDouble("Balance");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

    // Method to either add or subtract from balance given operation
    public void updateBalance(String pAddress, double amount, String operation) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner = '" + pAddress + "';");
            double newBalance;

            if (operation.equals("ADD")) {
                newBalance = resultSet.getDouble("Balance") + amount;
                statement.executeUpdate("UPDATE SavingsAccounts SET Balance = '" + newBalance + "' WHERE Owner = '" + pAddress + "';");
            } else {
                if (resultSet.getDouble("Balance") > amount) {
                    newBalance = resultSet.getDouble("Balance") - amount;
                    statement.executeUpdate("UPDATE SavingsAccounts SET Balance = '" + newBalance + "' WHERE Owner = '" + pAddress + "';");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Creates add records to transaction
    public void newTransaction(String sender, String receiver, double amount, String message) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            LocalDate date = LocalDate.now();
            statement.executeUpdate("INSERT INTO " +
                    "Transactions(Sender, Receiver, Amount, Date, Message) " +
                    "VALUES ('" + sender + "', '" + receiver + "', '" + amount + "', '" + message + "', );");

        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public void depositSavings(String pAddress, double amount) {
        Statement statement;

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE SavingsAccounts SET Balance = " + amount + " WHERE Owner = '" + pAddress + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Utility Methods
     */
    public ResultSet searchClient(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress = '" + pAddress + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

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
