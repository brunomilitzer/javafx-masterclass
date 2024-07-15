package com.brunomilitzer.mazebank.controllers.admin;

import com.brunomilitzer.mazebank.models.Client;
import com.brunomilitzer.mazebank.models.Model;
import com.brunomilitzer.mazebank.views.ClientCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {

    public ListView<Client> clients_listview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClientsList();
        clients_listview.setItems(Model.getInstance().getClients());
        clients_listview.setCellFactory(param -> new ClientCellFactory());
    }

    private void initClientsList() {
        if (Model.getInstance().getClients().isEmpty()) {
            Model.getInstance().setClients();
        }
    }
}
