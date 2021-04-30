package com.group56.viewmodel.dto;

import com.group56.model.entity.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDTO {
    private StringProperty customerID;
    private StringProperty name;
    private StringProperty goal;
    private StringProperty gender;
    private StringProperty sex;
    private StringProperty age;
    private StringProperty membershipTime;
    private StringProperty height;
    private StringProperty weight;

    public CustomerDTO() {
        this(null, null, null, null, null, null, null, null, null);
    }
    public CustomerDTO(Customer customer){
        this.customerID = new SimpleStringProperty(customer.getCustomerID());
        this.name = new SimpleStringProperty(customer.getName());
        this.goal = new SimpleStringProperty(customer.getGoal());
        this.gender = new SimpleStringProperty(customer.getGender());
        this.sex = new SimpleStringProperty(customer.getSex());
        this.age = new SimpleStringProperty(customer.getAge());
        this.membershipTime = new SimpleStringProperty(customer.getMembershipTime());
        this.height = new SimpleStringProperty(customer.getHeight());
        this.weight = new SimpleStringProperty(customer.getWeight());
    }
    public CustomerDTO(String customerID, String name, String goal, String gender, String sex, String age, String membershipTime, String height, String weight) {
        this.customerID = new SimpleStringProperty(customerID);
        this.name = new SimpleStringProperty(name);
        this.goal = new SimpleStringProperty(goal);
        this.gender = new SimpleStringProperty(gender);
        this.sex = new SimpleStringProperty(sex);
        this.age = new SimpleStringProperty(age);
        this.membershipTime = new SimpleStringProperty(membershipTime);
        this.height = new SimpleStringProperty(height);
        this.weight = new SimpleStringProperty(weight);
    }
    //更新DTO对象，而不是创建新对象
    public void update(Customer customer){
        this.customerID.set(customer.getCustomerID());
        this.name.set(customer.getName());
        this.goal.set(customer.getGoal());
        this.gender.set(customer.getGender());
        this.sex.set(customer.getSex());
        this.age.set(customer.getAge());
        this.membershipTime.set(customer.getMembershipTime());
        this.height.set(customer.getHeight());
        this.weight.set(customer.getWeight());
    }
    public Customer parse(){
        Customer customer = new Customer();
        customer.setCustomerID(this.customerID.get());
        customer.setName(this.name.get());
        customer.setGoal(this.goal.get());
        customer.setGoal(this.goal.get());
        customer.setGender(this.gender.get());
        customer.setSex(this.sex.get());
        customer.setAge(this.age.get());
        customer.setMembershipTime(this.membershipTime.get());
        customer.setHeight(this.height.get());
        customer.setWeight(this.weight.get());
        return customer;
    }
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerID=" + customerID.get() +
                ", name=" + name.get() +
                ", goal=" + goal.get() +
                ", gender=" + gender.get() +
                ", sex=" + sex.get() +
                ", age=" + age.get() +
                ", membershipTime=" + membershipTime.get() +
                ", height=" + height.get() +
                ", weight=" + weight.get() +
                '}';
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCustomerID() {
        return customerID.get();
    }

    public StringProperty customerIDProperty() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID.set(customerID);
    }

    public String getGoal() {
        return goal.get();
    }

    public StringProperty goalProperty() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal.set(goal);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getMembershipTime() {
        return membershipTime.get();
    }

    public StringProperty membershipTimeProperty() {
        return membershipTime;
    }

    public void setMembershipTime(String membershipTime) {
        this.membershipTime.set(membershipTime);
    }

    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public String getWeight() {
        return weight.get();
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }
}
