package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane tilePane = new TilePane(5, 5);
        TilePane tileCenter = createTilePane(Pos.CENTER);
        TilePane tileLeft = createTilePane(Pos.BOTTOM_LEFT);
        HBox root = new HBox(10, tileCenter, tileLeft);

        /*tilePane.setPrefColumns(3);
        tilePane.setTileAlignment(Pos.BOTTOM_LEFT);
        tilePane.getChildren().addAll(
          new Button("Tiles"),
          new Button("are"),
          new Button("Aligned"),
          new Button("at"),
          new Button("CENTER")
        );*/

        Scene scene = new Scene(root);
        System.out.println(root.getWidth());
        primaryStage.setTitle("TilePane Layout Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TilePane createTilePane(Pos tileAlignment) {
        Button[] buttons = new Button[]{
                new Button("Tiles"),
                new Button("are"),
                new Button("Aligned"),
                new Button("at"),
                new Button(tileAlignment.toString())
        };

        TilePane tilePane = new TilePane(5, 5, buttons);
        tilePane.setAlignment(tileAlignment);
        tilePane.setPrefColumns(3);

        return tilePane;
    }
}
