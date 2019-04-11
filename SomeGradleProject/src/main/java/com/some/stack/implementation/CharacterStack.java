/**
 * 
 */
package com.some.stack.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class CharacterStack {

	Node top;

	class Node {
		char data;
		Node next;

		/**
		 * @param data
		 */
		public Node(char data) {
			this.data = data;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	public void push(char data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}

	public Node pop() {
		Node n = top;
		if (top == null) {
			return n;
		}
		top = top.next;
		return n;
	}

	public Node peep() {
		Node n = top;
		return n;
	}

	public boolean isEmpty() {
		return (top == null) ? true : false;

	}

}
