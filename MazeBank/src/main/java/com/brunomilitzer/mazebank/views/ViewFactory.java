package com.brunomilitzer.mazebank.views;

import com.brunomilitzer.mazebank.controllers.admin.AdminController;
import com.brunomilitzer.mazebank.controllers.client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AccountType loginAccountType;

    // Client View
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenu;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    // Admin View
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenu;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositsView;

    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenu = new SimpleObjectProperty<>();
        this.adminSelectedMenu = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return this.loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    /*
     * Client Views Section
     */
    public ObjectProperty<ClientMenuOptions> getClientSelectedMenu() {
        return this.clientSelectedMenu;
    }

    public void showClientWindows() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client/Client.fxml"));
        ClientController controller = new ClientController();
        loader.setController(controller);
        createStage(loader);
    }

    public AnchorPane getDashboardView() {
        if (this.dashboardView == null) {
            try {
                this.dashboardView = new FXMLLoader(getClass().getResource("/fxml/client/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.dashboardView;
    }

    public AnchorPane getTransactionsView() {
        if (this.transactionsView == null) {
            try {
                this.transactionsView = new FXMLLoader(getClass().getResource("/fxml/client/Transactions.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.transactionsView;
    }

    public AnchorPane getAccountsView() {
        if (this.accountsView == null) {
            try {
                this.accountsView = new FXMLLoader(getClass().getResource("/fxml/client/Accounts.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.accountsView;
    }

    /*
     * Admin Views Section
     */
    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenu() {
        return this.adminSelectedMenu;
    }

    public AnchorPane getCreateClientView() {
        if (this.createClientView == null) {
            try {
                this.createClientView = new FXMLLoader(getClass().getResource("/fxml/admin/CreateClient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.createClientView;
    }

    public AnchorPane getClientsView() {
        if (this.clientsView == null) {
            try {
                this.clientsView = new FXMLLoader(getClass().getResource("/fxml/admin/Clients.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.clientsView;
    }

    public AnchorPane getDepositsView() {
        if (this.depositsView == null) {
            try {
                this.depositsView = new FXMLLoader(getClass().getResource("/fxml/admin/Deposit.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return this.depositsView;
    }

    public void showAdminWindows() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;

        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Maze Bank");
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
