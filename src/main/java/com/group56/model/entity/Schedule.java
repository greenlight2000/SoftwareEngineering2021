package com.group56.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Schedule {

    private String scheduleID;
    private String customerID;
    private String coachID;
    private String time;
    private String date;

}
