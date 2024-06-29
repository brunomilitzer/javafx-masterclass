package com.brunomilitzer.mazebank.controllers.admin;

import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        this.create_client_btn.setOnAction(event -> onCreateClient());
        this.clients_btn.setOnAction(event -> onClients());
        this.deposit_btn.setOnAction(event -> onDeposit());
        this.logout_btn.setOnAction(event -> onLogout());
    }
    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout() {
        // Get Stage
        Stage stage = (Stage) clients_btn.getScene().getWindow();

        // Close the Admin Windows
        Model.getInstance().getViewFactory().closeStage(stage);

        // Show Login Windows
        Model.getInstance().getViewFactory().showLoginWindow();

        // Set Admin Login Success Flag to False
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
