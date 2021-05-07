package com.group56.view.schedule_module;


import com.group56.MainApp;
import com.group56.ScheduleModuleApp;
import com.group56.model.dao.Impl.ScheduleDAOImpl;
import com.group56.model.entity.Schedule;
import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScheduleListController implements Initializable {

    @FXML
    private VBox list;
    public Button book_button;
    public Button video_button;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user();
        int index=0;
        Schedule schedule;
        String customerID = MainApp.customerId;
        ScheduleDAOImpl scheduleDAO= new ScheduleDAOImpl();
        ArrayList<Schedule> schedules= scheduleDAO.query(customerID,"Customer");
        while (index<schedules.size()){
            schedule = schedules.get(index);
            System.out.println(schedule);
            if (schedule != null)
                list.getChildren().add(addSchedule(schedule,index++));
            else
                break;
        }
    }

    @FXML
    public Pane addSchedule(Schedule schedule,int i){

        Pane pane=new Pane();
        Button delete = new Button("Delete");

        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Platform.runLater(()->{
                    Stage primaryStage=(Stage)pane.getScene().getWindow();
                    primaryStage.hide();
                    new ScheduleDAOImpl().delete(schedule.getScheduleID());
                    try{
                        ScheduleModuleApp scheduleModuleApp =new ScheduleModuleApp();
                        scheduleModuleApp.start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        Label label1=new Label("CoachID: "+schedule.getCoachID());
        Label label2=new Label("Date: "+schedule.getDate());
        Label label3=new Label("Time: "+schedule.getTime());

        delete.setLayoutX(10);
        delete.setLayoutY(20);
        pane.getChildren().add(delete);
        label1.setLayoutX(100);
        label1.setLayoutY(25);
        pane.getChildren().add(label1);
        label2.setLayoutX(220);
        label2.setLayoutY(25);
        pane.getChildren().add(label2);
        label3.setLayoutX(300);
        label3.setLayoutY(25);
        pane.getChildren().add(label3);
        return pane;
    }

    public void video(){
        video_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Platform.runLater(()->{
                    Stage primaryStage=(Stage)video_button.getScene().getWindow();
//                    primaryStage.hide();
//                    try{
//                        VideoList videoList=new VideoList();
//                        videoList.start(primaryStage);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                });
            }
        });
    }
    public void schedule(){
        MainApp.showPrimaryStage(MainApp.scheduleListStage);
    }
    public void book(){
        MainApp.showPrimaryStage(MainApp.coachListStage);
    }
    public void user(){
        MainApp.showPrimaryStage(MainApp.customerInfoStage);
    }
}

