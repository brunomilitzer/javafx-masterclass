module com.brunomilitzer.mazebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.brunomilitzer.mazebank to javafx.fxml;
    exports com.brunomilitzer.mazebank;
    exports com.brunomilitzer.mazebank.controllers;
    exports com.brunomilitzer.mazebank.controllers.admin;
    exports com.brunomilitzer.mazebank.controllers.client;
    exports com.brunomilitzer.mazebank.models;
    exports com.brunomilitzer.mazebank.views;
}