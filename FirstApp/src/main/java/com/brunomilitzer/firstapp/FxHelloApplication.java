package com.brunomilitzer.firstapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxHelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        //Platform.setImplicitExit(false);
        System.out.println(Thread.currentThread().getName());
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);
        Label text = new Label("");
        Button button = new Button("Click Me!");
        Button block = new Button("Block");
        Button explicitly = new Button("Explicitly");
        button.setOnAction(actionEvent -> text.setText("Welcome to JavaFX Application!"));
        block.setOnAction(actionEvent -> {
            System.out.println("UI now blocked!");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        explicitly.setOnAction(actionEvent -> Platform.exit());

        root.getChildren().addAll(text, button, block, explicitly);

        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Starting Application");
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
    }

    /*@Override
    public void stop() throws Exception {
        System.out.println("Closing the Application");
        System.out.println(Thread.currentThread().getName());
    }*/

    public static void main(String[] args) {
        launch();
    }
}
