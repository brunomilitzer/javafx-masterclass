package com.brunomilitzer.group;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class TextFlowLayout extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextFlow root = new TextFlow();
        Text heading = new Text("Lorem ipsum");
        heading.setFill(Color.BLUE);
        heading.setFont(Font.font("Aria", FontWeight.BOLD, 18));
        Text paragraph = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "\nMaecenas posuere pellentesque euismod. Proin porta lectus orci, sit amet eleifend " +
                "\nelit viverra eget. Ut iaculis est id felis tempor, quis iaculis dolor volutpat. " +
                "\nDuis venenatis lorem enim, vel egestas leo mattis sed. Fusce ornare, odio a " +
                "\ndictum rutrum, risus sapien interdum ex, et dignissim dolor dui id mi. Vestibulum " +
                "\nsagittis urna ut nisi lobortis, in dignissim tortor convallis. " +
                "\nNulla pharetra feugiat ante sed tincidunt.");

        root.setLineSpacing(5);
        root.setTextAlignment(TextAlignment.CENTER);
        root.setPrefWidth(300);
        root.getChildren().addAll(heading, paragraph);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Flow Layout");
        primaryStage.show();

    }
}
