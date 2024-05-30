package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TableViewControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        TableView<User> usersTables = new TableView<>(UserUtility.getUsersList());
        usersTables.setEditable(true);
        usersTables.getColumns().addAll(
                UserUtility.getFirstNameColumn(),
                UserUtility.getLastNameColumn(),
                UserUtility.getBirthDateColumn(),
                UserUtility.getDeleteUserColumn()
        );

        root.getChildren().addAll(usersTables);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("TableView Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
