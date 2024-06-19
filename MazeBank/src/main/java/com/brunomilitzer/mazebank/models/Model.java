package com.brunomilitzer.mazebank.models;

import com.brunomilitzer.mazebank.views.ViewFactory;
import javafx.stage.Stage;

public class Model {

    private static Model instance;
    private final ViewFactory viewFactory;

    private Model () {
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }

        return instance;
    }

    public ViewFactory getViewFactory() {
        return this.viewFactory;
    }
}
