package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ListViewControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label selected = new Label();
        Button selectedFirst = new Button("Select First");

        ListView<String> list = new ListView<>();
        ObservableList<String> names = FXCollections.observableArrayList("Vanessa", "Tales", "Bruno", "Hamlet");
        //list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.getItems().addAll(names);
        //list.getSelectionModel().selectedItemProperty().addListener(observable -> selected.setText(list.getSelectionModel().getSelectedItem()));
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selected.setText(newValue));

        selectedFirst.setOnAction(actionEvent -> list.getSelectionModel().selectFirst());

        root.getChildren().addAll(selected, list, selectedFirst);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ListView Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
