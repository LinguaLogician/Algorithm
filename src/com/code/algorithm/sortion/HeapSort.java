package com.code.algorithm.sortion;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = {9, 8, 1, 6, 3, 5, 2, 7, 4, 5, 2};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void heapSort(int[] a) {
        if (a==null||a.length==0) {
            return;
        }
        buildHeap(a);
        swapAndAdjust(a);
    }
    private static void buildHeap(int[] a) {
        int n = a.length;
        int end = a.length -1;
        int maxIndex;
        for (int i = (n-1)/2; i >= 0; i--) {
            maxIndex = compareAndSwap(a, i, end);
            adjust(a, maxIndex, end);
        }
    }
    private static void adjust(int[] a, int index, int end) {
        int maxIndex = index;
        while (2*maxIndex+1<end) {
            maxIndex = compareAndSwap(a, maxIndex, end);
            if (maxIndex==index) {
                return;
            }
        }
    }
    private static int compareAndSwap(int[] a, int index, int end) {
        
        int max = a[index];
        int maxIndex = index;
            
        if (2*index+1<=end&& a[2*index+1]>max) {
            max = a[2*index+1];
            maxIndex = 2*index+1;
        }
        if (2*index+2<=end && a[2*index+2]>max) {
            max = a[2*index+2];
            maxIndex = 2*index+2;
        }
        swap(a, index, maxIndex);
        return maxIndex;
    }
    private static void swapAndAdjust(int[] a) {
        for (int end = a.length-1; end > 0; end--) {
            swap(a, 0, end);
            adjust(a, 0, end-1);
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
