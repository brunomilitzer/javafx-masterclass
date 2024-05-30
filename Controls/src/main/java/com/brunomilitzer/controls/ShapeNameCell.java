package com.brunomilitzer.controls;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeNameCell extends ListCell<String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item);
            Shape shape = this.getShape(item);
            setGraphic(shape);
        }
    }

    public Shape getShape(String name) {

        return switch (name.toLowerCase()) {
            case "vanessa" -> new Line(0, 10, 20, 10);
            case "tales" -> new Rectangle(0, 10, 20, 20);
            case "bruno" -> new Circle(20, 20, 10);
            default -> null;
        };
    }
}
