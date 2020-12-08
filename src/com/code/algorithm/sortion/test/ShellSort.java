package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 7, 9, 8, 3, 6 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr1 = { 1, 4, 2, 7, 9, 8, 3, 6 };
		sort1(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	public static void sort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				while (j - gap >= 0 && arr[j] < arr[j - gap]) {
					swap(arr, j, j - gap);
					j -= gap;
				}
			}
		}
	}

	public static void sort1(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i - gap;
				int temp = arr[i];
				if (temp < arr[j]) {
					while (j > 0 && temp < arr[j]) {
						arr[j + gap] = arr[j];
						j -= gap;
					}
					arr[j+gap] = temp;
				}
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}
}