package com.group56;

import com.group56.utils.FXMLSrcMenu;
import com.group56.utils.FXMLViewHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ScheduleModuleApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("/ScheduleModuleApp.fxml")));
        Parent root = FXMLViewHandler.getView(FXMLSrcMenu.SCHEDULE_LIST.getSrc());
        stage.setTitle("Fitness Gym");
        stage.setScene(new Scene(root, 800, 600));
    }
}
