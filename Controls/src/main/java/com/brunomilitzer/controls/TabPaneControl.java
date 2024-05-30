package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        TabPane tabPane = new TabPane();
        Tab one = new Tab("One");
        Tab two = new Tab("Two");
        two.setClosable(false);
        VBox contentOne = new VBox();
        contentOne.setAlignment(Pos.CENTER);
        contentOne.getChildren().addAll(new Label("Content for Tab One"));
        VBox contentTwo = new VBox();
        contentTwo.setAlignment(Pos.CENTER);
        contentTwo.getChildren().addAll(new Button("Content Two"));
        one.setContent(contentOne);
        two.setContent(contentTwo);
        tabPane.getTabs().addAll(one, two);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("TabPane Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
