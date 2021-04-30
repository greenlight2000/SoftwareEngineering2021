package com.group56.view.user_info_module;

import com.group56.MainApp;
import com.group56.UserInfoModuleApp;
import com.group56.utils.FXMLSrcMenu;

import com.group56.view.ViewController;
import com.group56.viewmodel.UserInfoViewModel;
import com.group56.viewmodel.dto.CustomerDTO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.StringConverter;


public class UserInfoController implements ViewController {
    @FXML
    private Parent view;
    @FXML
    public Label courseNumText;
    @FXML
    public Label membershipDayText;
    @FXML
    public Label goalText;
    @FXML
    public Label nameText;
    @FXML
    public Label ageText;
    @FXML
    public Label genderText;
    @FXML
    public Label weightText;
    @FXML
    public Label heightText;

    UserInfoViewModel vm = UserInfoViewModel.getInstance(MainApp.customerId);

    @FXML
    public void initialize(){
        inject();
        bind();
        registerToMediator();
    }
    @Override
    public void registerToMediator(){
//        com.group56.UserInfoModuleApp.getCtrlMediator().registerUserInfoController(this);
        UserInfoModuleApp.getCtrlMediator().registerController(FXMLSrcMenu.USER_INFO.getSrc(),this);
    }

    @Override
    public Parent getView() {
        return this.view;
    }

    @Override
    //把viewmodel层的数据注入view
    public void inject(){
        CustomerDTO customerDTO = vm.getCustomerDTO();
        nameText.setText(customerDTO.getName());
        ageText.setText(customerDTO.getAge());
        genderText.setText(customerDTO.getGender());
        weightText.setText(customerDTO.getWeight()+"kg");
        heightText.setText(customerDTO.getHeight()+"cm");
        goalText.setText(customerDTO.getGoal());

    }
    @Override
    //绑定view和viewmodel层的data
    public void bind(){
        CustomerDTO customerDTO = vm.getCustomerDTO();
        customerDTO.nameProperty().bindBidirectional(nameText.textProperty());
        customerDTO.ageProperty().bindBidirectional(ageText.textProperty());
        customerDTO.weightProperty().bindBidirectional(weightText.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String s) {//weightProperty -> VM property； s是weightProperty里的string
                return s.substring(0,s.length()-2);
            }
            @Override
            public String fromString(String s) {//VM property -> weightProperty
                return s.concat("kg");
            }
        });
        customerDTO.heightProperty().bindBidirectional(heightText.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String s) {//weightProperty -> VM property； s是weightProperty里的string
                return s.substring(0,s.length()-2);
            }
            @Override
            public String fromString(String s) {//VM property -> weightProperty
                return s.concat("cm");
            }
        });
        customerDTO.goalProperty().bindBidirectional(goalText.textProperty());
    }
}
