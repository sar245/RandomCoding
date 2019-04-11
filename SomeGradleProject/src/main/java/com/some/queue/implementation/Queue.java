/**
 * 
 */
package com.some.queue.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class Queue<T> {

	private Node front = null;
	private Node rear = null;

	class Node {
		T data;
		Node next;

		/**
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
		}

	}

	public Queue() {
	}

	public void enqueue(T t) {
		Node node = new Node(t);
		if (front == null && rear == null) {
			front = node;
			rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}

	public T dequeue() {
		Node n = front;
		front = front.next;
		return n.data;
	}

	public boolean isEmpty() {
		return (front == null) ? true : false;
	}

}
