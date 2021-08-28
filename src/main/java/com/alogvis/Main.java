package com.alogvis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Window Size = 1280 x 720

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnimationHandler animation = new AnimationHandler();
        animation.setStyle("-fx-background-color: #1f1f1f");

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