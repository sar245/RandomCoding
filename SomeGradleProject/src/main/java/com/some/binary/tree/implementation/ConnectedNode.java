/**
 * 
 */
package com.some.binary.tree.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class ConnectedNode<T> {

	private T value;
	private ConnectedNode<T> left;
	private ConnectedNode<T> right;
	private ConnectedNode<T> nextRight;

	public ConnectedNode(T value) {
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
	public ConnectedNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(ConnectedNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public ConnectedNode<T> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(ConnectedNode<T> right) {
		this.right = right;
	}

	/**
	 * @return the nextRight
	 */
	public ConnectedNode<T> getNextRight() {
		return nextRight;
	}

	/**
	 * @param nextRight
	 *            the nextRight to set
	 */
	public void setNextRight(ConnectedNode<T> nextRight) {
		this.nextRight = nextRight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConnectedNode [value=" + value + ", left=" + left + ", right=" + right + ", nextRight=" + nextRight
				+ "]";
	}
}
