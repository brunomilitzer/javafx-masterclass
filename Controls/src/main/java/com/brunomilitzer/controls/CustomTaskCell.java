package com.brunomilitzer.controls;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CustomTaskCell extends ListCell<Task> {

    @Override
    protected void updateItem(Task item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            CheckBox check = new CheckBox();
            Text text = new Text(item.getTask());
            HBox cell = new HBox(10, check, text);

            check.selectedProperty().addListener(observable -> text.setStrikethrough(check.isSelected()));
            setText(null);
            setGraphic(cell);
        }
    }
}
