package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Button bottomRight = new Button("Bottom Right");
        Button topLeft = new Button("Top Left");
        AnchorPane.setBottomAnchor(bottomRight, 10.0);
        AnchorPane.setRightAnchor(bottomRight, 10.0);

        AnchorPane.setTopAnchor(topLeft, 20.0);
        AnchorPane.setLeftAnchor(topLeft, 50.0);

        root.getChildren().addAll(topLeft, bottomRight);

        Scene scene = new Scene(root, 500, 450);

        primaryStage.setTitle("Anchor Pane Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
