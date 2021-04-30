package com.group56.model.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.ToString;

@ToString
public class Coach {
    private final StringProperty coachID;
    private final StringProperty gender;
    private final StringProperty sex;
    private final StringProperty picUrl;
    private final StringProperty tele;
    private final StringProperty detail;



    //constructor
    public Coach() {this(null,null,null,null,null,null);}
    public Coach(String coachID, String gender, String sex, String picUrl, String tele, String detail) {
        this.coachID = new SimpleStringProperty(coachID);
        this.gender = new SimpleStringProperty(gender);
        this.sex = new SimpleStringProperty(sex);
        this.picUrl = new SimpleStringProperty(picUrl);
        this.tele = new SimpleStringProperty(tele);
        this.detail = new SimpleStringProperty(detail);
    }

    //getter
    public String getCoachID() {
        return coachID.get();
    }

    public StringProperty coachIDProperty() {
        return coachID;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public String getPicUrl() {
        return picUrl.get();
    }

    public StringProperty picUrlProperty() {
        return picUrl;
    }

    public String getTele() {
        return tele.get();
    }

    public StringProperty teleProperty() {
        return tele;
    }

    public String getDetail() {
        return detail.get();
    }

    public StringProperty detailProperty() {
        return detail;
    }
    //setter
    public void setCoachID(String coachID) {
        this.coachID.set(coachID);
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public void setPicUrl(String picUrl) {
        this.picUrl.set(picUrl);
    }

    public void setTele(String tele) {
        this.tele.set(tele);
    }

    public void setDetail(String detail) {
        this.detail.set(detail);
    }
}
