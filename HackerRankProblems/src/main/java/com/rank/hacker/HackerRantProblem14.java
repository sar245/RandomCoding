/**
 * 
 */
package com.rank.hacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Arun Ramachandran
 *
 */
public class HackerRantProblem14 {

	/*
     * Complete the getTotalX function below.
     */
	static int getTotalX(int[] a, int[] b) {
		int lower = 0;
		int upper = Integer.MAX_VALUE;
		int count = 0;
		for (int i : a) {
			if (i > lower)
				lower = i;
		}
		for (int i : b) {
			if (i < upper)
				upper = i;
		}
		for (int i = lower; i <= upper; i++) {
			boolean lowerFlag = false;
			boolean upperFlag = false;
			for (int j : a) {
				if (i % j == 0)
					lowerFlag = true;
				else {
					lowerFlag = false;
					break;
				}
			}
			for (int j : b) {
				if (j % i == 0)
					upperFlag = true;
				else {
					upperFlag = false;
					break;
				}
			}
			if (lowerFlag && upperFlag)
				count++;
		}
		return count;
	}

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }

}
