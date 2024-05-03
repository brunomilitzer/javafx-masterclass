package com.brunomilitzer.readonlyprops;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ReadOnlyIntegerWrapper numWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty num = numWrapper.getReadOnlyProperty();
        System.out.println("NumWrapper: " + numWrapper.get());
        System.out.println("Num: " + num.get());

        numWrapper.set(200);
        System.out.println("NumWrapper: " + numWrapper.get());
        System.out.println("Num: " + num.get());
    }
}
