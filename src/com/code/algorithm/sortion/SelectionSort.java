package com.code.algorithm.sortion;

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
        
        for (int i = a.length-1; i > 0; i--) {
            int max = a[i];
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (a[j]>max) {
                    maxIndex = j;
                    max = a[j];
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
