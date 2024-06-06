module com.brunomilitzer.concurrency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.concurrency to javafx.fxml;
    exports com.brunomilitzer.concurrency;
}