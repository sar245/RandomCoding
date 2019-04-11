/**
 * 
 */
package com.code.chef.nov.challenge;

import java.util.Scanner;

/**
 * @author Arun Ramachandran
 *
 */
public class VillagesAndTribes {

	private static final char A = 'A';
	private static final char B = 'B';

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String t = scanner.nextLine();
		int testcases = Integer.parseInt(t);
		for (int i = 0; i <= testcases; i++) {
			String s = scanner.nextLine();
			findVillages(s);
		}

		scanner.close();
	}

	private static void findVillages(String s) {
		int a = findAVillages(s);
		int b = findBVillages(s);
		System.out.println(a + " " + b);
	}

	private static int findAVillages(String s) {
		int a = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == A) {
				a++;
				// find index of next A
				int indexOfNextA = findNextA(s, i + 1);
				if (indexOfNextA != 0) {
					a += (indexOfNextA - i);
					i = indexOfNextA;
				} 
			}
		}
		return a;
	}
	
	private static int findNextA(String s, int startIndex) {
		int index = 0;
		
		for (int i = startIndex; i < s.length(); i++) {
			if (s.charAt(i) == A) {
				index = i;
			} else if (s.charAt(i) == B) {
				return index;
			}
		}
		
		return index;
	}

	private static int findBVillages(String s) {
		int b = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == B) {
				b++;
				// find index of next A
				int indexOfNextB = findNextB(s, i + 1);
				if (indexOfNextB != 0) {
					b += (indexOfNextB - i);
					i = indexOfNextB;
				} 
			}
		}
		return b;
	}
	
	private static int findNextB(String s, int startIndex) {
		int index = 0;
		
		for (int i = startIndex; i < s.length(); i++) {
			if (s.charAt(i) == B) {
				index = i;
			} else if (s.charAt(i) == A) {
				return index;
			}
		}
		
		return index;
	}

}
