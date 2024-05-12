package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class GroupLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Button one = new Button("One");
        Button two = new Button("Two");
        one.setLayoutX(50);
        one.setLayoutY(50);
        two.layoutXProperty().bind(one.layoutXProperty().add(one.widthProperty().add(10)));
        two.layoutYProperty().bind(one.layoutYProperty());
        group.setEffect(new DropShadow());
        group.setRotate(10);
        group.getChildren().addAll(one, two);

        Scene scene = new Scene(group, 350, 300);
        primaryStage.setTitle("Group Example Layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
