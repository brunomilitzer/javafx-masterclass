package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuButtonControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        MenuButton sites = new MenuButton("Sites");
        MenuItem google = new MenuItem("Google");
        MenuItem youtube = new MenuItem("Youtube");

        google.setOnAction(actionEvent -> System.out.println("Visiting Google.com"));
        youtube.setOnAction(actionEvent -> System.out.println("Visiting Youtube.com"));

        sites.getItems().addAll(google, youtube);
        root.getChildren().addAll(sites);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Menu Button Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
