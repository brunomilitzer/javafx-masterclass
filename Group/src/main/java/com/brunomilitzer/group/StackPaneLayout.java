package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPaneLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle(300, 250);
        rectangle.setFill(Color.LAVENDER);
        Label label = new Label("A Rectangle");
        StackPane.setAlignment(label, Pos.TOP_LEFT);
        stackPane.getChildren().addAll(rectangle, label);

        Scene scene = new Scene(stackPane, 400, 350);
        primaryStage.setTitle("StackPane Layout Example");
         primaryStage.setScene(scene);
         primaryStage.show();
    }
}
