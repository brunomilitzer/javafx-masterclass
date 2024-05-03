module com.brunomilitzer.readonlyprops {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.readonlyprops to javafx.fxml;
    exports com.brunomilitzer.readonlyprops;
}