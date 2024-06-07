module com.brunomilitzer.fxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.fxml to javafx.fxml;
    exports com.brunomilitzer.fxml;
}