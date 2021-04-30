package com.group56.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * FxmlLoader的代理工具类，目前单纯用来节省代码，有需要可以发展成真正意义上的静态代理
 */
public class FXMLViewHandler {
    public static Parent getView(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FXMLViewHandler.class.getResource(fxmlPath));
        return fxmlLoader.load();
    }
    //支持返回fxml node，同时按顺序调用controller里的若干个无参方法
    public static Parent getView(String fxmlPath, String... ctrlMethodsNames) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FXMLViewHandler.class.getResource(fxmlPath));
        Parent viewNode = fxmlLoader.load();
        if(ctrlMethodsNames!=null){
            Class clazz = fxmlLoader.getController().getClass();
            for(String methodName: ctrlMethodsNames){
                clazz.getDeclaredMethod(methodName).invoke(fxmlLoader.getController());
            }
        }
        return viewNode;
    }

    public static void putViewInPane(Pane pane, Node view){
        pane.getChildren().setAll(view);
    }
    public static void putViewInPane(Pane pane, String viewPath) throws IOException {
        pane.getChildren().setAll(getView(viewPath));
    }

    public static void putViewInStage(Stage stage, String viewPath, String title) throws IOException {
        stage.setScene(new Scene(getView(viewPath)));
        stage.setTitle(title);
//        stage.show();
    }

}
