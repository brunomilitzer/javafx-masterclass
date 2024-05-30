package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ComboBoxNodesControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        ComboBox<HBox> names = new ComboBox<>();
        names.getItems().addAll(
                new HBox(new Line(0, 10, 20, 10),
                        new Label("Bruno")),
                new HBox(new Rectangle(0, 0, 20, 20), new Label("Tales")),
                new HBox(new Circle(20, 20, 10), new Label("Vanessa"))
        );

        root.getChildren().add(names);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("ComboBox Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
