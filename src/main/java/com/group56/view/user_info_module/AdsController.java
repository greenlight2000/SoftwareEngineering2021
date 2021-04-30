package com.group56.view.user_info_module;

import com.group56.MainApp;
import com.group56.UserInfoModuleApp;
import com.group56.utils.FXMLViewHandler;

import com.group56.utils.FXMLSrcMenu;
import com.group56.view.FrameworkController;
import com.group56.view.ViewController;
import com.group56.viewmodel.UserInfoViewModel;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdsController implements ViewController {
    @FXML
    private Pane view;
    UserInfoViewModel userInfoViewModel = UserInfoViewModel.getInstance(MainApp.customerId);

    public void toUserModifyView() throws IOException {
//        FXMLViewHandler.putViewInPane(com.group56.UserInfoModuleApp.getCtrlMediator().getUserModuleFrameWork().getContentPane(), com.group56.UserInfoModuleApp.getCtrlMediator().getUserInfoModifyController().getView());
        FXMLViewHandler.putViewInPane(((FrameworkController) UserInfoModuleApp.getCtrlMediator().getController(FXMLSrcMenu.USER_FRAMEWORK.getSrc())).getContentPane(), UserInfoModuleApp.getCtrlMediator().getController(FXMLSrcMenu.USER_INFO_MODIFY.getSrc()).getView());
    }
    public void onClickModifyBtn(MouseEvent mouseEvent) throws IOException {
        userInfoViewModel.updateFromModel();
        toUserModifyView();
//        MainApp.customerInfoStage.hide();
//        com.group56.MoreModuleApp.primaryStage.show();
    }

    @Override
    public void registerToMediator() {
        UserInfoModuleApp.getCtrlMediator().registerController(FXMLSrcMenu.USER_ADS.getSrc(),this);
    }

    @Override
    public Parent getView() {
        return view;
    }
}
