package com.group56;

import com.group56.utils.FXMLSrcMenu;
import com.group56.utils.FXMLViewHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainApp extends Application {
    //我们的主程序设置为同一时间屏幕内只显示一个窗口，该窗口被标识为primaryStage
    //MainApp维护多个子模块，给每个模块分配一个stage，要用到时就show，不用的时候hide
    public static Stage primaryStage;
    public static Stage customerInfoStage;
    public static Stage videoStage;
    public static Stage scheduleListStage;

    //存一个全局共享的customer id
    public static String customerId="1";

    @Override
    public void start(Stage stage) throws Exception {
        //启动UserInfo模块
        customerInfoStage = stage;
        new UserInfoModuleApp().start(customerInfoStage);
        scheduleListStage = new Stage();
        new ScheduleModuleApp().start(scheduleListStage);

        MainApp.showPrimaryStage(customerInfoStage);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showPrimaryStage(Stage stage){
        if(primaryStage!=null)
            primaryStage.hide();
        primaryStage = stage;//切换primary
        primaryStage.show();
        //primaryStage点击关闭按钮，整个程序就会退出
        primaryStage.setOnCloseRequest((event)-> Platform.exit());
    }
}
