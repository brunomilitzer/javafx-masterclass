package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BorderPaneLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        // Left Nodes
        ListView<String> fruitList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Apples");
        items.add("Oranges");
        items.add("Pineapples");

        fruitList.setItems(items);

        // Top Nodes
        Label topLabel = new Label("Fruit List Application");
        topLabel.setPadding(new Insets(10));

        // Bottom Nodes
        Label bottomLabel = new Label("Recently Added Fruit: None");
        bottomLabel.setPadding(new Insets(10));

        // Right Nodes
        Label rightLabel = new Label("Total Number of Fruit Types: " + fruitList.getItems().size());
        rightLabel.setRotate(90);
        rightLabel.setPadding(new Insets(0, 0, 0, 60));

        // Center Nodes
        TextField textField = new TextField();
        Button button = new Button("Add Fruit");

        HBox centerContainer = new HBox(10, textField, button);

        // Setting Border Pane Region
        borderPane.setTop(topLabel);
        borderPane.setRight(rightLabel);
        borderPane.setBottom(bottomLabel);
        borderPane.setLeft(fruitList);
        borderPane.setCenter(centerContainer);

        // Register Event Handler
        button.setOnMouseClicked(mouseEvent -> {
            String item = textField.getText();
            items.add(item);
            bottomLabel.setText("Recently Added Fruit: " + item);
            rightLabel.setText("Total Number of Fruit Types: " + fruitList.getItems().size());
            textField.clear();
        });

        Scene scene = new Scene(borderPane, 700, 650);
        primaryStage.setTitle("BorderPane Example Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
