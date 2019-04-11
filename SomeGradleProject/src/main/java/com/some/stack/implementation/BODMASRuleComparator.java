/**
 * 
 */
package com.some.stack.implementation;

import java.util.Comparator;

/**
 * @author Arun Ramachandran
 *
 */
public class BODMASRuleComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return (comparer((char) o1) - comparer((char) o2));
	}

	private int comparer(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
}
