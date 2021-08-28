package com.alogvis;

import javafx.scene.paint.Color;
import java.util.Random;

class RandomNodes {
    public RandomNodes () {}

    public static Node[] randomNodes (int n) {
        Node[] arr = new Node[n];
        Random r = new Random();

        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = new Node(1 + r.nextInt(arr.length));
            arr[i].setX(i * (1280 / arr.length));
            arr[i].setFill(Color.AQUA);
            setNodeDim(arr[i], arr.length);
        }
        return arr;
    }

    public static void setNodeDim (Node node, int n) {
        node.setWidth((double)(1280 / n) - (double)10);
        node.setHeight((double)((720 - 100) / n) * (double)node.getValue());
    }
}