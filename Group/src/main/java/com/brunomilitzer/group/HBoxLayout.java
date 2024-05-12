package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class HBoxLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setFillHeight(false);
        Label label = new Label("Hello World!");
        TextArea textArea = new TextArea();
        HBox.setHgrow(textArea, Priority.ALWAYS);
        HBox.setMargin(textArea, new Insets(0, 10, 0, 10));
        hBox.getChildren().addAll(label, textArea);
        Scene scene = new Scene(hBox, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBox Layout Example");
        primaryStage.show();
    }
}
