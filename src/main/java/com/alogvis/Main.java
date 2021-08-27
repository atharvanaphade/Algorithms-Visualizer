package com.alogvis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Window Size = 1280 x 720

public class Main extends Application {
    private final int maxHeight = 540;
    private static ArrayList<Rectangle> bars = new ArrayList<Rectangle>();
    private static ArrayList<Rectangle> sortedBars = new ArrayList<Rectangle>();
    private static int size;
    private static TextField tf = new TextField();
    private static Label l = new Label("Enter a Value");
    private static Button setBtn = new Button("Set");
    private static Button sortBtn = new Button("Sort");
    private static ObservableList<Data<String, Number>> newBars;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnimationHandler animation = new AnimationHandler();
        animation.setStyle("-fx-background-color: #1c1c1c");

        Scene scene = new Scene(
            animation,
            1280,
            720
        );

        primaryStage.setTitle("Algorithms Visualizer");
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

class AnimationHandler extends BorderPane {
    private Pane pane;
    private HBox buttons;
    
    private Button sortButton;
    private Button randomizeButton;

    private Node[] nodes;

    public AnimationHandler () {
        this.pane = new Pane();
        this.buttons = new HBox();

        this.setCenter(pane);
        this.setBottom(buttons);

        this.sortButton = new Button("Sort");
        this.randomizeButton = new Button("Randomize");

        this.nodes = RandomNodes.randomNodes(50);

        buttons.getChildren().addAll(sortButton, randomizeButton);
        buttons.setAlignment(Pos.CENTER);

        for (javafx.scene.Node nn : buttons.getChildren()) {
            buttons.setMargin(nn, new Insets(5, 5, 20, 5));
        }

        pane.getChildren().addAll(Arrays.asList(nodes));

        randomizeButton.setOnAction((event) -> {
            pane.getChildren().clear();

            nodes = RandomNodes.randomNodes(50);
            pane.getChildren().addAll(Arrays.asList(nodes));
        });
    }
}

class RandomNodes {
    public RandomNodes () {}

    public static Node[] randomNodes (int n) {
        Node[] arr = new Node[n];
        Random r = new Random();

        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = new Node(1 + r.nextInt(arr.length));
            arr[i].setX(i * (1280 / arr.length));
            arr[i].setFill(Color.DARKGREEN);
            setNodeDim(arr[i], arr.length);
        }
        return arr;
    }

    public static void setNodeDim (Node node, int n) {
        node.setWidth((double)(1280 / n) - (double)10);
        node.setHeight((double)((720 - 100) / n) * (double)node.getValue());
    }
}