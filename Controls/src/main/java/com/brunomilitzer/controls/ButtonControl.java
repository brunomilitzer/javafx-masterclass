package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButtonControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Button button = new Button("Click Me!");
        Button other = new Button("Other");
        Rectangle rectangle = new Rectangle(20, 20, Color.CYAN);
        other.setGraphic(rectangle);

        root.getChildren().addAll(other, button);
        button.setCancelButton(true);
        button.setOnAction(actionEvent -> {
            System.out.println("Quiting program");
            Platform.exit();
        });
        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Button Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
