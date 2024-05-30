package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label label = new Label("Your Direction:");

        ChoiceBox<String> directions = new ChoiceBox<>();
        ObservableList<String> directionList = FXCollections.observableArrayList("North", "East", "South", "West");
        directions.setItems(directionList);
        directions.getSelectionModel().select("Directions");
        //directions.getSelectionModel().selectFirst();
        //directions.getSelectionModel().selectLast();
        directions.getSelectionModel().selectedItemProperty()
                .addListener(observable -> label.setText("Your Directions: " + directions.getSelectionModel().getSelectedItem()));

        root.getChildren().addAll(label, directions);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ChoiceBox Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
