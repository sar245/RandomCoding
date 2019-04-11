/**
 * 
 */
package com.some.queue.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 3;
		int array[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		for (int i = 0; i < array.length && i + k <= array.length; i++) {
			int max = 0;
			for (int j = i; j < i + k && j < array.length; j++) {
				if (array[j] > max)
					max = array[j];
			}
			System.out.print(max);
		}
		System.out.println();
		k = 4;
		int array2[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}; 
		for (int i = 0; i < array2.length && i + k <= array2.length; i++) {
			int max = 0;
			for (int j = i; j < i + k && j < array2.length; j++) {
				if (array2[j] > max)
					max = array2[j];
			}
			System.out.print(max);
		}
	}

}
