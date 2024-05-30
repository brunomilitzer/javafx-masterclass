package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomListViewControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        ListView<Task> taskListView = new ListView<>();
        ObservableList<Task> tasks = FXCollections.observableArrayList(
            new Task("Create Java Project"),
            new Task("Create Bug Report"),
            new Task("Commit changes to repo")
        );

        taskListView.setCellFactory(listView -> new CustomTaskCell());
        taskListView.setItems(tasks);
        root.getChildren().add(taskListView);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ListView Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
