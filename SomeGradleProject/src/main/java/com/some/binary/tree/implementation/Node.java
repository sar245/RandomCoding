/**
 * 
 */
package com.some.binary.tree.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class Node<T> {

	private T value;
	private Node<T> left;
	private Node<T> right;

	/**
	 * @param value
	 */
	public Node(T value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node<T> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}

}
