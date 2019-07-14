package com.rank.hacker;

import java.util.Collections;
import java.util.Scanner;

public class HackerRankProblem07 {
	// Complete the staircase function below.
	static void staircase(int n) {
		String blank = " ";
		String hash = "#";
		for (int i = 1; i <= n; i++) {
			System.out.println(String.join("", Collections.nCopies(n - i, blank))
					+ String.join("", Collections.nCopies(i, hash)));
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
