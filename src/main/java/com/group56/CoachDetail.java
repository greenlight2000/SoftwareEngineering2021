package com.group56;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group56.model.entity.Coach;
import com.group56.model.entity.Schedule;
import com.group56.model.tools.jsonFileProcessor;
import com.group56.utils.DBSrcMenu;
import com.group56.utils.FXMLViewHandler;
import com.group56.view.book_module.CoachDetailController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CoachDetail extends Application {

        private int id;
        private String time;
        public void setId(int id) {
            this.id = id;
        }
        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMLViewHandler.class.getResource("/Coach.fxml"));
            Parent root = loader.load();
            CoachDetailController controller=loader.getController();
            String coachID=id+"";

            int[] list=new int[12];
            jsonFileProcessor file = new jsonFileProcessor(DBSrcMenu.SCHEDULE_JSON.getSrc());
            StringBuffer buffer = file.read();
            System.out.println("coachid "+coachID);
            if (!buffer.toString().equals("")) {
                ArrayList<Schedule> schedules = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Schedule>>(){}.getType());
                for (Schedule c : schedules){
                    if(c.getCoachID().equals(coachID))
                        list[Integer.parseInt(c.getTime())]=1;
                }
            }
            for(int i=0;i<12;i++){
                if(list[i]==0)
                    controller.choosebox.getChildren().add(addButton(i,controller));
                else
                    controller.choosebox.getChildren().add(new Button("Booked"));
            }

            jsonFileProcessor file1 = new jsonFileProcessor(DBSrcMenu.COACH_JSON.getSrc());
            StringBuffer buffer1 = file1.read();
            if (!buffer1.toString().equals("")) {
                ArrayList<Coach> records = new Gson().fromJson(buffer1.toString(), new TypeToken<ArrayList<Coach>>(){}.getType());
                System.out.println(records);
                for (Coach c : records) {
                    System.out.println(c);
                    if (c.getCoachID().equals(coachID)) {
                        VBox box = new VBox();
                        box.setMinWidth(20);
                        String string = c.getPicUrl();
                        System.out.println(string);
                        Image image = new Image(string);
                        ImageView pic = new ImageView();
                        pic.setImage(image);
                        pic.setFitHeight(240);
                        pic.setFitWidth(240);
                        controller.coachID = coachID;
                        controller.inforpane.getChildren().add(0, box);
                        controller.inforpane.getChildren().add(1, pic);
                        controller.name.setText(c.getName());
                        controller.gender.setText(c.getSex());
                        controller.tel.setText(c.getTele());
                        controller.infor.setText(c.getDetail());
                        break;
                    }
                }
            }

//            CoachInfor coach=new CoachInfor(id);
            //controller.infor.setText(String.valueOf(id));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        public Button addButton(int i, CoachDetailController c){
            Button btn=new Button(i+"");
            btn.setOnAction((ActionEvent e) -> {
                c.setTime(btn.getText());
            });


            btn.getStyleClass().add("button1");
            return btn;
        }

}
