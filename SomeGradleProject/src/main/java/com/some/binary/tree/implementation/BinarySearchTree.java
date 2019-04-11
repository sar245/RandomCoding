/**
 * 
 */
package com.some.binary.tree.implementation;

import org.apache.commons.math3.analysis.function.Min;

/**
 * @author Arun Ramachandran
 *
 */
public class BinarySearchTree {

	private Node<Integer> root;
	private StringBuffer inOrderTraversal;
	private StringBuffer preOrderTraversal;
	private StringBuffer postOrderTraversal;

	/**
	 * @return the root
	 */
	public Node<Integer> getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node<Integer> root) {
		this.root = root;
	}

	/**
	 * @return the inOrderTraversal
	 */
	public StringBuffer getInOrderTraversal() {
		return inOrderTraversal;
	}

	/**
	 * @param inOrderTraversal
	 *            the inOrderTraversal to set
	 */
	public void setInOrderTraversal(StringBuffer inOrderTraversal) {
		this.inOrderTraversal = inOrderTraversal;
	}

	/**
	 * @return the preOrderTraversal
	 */
	public StringBuffer getPreOrderTraversal() {
		return preOrderTraversal;
	}

	/**
	 * @param preOrderTraversal
	 *            the preOrderTraversal to set
	 */
	public void setPreOrderTraversal(StringBuffer preOrderTraversal) {
		this.preOrderTraversal = preOrderTraversal;
	}

	/**
	 * @return the postOrderTraversal
	 */
	public StringBuffer getPostOrderTraversal() {
		return postOrderTraversal;
	}

	/**
	 * @param postOrderTraversal
	 *            the postOrderTraversal to set
	 */
	public void setPostOrderTraversal(StringBuffer postOrderTraversal) {
		this.postOrderTraversal = postOrderTraversal;
	}

	public void insert(int value) {
		Node<Integer> node = new Node<Integer>(value);
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
	}
	
	public void delete(int value) {
		Node<Integer> node = new Node<Integer>(value);
		System.out.println(root);
		deleteNode(root, node);
		System.out.println(root);
	}

	public void printInOrderTraversal() {
		printRecInorderTraversal(root);
		System.out.println("");
	}

	public void printPreOrderTraversal() {
		printRecPreorderTraversal(root);
		System.out.println("");
	}

	public void printPostOrderTraversal() {
		printRecPostorderTraversal(root);
		System.out.println("");
	}

	public void printLevelOrderTreeTraversal() {
		printLevelOrderTreeTraversal(root);
		System.out.println("");
	}

	public void printDiameter() {
		System.out.println(diameter(root));
	}

	public void printMaxWidth() {
		System.out.println(getMaxWidth(root));
	}

	public void connectNodesAtSameLevel() {
		ConnectedNode<Integer> root = new ConnectedNode<Integer>(10);
		root.setLeft(new ConnectedNode<Integer>(8));
		root.setRight(new ConnectedNode<Integer>(2));
		root.getLeft().setLeft(new ConnectedNode<Integer>(3));
		root.getLeft().setRight(new ConnectedNode<Integer>(31));
		root.getLeft().getLeft().setLeft(new ConnectedNode<Integer>(11));
		root.getLeft().getLeft().setRight(new ConnectedNode<Integer>(12));
		root.getRight().setLeft(new ConnectedNode<Integer>(21));
		System.out.println(root);
		connectNodesAtSameLevel(root, null);
		System.out.println(root);
	}

	public boolean checkIfSubTree(Node<Integer> t, Node<Integer> s) {
		if (s == null)
			return true;
		if (t == null)
			return false;

		if (isIdentical(t, s))
			return true;

		return checkIfSubTree(t.getLeft(), s) || checkIfSubTree(t.getRight(), s);
	}

	public int height(Node<Integer> latestRoot) {
		if (latestRoot == null) {
			return 0;
		} else {
			int leftHeight = height(latestRoot.getLeft());
			int rightHeight = height(latestRoot.getRight());

			if (leftHeight > rightHeight) {
				return leftHeight + 1;
			} else {
				return rightHeight + 1;
			}
		}

	}
	
	public boolean printAncesterTree(Node<Integer> latestRoot, int value) {
		if (latestRoot == null) {
			return false;
		}

		if (latestRoot.getValue() == value) {
			return true;
		}
		if (printAncesterTree(latestRoot.getLeft(), value) || printAncesterTree(latestRoot.getRight(), value)) {
			System.out.print(latestRoot.getValue() + " ");
			return true;
		}
		return false;
	}

	private void connectNodesAtSameLevel(ConnectedNode<Integer> latestRoot, ConnectedNode<Integer> right) {
		if (latestRoot == null) {
			return;
		}

		latestRoot.setNextRight(right);

		if (latestRoot.getLeft() != null) {
			connectNodesAtSameLevel(latestRoot.getLeft(), latestRoot.getRight());
		}

		if (latestRoot.getRight() != null) {
			connectNodesAtSameLevel(latestRoot.getRight(), (right != null) ? right.getLeft() : null);
		}
	}

	private boolean isIdentical(Node<Integer> t, Node<Integer> s) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		return t.getValue().intValue() == s.getValue().intValue() && isIdentical(t.getLeft(), s.getLeft())
				&& isIdentical(t.getRight(), s.getRight());
	}

	private int getMaxWidth(Node<Integer> latestRoot) {
		int height = height(latestRoot);
		int maxWidth = 0;
		for (int i = 1; i <= height; i++) {
			int widthOfLevel = getWidthOfLevel(latestRoot, i);
			maxWidth = (widthOfLevel >= maxWidth) ? widthOfLevel : maxWidth;
		}
		return maxWidth;
	}

	private int getWidthOfLevel(Node<Integer> latestRoot, int level) {
		if (latestRoot == null) {
			return 0;
		} else if (level == 1) {
			return 1;
		} else {
			int leftWidth = getWidthOfLevel(latestRoot.getLeft(), level - 1);
			int rightWidth = getWidthOfLevel(latestRoot.getRight(), level - 1);
			return leftWidth + rightWidth;
		}
	}

	private int diameter(Node<Integer> latestRoot) {
		int leftHeight = height(latestRoot.getLeft());
		int rightHeight = height(latestRoot.getRight());
		return leftHeight + rightHeight + 1;
	}

	private void printLevelOrderTreeTraversal(Node<Integer> root) {
		int height = height(root);
		for (int d = 1; d <= height; d++) {
			printGivenLevel(root, d);
		}
	}

	private void printGivenLevel(Node<Integer> latestRoot, int level) {
		if (latestRoot == null) {
			return;
		}
		if (level == 1) {
			System.out.print(latestRoot.getValue() + " ");
		} else if (level > 1) {
			printGivenLevel(latestRoot.getLeft(), level - 1);
			printGivenLevel(latestRoot.getRight(), level - 1);
		}
	}

	private void insertRec(Node<Integer> latestRoot, Node<Integer> node) {

		if (latestRoot.getValue() > node.getValue()) {
			if (latestRoot.getLeft() == null) {
				latestRoot.setLeft(node);
				return;
			} else {
				insertRec(latestRoot.getLeft(), node);
			}
		} else {
			if (latestRoot.getRight() == null) {
				latestRoot.setRight(node);
				return;
			} else {
				insertRec(latestRoot.getRight(), node);
			}
		}
	}
	
	private Node<Integer> deleteNode(Node<Integer> latestRoot, Node<Integer> node) {
		if (latestRoot == null) {
			return latestRoot;
		}

		if (latestRoot.getLeft() == null && latestRoot.getRight() == null && latestRoot.getValue() == node.getValue()) {
			latestRoot = null;
			return;
		}

		if (latestRoot.getValue() == node.getValue()) {
			if (latestRoot.getLeft() != null && latestRoot.getRight() != null) {
				Node<Integer> inOrderSuccessor = findMinimum(latestRoot);
				latestRoot.setValue(inOrderSuccessor.getValue());
				inOrderSuccessor = null;
				return;
			} else if (latestRoot.getLeft() != null && latestRoot.getValue() == node.getValue()) {
				return latestRoot.getLeft();
			} else if (latestRoot.getRight() != null && latestRoot.getValue() == node.getValue()) {
				return latestRoot.getRight();
				
			}
		} else {
			if (node.getValue() < latestRoot.getValue()) {
				deleteNode(latestRoot.getLeft(), node);
			} else if (node.getValue() > latestRoot.getValue()) {
				deleteNode(latestRoot.getRight(), node);
			}
		}
	}
	
	private Node<Integer> findMinimum(Node<Integer> latestRoot) {
		if (latestRoot.getLeft() != null) {
			return findMinimum(latestRoot.getLeft());
		}
		return latestRoot;
	}

	private void printRecInorderTraversal(Node<Integer> latestRoot) {
		if (latestRoot == null) {
			return;
		}

		printRecInorderTraversal(latestRoot.getLeft());
		System.out.print(latestRoot.getValue() + " ");
		if (inOrderTraversal == null) {
			inOrderTraversal = new StringBuffer();
		}
		inOrderTraversal.append(latestRoot.getValue() + " ");
		printRecInorderTraversal(latestRoot.getRight());

	}

	private void printRecPreorderTraversal(Node<Integer> latestRoot) {
		if (latestRoot == null) {
			return;
		}

		System.out.print(latestRoot.getValue() + " ");
		if (preOrderTraversal == null) {
			preOrderTraversal = new StringBuffer();
		}
		preOrderTraversal.append(latestRoot.getValue() + " ");
		printRecPreorderTraversal(latestRoot.getLeft());
		printRecPreorderTraversal(latestRoot.getRight());
	}

	private void printRecPostorderTraversal(Node<Integer> latestRoot) {
		if (latestRoot == null) {
			return;
		}

		printRecPostorderTraversal(latestRoot.getLeft());
		printRecPostorderTraversal(latestRoot.getRight());
		System.out.print(latestRoot.getValue() + " ");
		if (postOrderTraversal == null) {
			postOrderTraversal = new StringBuffer();
		}
		postOrderTraversal.append(latestRoot.getValue() + " ");
	}
}
