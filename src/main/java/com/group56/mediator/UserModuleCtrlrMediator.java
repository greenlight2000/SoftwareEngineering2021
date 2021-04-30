package com.group56.mediator;

import com.group56.utils.FXMLViewHandler;
import com.group56.utils.FXMLSrcMenu;
import com.group56.view.user_info_module.UserInfoController;
import com.group56.view.user_info_module.UserInfoModifyViewController;
import com.group56.view.user_info_module.UserModuleFrameWork;
import com.group56.view.ViewController;

import java.io.IOException;

//中介者模式，单例，方法级工厂
//TODO: 把这个类解耦，拆成一个中介者类和一个单例工厂类，工厂类可以做成抽象工厂（通过反射构建）；这样中介者每个module一个，工厂整个项目可以共用
public class UserModuleCtrlrMediator implements ControllerMediator{
    private UserInfoController userInfoController;
    private UserInfoModifyViewController userInfoModifyController;
    private UserModuleFrameWork userModuleFrameWork;

    public UserInfoController getUserInfoController() {
        return userInfoController;
    }

    public UserInfoModifyViewController getUserInfoModifyController() throws IOException {
        if(userInfoModifyController==null)
            FXMLViewHandler.getView(FXMLSrcMenu.USER_INFO_MODIFY.getSrc());//加载fxml后自动调用controller里的initialize方法，完成注册
        return userInfoModifyController;
    }

    public UserModuleFrameWork getUserModuleFrameWork() {
        return userModuleFrameWork;
    }

    public void registerUserInfoController(ViewController controller){
        userInfoController = (UserInfoController)controller;
    }
    public void registerUserInfoModifyController(ViewController controller){
        userInfoModifyController = (UserInfoModifyViewController)controller;
    }
    public void registerUserModuleFrameWork(ViewController controller) {
        userModuleFrameWork = (UserModuleFrameWork) controller;
    }
}
