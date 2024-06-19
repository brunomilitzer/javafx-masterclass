package com.brunomilitzer.mazebank.controllers.client;

import com.brunomilitzer.mazebank.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getClientSelectedMenu().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case TRANSACTIONS -> this.client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                case ACCOUNTS -> this.client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                default -> this.client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
