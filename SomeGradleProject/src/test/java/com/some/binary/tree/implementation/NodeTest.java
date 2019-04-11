/**
 * 
 */
package com.some.binary.tree.implementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Arun Ramachandran
 *
 */
public class NodeTest {

	BinarySearchTree tree;

	@Before
	public void setup() {

		tree = new BinarySearchTree();
		// 3, 10, 17, 25, 30, 32, 38, 40, 50, 78, 93
		tree.insert(78);
		tree.insert(10);
		tree.insert(17);
		tree.insert(38);
		tree.insert(30);
		tree.insert(25);
		tree.insert(3);
		tree.insert(32);
		tree.insert(40);
		tree.insert(93);
		tree.insert(50);
	}

	// @Test
	// public void testInsert() {
	// assertEquals(3, getLastLeftChildValue(tree.getRoot()));
	// assertEquals(93, getLastRightChildValue(tree.getRoot()));
	// }
	//
	@Test
	public void testPrintInOrderTraversal() {
		tree.printInOrderTraversal();
	}

	@Test
	public void testPrintPreOrderTraversal() {
		tree.printPreOrderTraversal();
	}

	@Test
	public void testPrintPostOrderTraversal() {
		tree.printPostOrderTraversal();
	}

	@Test
	public void testPrintLevelOrderTreeTraversal() {
		tree.printLevelOrderTreeTraversal();
	}
	
	@Test
	public void testPrintDiameter() {
		tree.printDiameter();
	}
	
	@Test
	public void testPrintMaxWidth() {
		tree.printMaxWidth();
	}
	
	@Test
	public void testConnectNodesAtSameLevel() {
		tree.connectNodesAtSameLevel();
	}
	
	@Test
	public void testPrintAncesterTree() {
		tree.printAncesterTree(tree.getRoot(), 40);
	}
	
	@Test
	public void testDeleteNode25() {
		tree.delete(25);
	}
	
	@Test
	public void testDeleteNode50() {
		tree.delete(50);
	}
	
	@Test
	public void testDeleteNode40() {
		tree.delete(40);
	}
	
	@Test
	public void testDeleteNode28() {
		tree.delete(28);
	}
	
	// private int getLastLeftChildValue(Node currentRoot) {
	// if (currentRoot.getLeft() == null) {
	// return currentRoot.getValue();
	// } else {
	// return getLastLeftChildValue(currentRoot.getLeft());
	// }
	// }
	//
	// private int getLastRightChildValue(Node currentRoot) {
	// if (currentRoot.getRight() == null) {
	// return currentRoot.getValue();
	// } else {
	// return getLastRightChildValue(currentRoot.getRight());
	// }
	// }

}
