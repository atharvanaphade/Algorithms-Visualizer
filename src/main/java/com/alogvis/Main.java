package com.alogvis;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
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

public class Main extends Application {
    private final int maxHeight = 540;
    private static ArrayList<Rectangle> bars = new ArrayList<Rectangle>();
    private static ArrayList<Rectangle> sortedBars = new ArrayList<Rectangle>();
    private static int size;
    private static TextField tf = new TextField();
    private static Label l = new Label("Enter a Value");
    private static Button setBtn = new Button("Set");
    private static Button sortBtn = new Button("Sort");
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Group barsGroup = new Group();

        // Input Box shit 
        tf.setPrefColumnCount(7);
        tf.setLayoutX(580);
        tf.setLayoutY(50);
        tf.setPrefWidth(100);
        tf.setPrefHeight(20);

        l.setLayoutX(580);
        l.setLayoutY(50 + 40);

        setBtn.setLayoutX(580 + 120);
        setBtn.setLayoutY(50 + 60);
        sortBtn.setLayoutX(580 + 80);
        sortBtn.setLayoutY(50 + 30);
        EventHandler<ActionEvent> setValueEvent = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                l.setText(tf.getText());
                size = Integer.parseInt(tf.getText());
                System.out.println(size);
            }
        };
        setBtn.setOnAction(setValueEvent);
        group.getChildren().addAll(tf, l, setBtn, sortBtn);
        bars = Algorithms.RandomArrayGenerator(size);
        barsGroup.getChildren().addAll(bars);
        barsGroup.setRotate(180);
        group.getChildren().add(barsGroup);
        Scene scene = new Scene(group, 1280, 640, Color.GRAY);
        EventHandler<ActionEvent> sortEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sortedBars = Algorithms.BubbleSort(bars);
                group.getChildren().remove(barsGroup);
                barsGroup.getChildren().remove(bars);
                barsGroup.getChildren().addAll(sortedBars);
                group.getChildren().addAll(barsGroup);
            }
        };
        sortBtn.setOnAction(sortEvent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}

final class Algorithms {
    public static ArrayList<Rectangle> RandomArrayGenerator(int n) {
        Random rand = new Random();
        double x = 540, y = 0;
        n = 4;
        ArrayList<Rectangle> bars = new ArrayList<Rectangle>(n);
        for(int i=0; i<n; i++){
            Rectangle temp = new Rectangle();
            int randomGenerated = rand.nextInt(480);
            temp.setWidth(10);
            temp.setHeight(randomGenerated);
            temp.setX(x);
            temp.setY(640 - 480);
            x -= 10;
            bars.add(temp);
        }
        return bars;
    }

    public static ArrayList<Rectangle> BubbleSort(ArrayList<Rectangle> array) {
        // for(Rectangle i : array) {
        //     System.out.print(i.getHeight() + " ");
        // }
        // System.out.println(array.size());
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j).getHeight() > array.get(j+1).getHeight()) {
                    Rectangle temp = new Rectangle();
                    temp.setX(array.get(j).getX());
                    temp.setY(array.get(j).getY());
                    temp.setHeight(array.get(j).getHeight());
                    temp.setWidth(array.get(j).getWidth());

                    array.get(j).setX(array.get(j + 1).getX());
                    array.get(j).setY(array.get(j + 1).getY());
                    array.get(j).setHeight(array.get(j + 1).getHeight());
                    array.get(j).setWidth(array.get(j + 1).getWidth());
                    
                    array.get(j + 1).setX(temp.getX());
                    array.get(j + 1).setY(temp.getY());
                    array.get(j + 1).setHeight(temp.getHeight());
                    array.get(j + 1).setWidth(temp.getWidth());
                    
                }
            }
        }
        ArrayList<Rectangle> ret = new ArrayList<>();
        for (Rectangle i : array) {
            ret.add(i);
        }
        return ret;
    }
}