package com.group56.view.book_module;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group56.MainApp;
import com.group56.model.entity.Schedule;
import com.group56.model.tools.jsonFileProcessor;
import com.group56.utils.DBSrcMenu;
import com.group56.utils.FXMLSrcMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CoachDetailController implements Initializable {
    private String time="Booked";
    public  String coachID;
    @FXML
    public Label name;
    public Label gender;
    public Label tel;
    public Label infor;
    public Button book_button;
    public Button video_button;
    public HBox choosebox;
    public FlowPane inforpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void submit(Event event) throws IOException {
        if(time.equals("Booked")) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"this time slot is not available",ButtonType.CANCEL);
            alert.show();
        }else{
            jsonFileProcessor file = new jsonFileProcessor(DBSrcMenu.SCHEDULE_JSON.getSrc());
            StringBuffer buffer = file.read();
            if (!buffer.toString().equals("")) {
                ArrayList<Schedule> records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Schedule>>() {}.getType());
                Schedule news=new Schedule();
                news.setCoachID(coachID);
                news.setCustomerID(MainApp.customerId);
                news.setScheduleID((records.size()+1)+"");
                news.setTime(time);
                news.setDate("2021 5 1");
                records.add(news);
                file.rewrite(records);
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"successful booking");
            alert.show();
            MainApp.showPrimaryStage(MainApp.scheduleListStage);
//            Stage newstage = new Stage();
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("/VideoPage.fxml")));
//            newstage.setScene(new Scene(root, 400, 200));
//            newstage.showAndWait();
        }
    }
    public void setTime(String time){
        this.time=time;
    }

    public void video(){
        video_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Platform.runLater(()->{
//                    Stage primaryStage=(Stage)video_button.getScene().getWindow();
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
