/**
 * 
 */
package com.some.binary.tree.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class BinarySearchTree {

	private Node root;
	private StringBuffer inOrderTraversal;
	private StringBuffer preOrderTraversal;
	private StringBuffer postOrderTraversal;

	public void insert(int value) {
		Node node = new Node<>(value);
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
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

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * @return the inOrderTraversal
	 */
	public StringBuffer getInOrderTraversal() {
		return inOrderTraversal;
	}

	/**
	 * @param inOrderTraversal the inOrderTraversal to set
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
	 * @param preOrderTraversal the preOrderTraversal to set
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
	 * @param postOrderTraversal the postOrderTraversal to set
	 */
	public void setPostOrderTraversal(StringBuffer postOrderTraversal) {
		this.postOrderTraversal = postOrderTraversal;
	}
	
	private void insertRec(Node latestRoot, Node node) {

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

	private void printRecInorderTraversal(Node latestRoot) {
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

	private void printRecPreorderTraversal(Node latestRoot) {
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

	private void printRecPostorderTraversal(Node latestRoot) {
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
