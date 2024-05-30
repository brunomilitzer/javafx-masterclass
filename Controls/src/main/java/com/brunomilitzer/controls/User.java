package com.brunomilitzer.controls;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {

    private final StringProperty firstName;

    private final StringProperty lastName;

    private final ObjectProperty<LocalDate> birthDate;

    public User(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = new SimpleStringProperty(this, "firstName", firstName);
        this.lastName = new SimpleStringProperty(this, "lastName", lastName);
        this.birthDate = new SimpleObjectProperty<>(this, "birthDate", birthDate);
    }

    public String getFirstName() {
        return this.firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return this.lastName.get();
    }

    public LocalDate getBirthDate() {
        return this.birthDate.get();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate.set(birthDate);
    }

    @Override
    public String toString() {
        return this.getFirstName() + "  " + this.getLastName() + " " + this.getBirthDate();
    }
}
