package com.brunomilitzer.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloWorldFxmlController {

    @FXML
    private Label text;

    public void mouseClicked(MouseEvent event) {
        text.setText("Hello World!");
    }
}
