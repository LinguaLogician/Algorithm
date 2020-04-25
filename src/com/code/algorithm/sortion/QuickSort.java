package com.code.algorithm.sortion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 6, 2, 1, 9, 8, 2};
        
        quickSort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int start, int end) {
        if (a==null||a.length==0||start>end) {
            return;
        }
//      为基准数找准位置
        int index = start;
        int left = start;
        int right = end;

        while (left<right) {
            while (index<right&&a[index]<=a[right]) {
                right--;
            }
            swap(a, index, right);
            index = right;
            while (left<index&&a[left]<a[index]) {
                left++;
            }
            swap(a, left, index);
            index = left;
        }
//        为左边部分采用同样方法的操作
        quickSort(a, start, index-1);
//        为右边部分采用同样方法的操作
        quickSort(a, index+1, end);
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
