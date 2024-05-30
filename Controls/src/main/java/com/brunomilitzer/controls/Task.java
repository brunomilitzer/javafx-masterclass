package com.brunomilitzer.controls;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

    private final StringProperty task;

    public Task(String task) {
        this.task = new SimpleStringProperty(this, "task", task);
    }

    public String getTask() {
        return this.task.get();
    }

    public StringProperty getTaskProperty() {
        return this.task;
    }

    @Override
    public String toString() {
        return this.task.get();
    }
}
