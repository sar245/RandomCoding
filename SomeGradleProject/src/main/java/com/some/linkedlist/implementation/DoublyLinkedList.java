/**
 * 
 */
package com.some.linkedlist.implementation;

import com.some.linkedlist.implementation.LinkedList.Node;

/**
 * @author Arun Ramachandran
 *
 */
public class DoublyLinkedList {

	Node head;

	class Node {
		int data;
		Node next;
		Node prev;

		/**
		 * @param data
		 */
		public Node(int data) {
			this.data = data;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.reverse();
	}

	private void reverse() {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll = dll.makeListByPush();
		dll.printList();
		System.out.println();
		Node node = dll.head;
		Node temp = null;
		while (node != null) {
			temp = node.prev;
			node.prev = node.next;
			node.next = temp;
			node = node.prev;
		}
		if (temp != null) {
			dll.head = temp.prev;
		}
		dll.printList();
	}

	private void push(int new_data) {
		Node n = new Node(new_data);
		n.next = head;
		n.prev = null;
		if (head != null) {
			head.prev = n;
		}
		head = n;
	}

	private void append(int new_data) {
		Node n = new Node(new_data);
		Node last = head;
		n.next = null;

		if (head == null) {
			n.prev = null;
			head = n;
			return;
		}

		while (last.next != null) {
			last = last.next;
		}
		last.next = n;
		n.prev = last;
		return;
	}

	private void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	private void printReverseList() {
		Node n = head;
		while (n != null) {
			if (n.next == null)
				break;
			n = n.next;
		}

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.prev;
		}
	}

	private DoublyLinkedList makeListByPush() {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.push(1);
		dll.push(2);
		dll.push(3);
		dll.push(4);
		dll.push(5);
		return dll;
	}

	private DoublyLinkedList makeListByAppend() {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
		dll.append(5);
		return dll;
	}
}
