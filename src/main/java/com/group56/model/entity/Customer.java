package com.group56.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    String customerID;
    String name;//新增属性
    String goal;
    String gender;
    String sex;
    String age;
    String membershipTime;//新增属性
    String height;
    String weight;
}
