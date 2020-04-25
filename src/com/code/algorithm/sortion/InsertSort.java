package com.code.algorithm.sortion;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 2, 1, 9, 8, 2};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] a) {
        if (a==null||a.length==0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            if (a[j-1]>temp) {
                while (j>0&&a[j-1]>temp) {
                    a[j] = a[j-1];
                    j--;
                }
            }
            a[j] = temp;
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
