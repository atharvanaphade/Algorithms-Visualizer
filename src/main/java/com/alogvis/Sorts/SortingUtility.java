package com.alogvis.Sorts;

import java.util.List;

import com.alogvis.Node;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public interface SortingUtility {
    static int dx = 1280 / 50;

    default ParallelTransition swap (Node[] arr, int i, int j) {
        ParallelTransition pt = new ParallelTransition();

        int dxFactor = j - i;

        pt.getChildren().addAll(arr[i].moveX(dx * dxFactor), arr[j].moveX(-dx * dxFactor));

        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
}
