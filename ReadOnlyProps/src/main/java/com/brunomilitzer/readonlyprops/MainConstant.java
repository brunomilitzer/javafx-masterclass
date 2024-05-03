package com.brunomilitzer.readonlyprops;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainConstant extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Constant constant = new Constant(100);
        constant.changeConstant();
        System.out.println(constant.getNumWrapper().get());
    }
}
