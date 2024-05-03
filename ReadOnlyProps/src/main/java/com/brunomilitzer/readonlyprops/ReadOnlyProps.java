package com.brunomilitzer.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReadOnlyProps extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Label label = new Label("Welcome");
        TextField textField = new TextField();
        textField.setMaxWidth(200);
        TextField textField1 = new TextField();
        textField1.setMaxWidth(200);
        Button button = new Button("Bind Label to Field");
        //textField.textProperty().addListener((obs, oldVal, newVal) -> label.setText(newVal));
        //label.textProperty().bind(textField.textProperty());
        //textField1.textProperty().bindBidirectional(textField.textProperty());
        //textField1.textProperty().bind(textField.textProperty());
        //label.setText("Hello");
        root.getChildren().addAll(label, textField, button);
        button.setOnAction(event -> label.textProperty().bind(textField.textProperty()));
        Scene scene = new Scene(root, 550, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
