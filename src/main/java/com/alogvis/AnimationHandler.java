package com.alogvis;

import java.util.Arrays;

import com.alogvis.Sorts.BubbleSort;
import com.alogvis.Sorts.SortingUtility;

import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

class AnimationHandler extends BorderPane {
    private Pane pane;
    private HBox buttons;

    private static SortingUtility su;

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

        buttons.getChildren().add(sortButton);
        buttons.getChildren().add(randomizeButton);
        buttons.setAlignment(Pos.CENTER);

        for (javafx.scene.Node nn : buttons.getChildren()) {
            HBox.setMargin(nn, new Insets(5, 5, 20, 5));
        }

        pane.getChildren().addAll(Arrays.asList(nodes));

        sortButton.setOnAction((event) -> {
            su = new BubbleSort();
            SequentialTransition sq = new SequentialTransition();
            sq.getChildren().addAll(su.start(nodes));
            sq.setOnFinished((e) -> {
                randomizeButton.setDisable(false);
            });

            sq.play();
        });

        randomizeButton.setOnAction((event) -> {
            pane.getChildren().clear();

            nodes = RandomNodes.randomNodes(50);
            pane.getChildren().addAll(Arrays.asList(nodes));
        });
    }
}
