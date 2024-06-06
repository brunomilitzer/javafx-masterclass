package com.brunomilitzer.concurrency;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConcurrencyTask extends Application {

    Button startBtn = new Button("Start");
    Button cancelBtn = new Button("Cancel");
    Button exitBtn = new Button("Exit");

    EvenNumTask task = new EvenNumTask(1, 20, 1000);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        startBtn.setOnAction(e -> {
            Thread bgThread = new Thread(task);
            bgThread.setDaemon(true);
            bgThread.start();
        });

        cancelBtn.setOnAction(e -> task.cancel());
        exitBtn.setOnAction(e -> Platform.exit());

        GridPane pane = new WorkerUI(task);
        HBox box = new HBox(5, startBtn, cancelBtn, exitBtn);

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(box);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
