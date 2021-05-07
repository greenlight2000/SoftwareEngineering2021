package com.group56.view.book_module;


import com.group56.CoachDetail;
import com.group56.MainApp;
import com.group56.model.dao.Impl.CoachDAOImpl;
import com.group56.model.entity.Coach;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CoachListController implements Initializable {

    @FXML private VBox list;

    @FXML private Button video_button;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Coach coach;
        int i=1;
        int num=1;
        CoachDAOImpl coachDAO= new CoachDAOImpl();
        while (true){
            coach = coachDAO.selectByID(String.valueOf(i++));
            if (coach != null)
                list.getChildren().add(addCoach(coach,num));
            else
                break;
            num++;
        }
    }


    @FXML
    public Pane addCoach(Coach coach, int num){
        Pane pane=new Pane();
        Image image=new Image(coach.getPicUrl());
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(160);
        imageView.setFitWidth(240);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Platform.runLater(()->{
                    Stage primaryStage=(Stage)imageView.getScene().getWindow();
                    primaryStage.hide();
                    try{
                        CoachDetail coachDetail =new CoachDetail();
                        coachDetail.setId(num);
                        coachDetail.start(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        Label label=new Label(coach.getName()+"\n"+coach.getDetail());
        label.setLayoutX(280);
        label.setLayoutY(50);
        pane.getChildren().add(label);
        pane.getChildren().add(imageView);
        return pane;
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
    public void book(){
        MainApp.showPrimaryStage(MainApp.coachListStage);
    }
    public void user(){
        MainApp.showPrimaryStage(MainApp.customerInfoStage);
    }
    public void schedule(){
        MainApp.showPrimaryStage(MainApp.scheduleListStage);
    }
}

