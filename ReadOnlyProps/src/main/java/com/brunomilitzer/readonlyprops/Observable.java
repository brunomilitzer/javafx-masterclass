package com.brunomilitzer.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Observable extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        ObservableList<String> list = FXCollections.observableArrayList("One", "Two", "Three");
        ListView<String> items = new ListView<>();
        TextField field = new TextField();
        Button addButton = new Button("Add");
        items.setItems(list);
        addButton.setOnAction(event -> {
            if (!field.getText().isEmpty()) {
                list.add(field.getText());
            }
        });
        root.getChildren().addAll(items, field, addButton);
        Scene scene = new Scene(root, 550, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Observable");
        primaryStage.show();
    }
}
