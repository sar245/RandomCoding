/**
 * 
 */
package com.some.stack.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class Stack {

	Node top;

	class Node {
		int data;
		Node next;

		/**
		 * @param data
		 */
		public Node(int data) {
			this.data = data;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
	
	private void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	private Node pop() {
		Node n = top;
		if (top == null) {
			return n;
		}
		top = top.next;
		return n;
	}
	
	private Node peep() {
		Node n = top;
		return top;
	}

}
