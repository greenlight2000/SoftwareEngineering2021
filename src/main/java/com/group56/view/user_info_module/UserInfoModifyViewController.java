package com.group56.view.user_info_module;

import com.group56.MainApp;
import com.group56.UserInfoModuleApp;
import com.group56.utils.FXMLSrcMenu;
import com.group56.utils.FXMLViewHandler;
import com.group56.view.FrameworkController;
import com.group56.view.ViewController;
import com.group56.viewmodel.UserInfoViewModel;
import com.group56.viewmodel.dto.CustomerDTO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserInfoModifyViewController implements ViewController {
    @FXML
    private Parent view;
    @FXML
    private TextField nameText;
    @FXML
    private TextField ageText;
    @FXML
    private TextField genderText;
    @FXML
    private TextField sexText;
    @FXML
    private TextField weightText;
    @FXML
    private TextField heightText;
    @FXML
    private TextField goalText;
    @FXML
    private Button saveButton;

    UserInfoViewModel vm = UserInfoViewModel.getInstance(MainApp.customerId);

    public void initialize(){
        inject();
        //绑定/获取 原有的user info
        bind();
        registerToMediator();
    }
    @FXML
    private void onClickBtn() throws IOException {
        vm.updateToModel();
        toUserInfoView();
//        MainApp.videoStage.show();
//        MainApp.customerInfoStage.hide();
    }
    public void registerToMediator(){
//        com.group56.UserInfoModuleApp.getCtrlMediator().registerUserInfoModifyController(this);
        UserInfoModuleApp.getCtrlMediator().registerController(FXMLSrcMenu.USER_INFO_MODIFY.getSrc(),this);
    }

    @Override
    public Parent getView() {
        return this.view;
    }

    //把viewmodel层的数据注入view
    public void inject(){
        CustomerDTO customerDTO = vm.getCustomerDTO();
        nameText.setText(customerDTO.getName());
        ageText.setText(customerDTO.getAge());
        genderText.setText(customerDTO.getGender());
        sexText.setText(customerDTO.getSex());
        weightText.setText(customerDTO.getWeight());
        heightText.setText(customerDTO.getHeight());
        goalText.setText(customerDTO.getGoal());

    }
    //绑定view和viewmodel层的data
    public void bind(){
        CustomerDTO customerDTO = vm.getCustomerDTO();
        customerDTO.nameProperty().bindBidirectional(nameText.textProperty());
        customerDTO.ageProperty().bindBidirectional(ageText.textProperty());
        customerDTO.genderProperty().bindBidirectional(genderText.textProperty());
        customerDTO.sexProperty().bindBidirectional(sexText.textProperty());
        customerDTO.weightProperty().bindBidirectional(weightText.textProperty());
        customerDTO.heightProperty().bindBidirectional(heightText.textProperty());
        customerDTO.goalProperty().bindBidirectional(goalText.textProperty());
    }
    private void toUserInfoView() throws IOException {
        //切换页面前更新viewModel中的数据是个好习惯
        vm.updateFromModel();
        //回到userInfo页面
//        FXMLViewHandler.putViewInPane(com.group56.UserInfoModuleApp.getCtrlMediator().getUserModuleFrameWork().getContentPane(), com.group56.UserInfoModuleApp.getCtrlMediator().getUserInfoController().getView());
        FrameworkController frameworkController = (FrameworkController) UserInfoModuleApp.getCtrlMediator().getController(FXMLSrcMenu.USER_FRAMEWORK.getSrc());
        ViewController userInfoController = UserInfoModuleApp.getCtrlMediator().getController(FXMLSrcMenu.USER_INFO.getSrc());

        FXMLViewHandler.putViewInPane(frameworkController.getContentPane(), userInfoController.getView());
    }
}
