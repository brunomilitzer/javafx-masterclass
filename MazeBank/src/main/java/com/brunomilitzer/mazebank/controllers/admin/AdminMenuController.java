package com.brunomilitzer.mazebank.controllers.admin;

import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.addListeners();
    }

    private void addListeners() {
        create_client_btn.setOnAction(event -> onCreateClient());
        clients_btn.setOnAction(event -> onClients());
    }
    private void onCreateClient() {
        Model.getInstance().getViewFactory().getIsAdminSelectedMenu().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getIsAdminSelectedMenu().set(AdminMenuOptions.CLIENTS);
    }
}
