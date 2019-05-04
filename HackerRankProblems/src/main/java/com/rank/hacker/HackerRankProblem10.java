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
public class HackerRankProblem10 {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		String convertedTime = "";
		String arr[] = s.split(":");
		String period = arr[2].substring(2);
		String hour = "";
		String min = arr[1];
		String sec = arr[2];
		if ("AM".equals(period)) {
			if ("12".equals(arr[0])) {
				hour = "00";
			} else hour = arr[0];
		} else {
			hour = String.format("%02d", (Integer.parseInt(arr[0]) + 12));
		}
		convertedTime = String.format("%1$s:%2$s:%3$s", hour, min, sec.substring(0, 2));
		return convertedTime;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scan.nextLine();

		String result = timeConversion(s);
		System.out.println(result);
		bw.write(result);
		bw.newLine();

		bw.close();
	}
}
