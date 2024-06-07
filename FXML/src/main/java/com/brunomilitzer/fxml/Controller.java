package com.brunomilitzer.fxml;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label message_lbl;
    public Button message_btn;

    private final String message;

    public Controller(String message) {
        this.message = message;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message_btn.setOnAction(event -> message_lbl.setText("Message: " + this.message));
    }
}
