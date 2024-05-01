module com.brunomilitzer.firstapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.firstapp to javafx.fxml;
    exports com.brunomilitzer.firstapp;
}