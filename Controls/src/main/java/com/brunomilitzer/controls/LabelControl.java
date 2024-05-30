package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LabelControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Hello World!");
        Rectangle rectangle = new Rectangle(20, 20, Color.RED);
        label.setGraphic(rectangle);
        label.setUnderline(true);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        label.setTextFill(Color.GREEN);

        root.getChildren().addAll(label);
        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Label Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
