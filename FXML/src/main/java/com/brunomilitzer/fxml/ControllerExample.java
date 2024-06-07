package com.brunomilitzer.fxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerExample implements Initializable {

    @FXML
    public Label count_lbl;

    public int count;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = 0;
        count_lbl.setText("Count: " + count);
    }

    @FXML
    public void onIncrement() {
        count++;
        count_lbl.setText("Count: " + count);
    }
}
