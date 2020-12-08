package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class QuickSort {

	private static int[] a = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };

	public static void main(String[] args) {
		quickSort(0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int left, int right) {
		int i, j, temp;
		if (left > right) {
			return;
		}
		temp = a[left];
		i = left;
		j = right;
		while (i != j) {
			while (a[j] >= temp && i < j) {
				j--;
			}
			while (a[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		a[left] = a[i];
		a[i] = temp;
		if (left < i - 1) {
			quickSort(left, i - 1);
		}
		if (right > j + 1) {
			quickSort(i + 1, right);
		}
	}
}