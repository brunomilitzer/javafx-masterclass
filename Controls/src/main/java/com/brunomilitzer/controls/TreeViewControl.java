package com.brunomilitzer.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TreeViewControl extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        TreeView<String> treeView = new TreeView<>();
        TreeItem<String> classes = new TreeItem<>("Classes");
        TreeItem<String> classOne = new TreeItem<>("Class One");
        TreeItem<String> classTwo = new TreeItem<>("Class Two");
        classOne.getChildren().addAll(
                new TreeItem<>("Vanessa"),
                new TreeItem<>("Tales"),
                new TreeItem<>("Bruno")
        );
        classOne.setExpanded(true);

        classTwo.getChildren().addAll(
                new TreeItem<>("Hamlet")
        );
        classTwo.addEventHandler(TreeItem.branchExpandedEvent(), e -> System.out.println(e.getTreeItem().getValue()));

        classes.getChildren().addAll(classOne, classTwo);
        treeView.setRoot(classes);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
        /*treeView.setCellFactory(tCell -> {
            TreeCell<String> cell = new TreeCell<>() {

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(null);
                    setGraphic(null);

                    if (!empty) {
                        setText(item);
                        if (this.getTreeItem().getValue().equals("Bruno")) {
                            setGraphic(new Rectangle(15, 15, Color.BLUE));
                        } else if (this.getTreeItem().getValue().equals("Hamlet")) {
                            setGraphic(new Rectangle(15, 15, Color.GRAY));
                        }
                    }
                }
            };

            return cell;
        });*/
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
        treeView.setOnEditCommit(e -> e.getTreeItem().setValue(e.getNewValue()));

        root.getChildren().addAll(treeView);
        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("TreeView Control Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
