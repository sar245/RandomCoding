/**
 * 
 */
package com.rank.hacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Arun Ramachandran
 *
 */
public class SomeClass {

	static String timeConversion(String s) {
		String convertedTime = "";
		String arr[] = s.split(":");
		String period = arr[2].substring(2);
		String hour = arr[0];
		String min = arr[1];
		String sec = arr[2];
		if ("AM".equalsIgnoreCase(period)) {
			if ("12".equals(hour))
				hour = "00";
			else
				hour = arr[0];
		} else {
			if (!"12".equals(hour))
				hour = String.format("%02d", (Integer.parseInt(arr[0]) + 12));
		}
		convertedTime = String.format("%1$s:%2$s:%3$s", hour, min, sec.substring(0, 2));
		return convertedTime;
	}

	private static final Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Date d = new Date(2019, 3, 20, 23, 00, 0);

		String s = String.format("%tI:%tM:%tS%tp", d, d, d, d); //

		System.out.println(s);
		String result = timeConversion(s);
		System.out.println(result);
	}

}
