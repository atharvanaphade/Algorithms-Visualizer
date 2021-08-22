package com.alogvis;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

class InputTextField {
    public static TextField tf = new TextField();
    public static Label l = new Label("Enter a Value");

    public Integer Value() {
        if(tf.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(tf.getText());
    }

    public static Group InputBox(double x, double y, double width, double height) {

        Group g = new Group();

        tf.setPrefColumnCount(7);
        tf.setLayoutX(x);
        tf.setLayoutY(y);
        tf.setPrefWidth(width);
        tf.setPrefHeight(height);

        l.setLayoutX(x);
        l.setLayoutY(y + 40);

        Button btn = new Button("Set");
        btn.setLayoutX(x+120);
        btn.setLayoutY(y+60);

        EventHandler<ActionEvent> setValueEvent = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                l.setText(tf.getText());
            }
        };

        btn.setOnAction(setValueEvent);

        g.getChildren().addAll(tf, l, btn);

        return g;
    }
}

public class Main extends Application {
    private final int maxHeight = 540;
    private static ArrayList<Rectangle> bars = new ArrayList<Rectangle>();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rect = new Rectangle(10, 60);
        rect.setX(1270);
        rect.setY(580);
        Group group = new Group();
        group.getChildren().add(rect);
        group.getChildren().addAll(InputTextField.InputBox(580, 50, 100, 20));

        ChangeListener<String> textFieldListener = (obs, oV, nV) -> {
            if(nV.isEmpty()){
                InputTextField.tf.setText("0");
            }
            else{
                InputTextField.tf.setText(InputTextField.tf.getText());
            }
        };
        InputTextField.tf.textProperty().addListener(textFieldListener);
        textFieldListener.changed(null, null, InputTextField.tf.getText());
        System.out.println(textFieldListener.toString());
        Scene scene = new Scene(group, 1280, 640, Color.GRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
