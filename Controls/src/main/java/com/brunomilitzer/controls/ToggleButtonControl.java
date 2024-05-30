package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToggleButtonControl extends Application {

    Boolean isLightOnOff;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        isLightOnOff = false;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        ToggleButton light = new ToggleButton("OFF");
        Rectangle rectangle = new Rectangle(200, 100, Color.RED);
        root.getChildren().addAll(rectangle, light);

        light.setOnAction(actionEvent -> {
            isLightOnOff = !isLightOnOff;

            if (isLightOnOff) {
                rectangle.setFill(Color.GREEN);
                light.setText("ON");
            } else {
                rectangle.setFill(Color.RED);
                light.setText("OFF");
            }
        });

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Toggle Button Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
