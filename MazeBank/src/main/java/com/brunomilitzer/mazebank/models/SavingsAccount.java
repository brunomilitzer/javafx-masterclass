package com.brunomilitzer.mazebank.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SavingsAccount extends Account {

    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, Double balance, Double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "withdrawalLimit", withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProperty() {
        return withdrawalLimit;
    }

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }
}
