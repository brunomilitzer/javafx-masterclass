package com.brunomilitzer.mazebank.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label login_date;
    public Label checking_balance;
    public Label checking_account_num;
    public Label savings_balance;
    public Label savings_account_num;
    public Label income_lbl;
    public Label expense_lbl;
    public ListView transaction_listview;
    public TextField payee_field;
    public TextField amount_field;
    public TextArea message_field;
    public Button send_money_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
