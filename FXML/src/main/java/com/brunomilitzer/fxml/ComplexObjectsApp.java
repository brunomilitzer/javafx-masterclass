package com.brunomilitzer.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComplexObjectsApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("complexObjects.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 450, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
