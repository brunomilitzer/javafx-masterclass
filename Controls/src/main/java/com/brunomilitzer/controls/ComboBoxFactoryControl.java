package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxFactoryControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        ComboBox<String> names = new ComboBox<>();
        names.getItems().addAll("Vanessa", "Tales", "Bruno");
        names.setCellFactory(listView -> new ShapeNameCell());
        names.setButtonCell(new ShapeNameCell());
        root.getChildren().add(names);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ComboBox Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
