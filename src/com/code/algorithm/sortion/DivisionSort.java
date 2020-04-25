package com.code.algorithm.sortion;

import java.util.Arrays;

public class DivisionSort {

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 2, 1, 9};
        int[] b = new int[a.length];
        divisionSort(a, b, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void divisionSort(int[] a, int[] b, int start, int end) {
        if (a==null||a.length==0) {
            return;
        }
        int mid = (start + end)/2;
        
        divisionSort(a, b, start, mid);
        divisionSort(a, b, mid+1, end);

        int left = start;
        int right = mid + 1;
        int k = start;

        while (left < mid&& right < end) {
            while (left < mid && a[left] < a[right]) {
                b[k++] = a[left++];
            }
            while (right < end && a[right] < a[left]) {
                b[k++] = a[right++];
            }
        }
    }

}
