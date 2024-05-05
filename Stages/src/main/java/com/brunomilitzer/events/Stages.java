package com.brunomilitzer.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stages extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Label label = new Label("This is a label");
        Button button = new Button("Click Me!");
        root.getChildren().addAll(label, button);
        //button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> label.setText("Thank you for clicking the button!"));
        //button.setOnAction(mouseEvent -> label.setText("Thank you for clicking the button!"));
        //button.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> label.setText("Thank you for clicking the button!"));
        //root.addEventFilter(MouseEvent.MOUSE_CLICKED, Event::consume);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("Event at the root!"));
        Scene scene = new Scene(root, 500, 450);
        //scene.setOnMouseMoved(mouseEvent -> label.setText("X: " + mouseEvent.getX() + " Y: " + mouseEvent.getY()));
        scene.setOnKeyPressed(keyEvent -> label.setText(keyEvent.getText()));
        stage.setScene(scene);
        stage.setOnShowing(windowEvent -> System.out.println("Stage is showing"));
        stage.setTitle("Events");
        stage.show();
    }
}
