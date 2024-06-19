package com.brunomilitzer.mazebank.controllers.client;

import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(event -> this.onDashboard());
        transaction_btn.setOnAction(event -> this.onTransactions());
        accounts_btn.setOnAction(event -> this.onAccounts());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenu().set(ClientMenuOptions.DASHBOARD);
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenu().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenu().set(ClientMenuOptions.ACCOUNTS);
    }}
