package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setFillWidth(true);
        TextArea textArea = new TextArea();
        //VBox.setVgrow(textArea, Priority.ALWAYS);
        VBox.setMargin(textArea, new Insets(0, 10, 0, 10));
        vBox.getChildren().add(textArea);
        Scene scene = new Scene(vBox, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("VBox Layout Example");
        primaryStage.show();
    }
}
