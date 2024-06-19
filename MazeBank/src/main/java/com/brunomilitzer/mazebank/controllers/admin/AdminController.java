package com.brunomilitzer.mazebank.controllers.admin;

import com.brunomilitzer.mazebank.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getIsAdminSelectedMenu().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
            }
        });
    }
}
