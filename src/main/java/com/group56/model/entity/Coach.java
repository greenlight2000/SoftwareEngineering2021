package com.group56.model.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Coach {
    private String coachID;
    private String gender;
    private String sex;
    private String picUrl;
    private String tele;
    private String detail;
}
