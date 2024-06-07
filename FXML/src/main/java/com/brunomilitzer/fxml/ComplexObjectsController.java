package com.brunomilitzer.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ComplexObjectsController {

    @FXML
    public Label selected;

    @FXML
    public Button showSelected;

    @FXML
    public Button selectNext;

    @FXML
    public ListView<Person> listView;

    public void initialize() {
        selected.setText("No Selection");
    }

    public void showSelected() {
        selected.setText(listView.getSelectionModel().getSelectedItem().toString());
    }

    public void selectNext() {
        listView.getSelectionModel().selectNext();
    }
}
