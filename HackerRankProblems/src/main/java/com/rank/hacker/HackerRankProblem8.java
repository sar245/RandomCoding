package com.rank.hacker;

import java.util.Scanner;

public class HackerRankProblem8 {
	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		long minSum = 0;
		long maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			long sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				sum += arr[j];
			}
			if (sum > maxSum)
				maxSum = sum;
			if (minSum == 0)
				minSum = sum;
			else if (sum < minSum)
				minSum = sum;
		}
		System.out.println(minSum + " " + maxSum);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}
}
