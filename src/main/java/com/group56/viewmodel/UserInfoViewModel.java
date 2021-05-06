package com.group56.viewmodel;
import javafx.scene.media.Media;
import com.group56.MainApp;
import com.group56.model.dao.Impl.CustomerDAOImpl;
import com.group56.viewmodel.dto.CustomerDTO;
import lombok.NonNull;
import com.group56.model.dao.CustomerDAO;
import com.group56.model.entity.Customer;

//单例VM
public class UserInfoViewModel implements ViewModel{
    private static UserInfoViewModel userInfoViewModel;
    public static UserInfoViewModel getInstance(@NonNull String customerId){
        if(userInfoViewModel == null || !userInfoViewModel.customerDTO.getCustomerID().equals(customerId))
            userInfoViewModel = new UserInfoViewModel(customerId);
        return userInfoViewModel;
    }
    private CustomerDTO customerDTO;
    //TODO:最好再封一层service放这，目的是保护一些不可写的参数如membershipTime
    private final CustomerDAO dao = new CustomerDAOImpl();

    public UserInfoViewModel(String customerId) {
        Customer customer = dao.selectByID(customerId);
        this.customerDTO = new CustomerDTO(customer);
    }
    public void updateToModel(){
        dao.update(customerDTO.parse(), MainApp.customerId);
    }
    public void updateFromModel(){
        Customer customer = dao.selectByID(customerDTO.getCustomerID());
        this.customerDTO.update(customer);
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
    public void printData(){
        System.out.println(customerDTO.toString());
    }
}
