package com.group56;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MoreModuleApp extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Button button = new Button("button");
        button.setOnAction(e -> {
            MainApp.customerInfoStage.show();
            MainApp.videoStage.hide();
        });
        Pane pane = new Pane();
        pane.getChildren().setAll(button);
        primaryStage.setScene(new Scene(pane));
    }

    public static void main(String[] args) {

    }
}
