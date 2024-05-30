package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(save, exit);

        Menu editMenu = new Menu("Edit");
        RadioMenuItem options = new RadioMenuItem("Options");
        RadioMenuItem settings = new RadioMenuItem("Settings");
        Menu preferencesMenu = new Menu("Preferences");
        MenuItem prefOne = new MenuItem("Pref: One");
        MenuItem prefTwo = new MenuItem("Pref: Two");

        editMenu.getItems().addAll(options, settings, new SeparatorMenuItem(), preferencesMenu);
        preferencesMenu.getItems().addAll(prefOne, prefTwo);
        menuBar.getMenus().addAll(fileMenu, editMenu);

        exit.setOnAction(actionEvent -> Platform.exit());

        root.setTop(menuBar);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Menu Button Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
