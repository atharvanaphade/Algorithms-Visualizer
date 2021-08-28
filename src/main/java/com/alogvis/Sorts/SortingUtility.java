package com.alogvis.Sorts;

import java.util.ArrayList;
import java.util.List;

import com.alogvis.Node;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public interface SortingUtility {
    static int dxx = 1280 / 50;

    default ParallelTransition swap (Node[] arr, int i, int j) {
        ParallelTransition pt = new ParallelTransition();

        int dxFactor = j - i;

        pt.getChildren().addAll(arr[i].moveX(dxx * dxFactor), arr[j].moveX(-dxx * dxFactor));

        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return pt;
    }

    default ParallelTransition colorNode (Node[] arr, Color color, int...a) {
        ParallelTransition pt = new ParallelTransition();

        for (int i = 0; i < a.length; i++) {
            FillTransition ft = new FillTransition();
            ft.setShape(arr[a[i]]);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(100));
            pt.getChildren().add(ft);
        }

        return pt;
    }

    default ParallelTransition colorNode (List<Node> list, Color color) {
        ParallelTransition pt = new ParallelTransition();

        for (Node nn : list) {
            FillTransition ft = new FillTransition();
            ft.setShape(nn);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(150));
            pt.getChildren().addAll(ft);
        }
        
        return pt;
    }

    public abstract ArrayList<Transition> start (Node[] arr);
}
