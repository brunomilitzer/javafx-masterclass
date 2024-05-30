package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Name Selected:");

        ComboBox<String> names = new ComboBox<>();
        names.setPromptText("Select a Name");
        names.setEditable(true);
        ObservableList<String> nameList = FXCollections.observableArrayList("Bruno", "Vanessa", "Tales");
        names.getItems().addAll(nameList);
        names.getSelectionModel().selectedItemProperty()
                .addListener(observable -> label.setText("Name Selected: " + names.getSelectionModel().getSelectedItem()));

        root.getChildren().addAll(label, names);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ComboBox Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
