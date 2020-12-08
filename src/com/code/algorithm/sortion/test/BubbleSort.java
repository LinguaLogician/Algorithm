package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 2, 1, 9, 8};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        if (a==null||a.length==0) {
            return;
        }
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j]>a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] a, int indexA, int indexB) {
        if (indexA==indexB) {
            return;
        }
        int temp;
        temp = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = temp;
    }
}
