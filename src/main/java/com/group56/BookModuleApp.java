package com.group56;

import com.group56.utils.FXMLViewHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class BookModuleApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(false);
        Parent root = FXMLViewHandler.getView("/CoachList.fxml");
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("/BookModuleApp.fxml")));
        stage.setTitle("Fitness Gym");
        stage.setScene(new Scene(root, 800, 600));
//        stage.show();
    }
}
