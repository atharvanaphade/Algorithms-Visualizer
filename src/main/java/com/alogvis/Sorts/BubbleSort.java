package com.alogvis.Sorts;

import java.util.ArrayList;
import java.util.Arrays;

import com.alogvis.Node;

import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class BubbleSort implements SortingUtility {

    private Boolean swapped;
    private ArrayList<Transition> transisions;

    public BubbleSort () {
        this.transisions = new ArrayList<>();
    }

    private ArrayList<Transition> Compare (Node[] arr, int a, int b) {
        ArrayList<Transition> transisionz = new ArrayList<>();
		transisionz.add(colorNode(arr, Color.DARKSALMON, a, b));

        if (arr[a].getValue() > arr[b].getValue()) {
            transisionz.add(swap(arr, a, b));
        }

        transisions.add(colorNode(arr, Color.AZURE, a, b));
        return transisionz;
    }

    private void bubbleSort (Node[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                this.transisions.addAll(Compare(arr, j, j + 1));
            }
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public ArrayList<Transition> start (Node[] arr) {
        bubbleSort(arr);
        this.transisions.add(colorNode(Arrays.asList(arr), Color.AQUAMARINE));
        return this.transisions;
    }
}
