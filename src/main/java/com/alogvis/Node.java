package com.alogvis;

import java.io.*;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Node extends Rectangle {
    private int value;

    public Node (int n) {
        this.value = n;
    }

    public int getValue () {
        return this.value;
    }

    public TranslateTransition moveX (int x) {
        TranslateTransition t = new TranslateTransition();
        t.setNode(this);
        t.setDuration(Duration.millis(300));
        t.setByX(x);

        return t;
    }
}
