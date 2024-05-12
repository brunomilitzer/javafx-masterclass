module com.brunomilitzer.group {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.group to javafx.fxml;
    exports com.brunomilitzer.group;
}