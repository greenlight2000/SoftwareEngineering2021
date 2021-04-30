package com.group56.view.user_info_module;

import com.group56.UserInfoModuleApp;
import com.group56.utils.FXMLViewHandler;
import com.group56.utils.FXMLSrcMenu;
import com.group56.view.FrameworkController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class UserModuleFrameWork implements FrameworkController {
    @FXML
    private Pane view;
    @FXML
    private Pane navigationPane;
    @FXML
    private Pane contentPane;
    @FXML
    private Pane footerPane;
    @FXML
    private Pane advertisementPane;

    @FXML
    public void initialize() throws IOException {
        registerToMediator();
        FXMLViewHandler.putViewInPane(footerPane, FXMLSrcMenu.FOOTER.getSrc());
        FXMLViewHandler.putViewInPane(contentPane, FXMLSrcMenu.USER_INFO.getSrc());
        FXMLViewHandler.putViewInPane(advertisementPane, FXMLSrcMenu.USER_ADS.getSrc());
    }
    @Override
    public Pane getContentPane() {
        return contentPane;
    }

    @Override
    public Pane getAdsPane() {
        return advertisementPane;
    }

    @Override
    public Pane getNavigatorPane() {
        return navigationPane;
    }

    @Override
    public Pane getFooterPane() {
        return footerPane;
    }

    public void registerToMediator(){
//        com.group56.UserInfoModuleApp.getCtrlMediator().registerUserModuleFrameWork(this);
        UserInfoModuleApp.getCtrlMediator().registerController(FXMLSrcMenu.USER_FRAMEWORK.getSrc(),this);
    }

    @Override
    public Parent getView() {
        return this.view;
    }
}
