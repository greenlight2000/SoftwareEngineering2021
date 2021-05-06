package com.group56;

import com.group56.utils.FXMLSrcMenu;
import com.group56.utils.FXMLViewHandler;
import com.group56.mediator.ControllerMediator;
import com.group56.mediator.UserModuleCtrlrMediator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserInfoModuleApp extends Application {
    //保护Controller中介者只可读可改，不可重新创建对象
    private static final ControllerMediator cf = new UserModuleCtrlrMediator();
    public static UserModuleCtrlrMediator getCtrlMediator(){return (UserModuleCtrlrMediator) cf;}
    //可读可写，随时重新指定对象
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(false);
        UserInfoModuleApp.primaryStage = stage;
//        primaryStage.setScene(new Scene(new Pane()));
        FXMLViewHandler.putViewInStage(primaryStage, FXMLSrcMenu.USER_FRAMEWORK.getSrc(), "User Module");
//        FXMLViewHandler.putViewInStage(new Stage(), FXMLSrcMenu.USER_ADS.getSrc(), "User Ads");

    }
    public static void main(String[] args) {
        launch();
    }
}
