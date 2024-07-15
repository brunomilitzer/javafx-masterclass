package com.brunomilitzer.mazebank.controllers.client;

import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.models.Transaction;
import com.brunomilitzer.mazebank.views.TransactionsCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {

    public ListView<Transaction> transactions_listview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initAllTransactionsList();
        transactions_listview.setItems(Model.getInstance().getAllTransactions());
        transactions_listview.setCellFactory(e -> new TransactionsCellFactory());
    }

    private void initAllTransactionsList() {
        if (Model.getInstance().getAllTransactions().isEmpty()) {
            Model.getInstance().setAllTransactions();
        }
    }
}
