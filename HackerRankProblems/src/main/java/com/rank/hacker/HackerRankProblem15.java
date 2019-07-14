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
public class HackerRankProblem15 {

	/**
	 * @param args
	 */
	static int[] breakingRecords(int[] scores) {
		int min = Integer.MAX_VALUE;
		int max = -1;
		int minChange = 0;
		int maxChange = 0;
		for (int i : scores) {
			if (i < min) {
				min = i;
				minChange++;
			}
			if (i > max) {
				max = i;
				maxChange++;
			}
		}
		int ret[] = { (maxChange > 0) ? maxChange - 1 : 0, (minChange > 0) ? minChange - 1 : 0 };
		return ret;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
