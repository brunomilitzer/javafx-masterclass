package com.brunomilitzer.mazebank.controllers;

import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        login_btn.setOnAction(event -> this.onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            Model.getInstance().getViewFactory().showClientWindows();
        } else {
            Model.getInstance().getViewFactory().showAdminWindows();
        }
    }
}
