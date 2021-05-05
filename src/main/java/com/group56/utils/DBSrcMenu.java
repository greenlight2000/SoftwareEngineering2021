package com.group56.utils;

public enum DBSrcMenu {
    COACH_JSON("Coach.json"),
    CUSTOMER_JSON("Customer.json"),
    SCHEDULE_JSON("Schedule.json"),
    VIDEO_JSON("Video.json");

    //lib,jar包要放在同级目录, records文件与他们的父文件同级。
    public String basePath = "../records/";///Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/

    private String src;

    DBSrcMenu(String relativeSrc) {
        this.src = basePath + relativeSrc;
    }
    public String getSrc() {
        return src;
    }
}
