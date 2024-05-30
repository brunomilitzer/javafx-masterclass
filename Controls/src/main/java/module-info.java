module com.brunomilitzer.controls {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.brunomilitzer.controls to javafx.fxml;
    exports com.brunomilitzer.controls;
}