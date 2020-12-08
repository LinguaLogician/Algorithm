package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 20, 1, 9, 8, 2};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] a) {
        if (a==null||a.length==0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i-1;
            if (a[j]>temp) {
                while (j>=0&&a[j]>temp) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = temp;
            }
        }
    }
}
