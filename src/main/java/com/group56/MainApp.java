package com.group56;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainApp extends Application {
    public static String customerId="1";

    public static Stage customerInfoStage;
    public static Stage videoStage;
    @Override
    public void start(Stage stage) throws Exception {
        //启动UserInfo模块
        customerInfoStage = stage;
        new UserInfoModuleApp().start(customerInfoStage);
        customerInfoStage.show();
        //启动xxx模块
        videoStage = new Stage();
        new MoreModuleApp().start(videoStage);
        customerInfoStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                videoStage.show();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
