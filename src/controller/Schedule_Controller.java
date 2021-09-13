package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Schedule_Controller {
    public Label lblDate;
    public Label lblTime;

    public void initialize() {
        loadDateAndTime();
    }


    private void loadDateAndTime() {

        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String date = f.format(new Date());
        lblDate.setText(date);


        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

}
