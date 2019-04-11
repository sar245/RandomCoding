/**
 * 
 */
package com.some.linkedlist.implementation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arun Ramachandran
 *
 */
public class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;
		boolean visited;

		/**
		 * @param data
		 */
		public Node(int data) {
			this.data = data;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

	public void push(int new_data) {
		Node n = new Node(new_data);
		n.next = head;
		head = n;
	}

	public void insertAfter(Node prev_node, int new_data) {
		if (prev_node == null) {
			System.out.println("Prev node cannot be null");
			return;
		}
		Node newNode = new Node(new_data);
		newNode.next = prev_node.next;
		prev_node.next = newNode;
	}

	public void append(int new_data) {
		Node newNode = new Node(new_data);
		newNode.next = null;
		if (head == null) {
			head = newNode;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}

	public void deleteNode(int key) {
		Node n = head;
		if (n != null && n.data == key) {
			head = head.next;
			return;
		}
		Node prev = head;
		n = n.next;
		while (n != null) {
			if (n.data == key) {
				prev.next = n.next;
				return;
			}
			prev = n;
			n = n.next;
		}
	}

	public void deleteNodeAt(int position) {
		Node prev = head;
		Node next = head;
		for (int i = 1; (i <= position && next != null); i++) {
			if (i == 1 && position == i) {
				head = next.next;
				return;
			}
			if (i == position) {
				prev.next = next.next;
				return;
			} else {
				if (i != 1) {
					prev = next;
					next = next.next;
				} else {
					next = next.next;
				}
			}
		}
	}

	public void swapNodes(int x, int y) {
		Node nodex = head;
		Node prevx = head;
		int positionOfx = 1;
		Node nodey = head;
		Node prevy = head;
		int positionOfy = 1;
		while (nodex != null) {
			if (nodex.data == x) {
				if (positionOfx == 1) {
					prevx = null;
				}
				break;
			}
			if (positionOfx != 1)
				prevx = nodex;
			nodex = nodex.next;
			positionOfx++;
		}
		while (nodey != null) {
			if (nodey.data == y) {
				if (positionOfy == 1) {
					prevy = null;
				}
				break;
			}
			if (positionOfy != 1)
				prevy = nodey;
			nodey = nodey.next;
			positionOfy++;
		}
		if (prevx != null) {
			prevx.next = nodey;
		} else {
			head = nodey;
		}
		if (prevy != null) {
			prevy.next = nodex;
		} else {
			head = nodex;
		}
		if (nodex.next == null) {
			nodex.next = nodey.next;
			nodey.next = null;
		} else if (nodey.next == null) {
			nodey.next = nodex.next;
			nodex.next = null;
		} else {
			Node n;
			n = nodex.next;
			nodex.next = nodey.next;
			nodey.next = n;
		}
	}

	public void reverseIterative() {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public Node reverseRecursively(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return head;
		}
		Node next = curr.next;
		curr.next = prev;
		reverseRecursively(next, curr);
		return head;
	}

	public LinkedList mergeSorttedLinkedList(Node nodeA, Node nodeB) {
		LinkedList l = new LinkedList();

		if (nodeA == null) {
			l.head = nodeB;
			return l;
		}
		if (nodeB == null) {
			l.head = nodeA;
			return l;
		}

		while (nodeA != null || nodeB != null) {
			if (nodeA == null) {
				l.append(nodeB.data);
				nodeB = nodeB.next;
				continue;
			}
			if (nodeB == null) {
				l.append(nodeA.data);
				nodeA = nodeA.next;
				continue;
			}
			if (nodeB.data > nodeA.data) {
				l.append(nodeA.data);
				nodeA = nodeA.next;
			} else {
				l.append(nodeB.data);
				nodeB = nodeB.next;
			}
		}
		return l;
	}

	public Node reverse(Node head, int k) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null) {
			head.next = reverse(next, k);
		}
		return prev;
	}

	public boolean hasLoop(Node node) {
		Set<Node> set = new HashSet<Node>();

		while (node != null) {
			if (set.contains(node)) {
				return true;
			}
			set.add(node);
			node = node.next;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.detectAndRemoveUsingFCD();
	}

	public void detectAndRemoveLoopUsingVisitedTechnique() {
		LinkedList list = new LinkedList();

		list.push(20);
		list.push(4);
		list.push(15);
		list.push(10);

		/* Create loop for testing */
		list.head.next.next.next.next = list.head;
		Node node = list.head;
		Node prev = null;
		while (node != null) {
			if (!node.visited) {
				node.visited = true;
			} else {
				prev.next = null;
				break;
			}
			prev = node;
			node = node.next;
		}
		// node = list.head;
		list.printList();
	}

	public void detectAndRemoveUsingFCD() {
		LinkedList list = makeLoop();
		Node firstCommon = detectLoopUsingFCD(list.head);
		Node node = list.head;
		while (node != null) {
			boolean found = getStartingNode(node, firstCommon);
			if (found) {
				break;
			}
			node = node.next;
		}
		list.printList();
	}

	public void detectLoop() {
		LinkedList list = makeLoop();

		if (hasLoop(list.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
	}

	public void detectLoopUsingFCD() {
		LinkedList list = makeLoop();
		detectLoopUsingFCD(list.head);
		list = makeList();
		detectLoopUsingFCD(list.head);
	}

	private boolean getStartingNode(Node currHead, Node firstCommon) {
		Node ptr2 = firstCommon;
		while (ptr2.next != firstCommon && ptr2.next != currHead) {
			ptr2 = ptr2.next;
		}
		if (ptr2.next == currHead) {
			ptr2.next = null;
			return true;
		}
		return false;
	}

	private Node detectLoopUsingFCD(Node head) {
		Node first = head;
		Node second = head;
		while (first != null && second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
			if (first == second) {
				System.out.println("Found loop");
				return first;
			}
		}
		System.out.println("No loop found");
		return null;
	}

	public void reverseInBlocks() {
		LinkedList l = new LinkedList();
		l.push(9);
		l.push(8);
		l.push(7);
		l.push(6);
		l.push(5);
		l.push(4);
		l.push(3);
		l.push(2);
		l.push(1);
		l.printList();
		System.out.println();
		l.head = l.reverse(l.head, 2);
		l.printList();
	}

	public void dataForMerge() {
		LinkedList a = new LinkedList();
		a.append(1);
		a.append(2);
		a.append(11);
		a.append(12);
		a.append(13);

		LinkedList b = new LinkedList();
		b.append(5);
		b.append(6);
		b.append(7);
		b.append(14);
		b.append(15);
		b.append(16);
		b.append(17);
		a.printList();
		System.out.println();
		b.printList();
		System.out.println();
		LinkedList c = new LinkedList();
		c = c.mergeSorttedLinkedList(b.head, a.head);
		c.printList();
	}

	private LinkedList makeLoop() {
		LinkedList list = new LinkedList();
		list.append(50);
		list.append(20);
		list.append(4);
		list.append(15);
		list.append(10);

		/* Create loop for testing */
		list.head.next.next.next.next.next = list.head.next.next;;
		return list;
	}

	private LinkedList makeList() {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(1);
		list.append(2);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);
		return list;
	}
}
