module com.brunomilitzer.stages {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.brunomilitzer.events to javafx.fxml;
    exports com.brunomilitzer.events;
}