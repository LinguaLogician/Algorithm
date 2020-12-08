package com.code.algorithm.sortion.test;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int a[] = { 53, 3, 542, 748, 14, 214, 154, 63, 616 };
		radixSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void radixSort(int[] a) {
		int max = getMax(a);
		for (int exp = 1; max / exp > 0; exp *= 10) {
			int[] output = new int[a.length];
			int[] buckets = new int[10];
			
			for (int i = 0; i < a.length; i++)
				buckets[(a[i] / exp) % 10]++;
			
			for (int i = 1; i < 10; i++)
				buckets[i] += buckets[i - 1];
			
			for (int i = a.length - 1; i >= 0; i--) {
				output[buckets[(a[i] / exp) % 10] - 1] = a[i];
				buckets[(a[i] / exp) % 10]--;
			}

			for (int i = 0; i < a.length; i++)
				a[i] = output[i];
			
			output = null;
			buckets = null;
			
		}
	}

	private static int getMax(int[] a) {
		int max;
		max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];

		return max;
	}
}