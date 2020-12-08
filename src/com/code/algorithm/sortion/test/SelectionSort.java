package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 2, 1, 9, 8};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a) {
        if (a==null||a.length==0) {
            return;
        }
        
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int maxIndex = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<min) {
                    maxIndex = j;
                    min = a[j];
                }
            }
            swap(a, maxIndex, i);
        }
    }

    private static void swap(int[] a, int indexA, int indexB) {
        int temp = a[indexB];
        a[indexB] = a[indexA];
        a[indexA] = temp;
    }
}
