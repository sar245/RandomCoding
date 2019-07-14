package com.rank.hacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerRankProblem05 {

	// Complete the diagonalDifference function below.
	static int diagonalDifference(int[][] arr) {
		int n = arr.length;
		int sd1 = 0;
		int sd2 = 0;
		for (int i = 0; i < n; i++) {
			sd1 += arr[i][i];
			sd2 += arr[n - i-1][i];
		}

		return Math.abs(sd1 - sd2);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < n; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = diagonalDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
