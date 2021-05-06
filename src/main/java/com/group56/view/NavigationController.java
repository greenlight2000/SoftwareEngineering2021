package com.group56.view;

import com.group56.UserInfoModuleApp;
import com.group56.utils.FXMLSrcMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NavigationController implements ViewController{
    public Button video_button;
    public Button book_button;
    public Button schedule_button;
    public Button user_button;
    @FXML
    private VBox view;

    @Override
    public void registerToMediator() {
        UserInfoModuleApp.getCtrlMediator().registerController(FXMLSrcMenu.NAVIGATOR.getSrc(),this);
    }

    @Override
    public Parent getView() {
        return view;
    }

    public void clickVideoBtn(ActionEvent actionEvent) {
    }

    public void clickBookBtn(ActionEvent actionEvent) {
    }

    public void clickUserBtn(ActionEvent actionEvent) {
    }

    public void clickScheduleBtn(ActionEvent actionEvent) {
    }
}
