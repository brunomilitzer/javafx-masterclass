package com.brunomilitzer.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserUtility {

    public static ObservableList<User> getUsersList() {
        return FXCollections.observableArrayList(
                new User("Vanessa", "de Garcez", LocalDate.of(1979, 10, 7)),
                new User("Tales", "de Garcez", LocalDate.of(2003, 4, 17)),
                new User("Bruno", "Militzer", LocalDate.of(1978, 10, 8)),
                new User("Hamlet", "Hammy", LocalDate.of(2019, 7, 10))
        );
    }

    public static TableColumn<User, String> getFirstNameColumn() {
        TableColumn<User, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setSortable(false);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(event -> {
            event.getRowValue().setFirstName(event.getNewValue());
            System.out.println(event.getRowValue());
        });

        return firstNameColumn;
    }

    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        return lastNameColumn;
    }

    public static TableColumn<User, LocalDate> getBirthDateColumn() {
        TableColumn<User, LocalDate> birthDateColumn = new TableColumn<>("Birth Date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

        String pattern = "yyyy-MM-dd";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

        LocalDateStringConverter converter = new LocalDateStringConverter(dtf, null);
        birthDateColumn.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        birthDateColumn.setOnEditCommit(event -> {
            event.getRowValue().setBirthDate(event.getNewValue());
            System.out.println(event.getRowValue());
        });

        return birthDateColumn;
    }

    public static TableColumn<User, Button> getDeleteUserColumn() {
        TableColumn<User, Button> deleteUserColumn = new TableColumn<>("Delete");
        deleteUserColumn.setCellFactory(col -> new TableCell<>() {

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                setText(null);
                setGraphic(null);

                if (!empty) {
                    Button deleteButton = new Button("Delete");

                    deleteButton.setOnAction(actionEvent -> {
                        int rowIndex = this.getTableRow().getIndex();
                        this.getTableView().getItems().remove(rowIndex);
                    });

                    setText(null);
                    setGraphic(deleteButton);
                }
            }
        });

        return deleteUserColumn;
    }
}
