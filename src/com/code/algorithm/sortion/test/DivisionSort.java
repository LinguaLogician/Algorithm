package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class DivisionSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
		int[] tmp = new int[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(int[] a, int[] temp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, temp, start, mid);
			mergeSort(a, temp, mid + 1, end);
			int left = start;
			int right = mid + 1;
			int k = start;
			while (left <= mid && right <= end) {
				if (a[left] < a[right]) {
					temp[k++] = a[left++];
				} else {
					temp[k++] = a[right++];
				}
			}
			while (left <= mid) {
				temp[k++] = a[left++];
			}
			while (right <= end) {
				temp[k++] = a[right++];
			}
			for (left = start; left <= end; left++)
				a[left] = temp[left];
		}
	}

}