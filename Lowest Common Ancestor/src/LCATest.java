import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class LCATest {
	
	
	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA of empty tree: ", null, tree.findLCA(1, 2));
	}
	
	@Test
	public void testSimpleLCA(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of 2 and 3: ", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 4 and 5: ", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7: ", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 6: ", 1, tree.findLCA(4, 6).data);
	}

	@Test
	public void testForNonExistentNodes(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("LCA of non-existent nodes: ", null, tree.findLCA(8, 9));
	}
	
	@Test
	public void testTwoNodes(){
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		assertEquals("LCA of root and only one child: ", 1, tree.findLCA(1, 2).data);	
	}
	
	@Test
	public void testSize15Nodes() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		tree.root.right.left.right = new Node(13);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

		assertEquals("LCA of 1 and 2", 1, tree.findLCA(1, 2).data);
		assertEquals("LCA of 2 and 3", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 2 and 4", 2, tree.findLCA(2, 4).data);
		assertEquals("LCA of 4 and 5", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 6 and 7", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 8", 4, tree.findLCA(4, 8).data);
		assertEquals("LCA of 8 and 9", 4, tree.findLCA(8, 9).data);
		assertEquals("LCA of 6 and 12", 6, tree.findLCA(6, 12).data);
		assertEquals("LCA of 14 and 15", 7, tree.findLCA(14, 15).data);
		assertEquals("LCA of 8 and 2", 2, tree.findLCA(8, 2).data);
		assertEquals("LCA of 9 and 11", 2, tree.findLCA(9, 11).data);
		assertEquals("LCA of 13 and 14", 3, tree.findLCA(13, 14).data);
		assertEquals("LCA of 15 and 1", 1, tree.findLCA(15, 1).data);
	}
	
	@Test
	public void noOrderTest() {
		LCA tree = new LCA();
		tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.right = new Node(1);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(2);
		tree.root.right.right = new Node(6);

		assertEquals("LCA of tree with no order", 5,
				tree.findLCA(6, 4).data);
		assertEquals("LCA of tree with no order", 3,
				tree.findLCA(3, 4).data);
		assertEquals("LCA of tree with no order", 1,
				tree.findLCA(6, 2).data);
		assertEquals("LCA of tree with no order", 5,
				tree.findLCA(7, 2).data);
	}
	
	@Test
	public void testDAG() {
		LCA DAGtree = new LCA();
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		DAGtree.addToGraph(root);
		DAGtree.addToGraph(node2);
		DAGtree.addToGraph(node3);
		DAGtree.addToGraph(node4);
		DAGtree.addToGraph(node5);
		DAGtree.addToGraph(node6);

		DAGtree.addAncestorsToNode(root, node2);
		DAGtree.addAncestorsToNode(node2, node3);
		DAGtree.addAncestorsToNode(node2, node4);
		DAGtree.addAncestorsToNode(node3, node5);
		DAGtree.addAncestorsToNode(node5, node6);
		DAGtree.addAncestorsToNodeAtPosition(1, node4, node6);

		assertEquals(4, DAGtree.findLCADAG(root, node6, node4).data);
		assertEquals(3, DAGtree.findLCADAG(root, node6, node3).data);
		assertEquals(2, DAGtree.findLCADAG(root, node4, node5).data);
		assertEquals(2, DAGtree.findLCADAG(root, node6, node2).data);
		assertEquals(1, DAGtree.findLCADAG(root, node2, root).data);
		assertEquals(1, DAGtree.findLCADAG(root, root, root).data);
		assertEquals(5, DAGtree.findLCADAG(root, node6, node5).data);
	}
	
	@Test
	public void testDAG2() {
		LCA DAGtree = new LCA();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		DAGtree.addToGraph(node1);
		DAGtree.addToGraph(node2);
		DAGtree.addToGraph(node3);
		DAGtree.addToGraph(node4);
		DAGtree.addToGraph(node5);
		DAGtree.addToGraph(node6);
		DAGtree.addToGraph(node7);

		DAGtree.addAncestorsToNode(node6, node5);
		DAGtree.addAncestorsToNode(node3, node2);
		DAGtree.addAncestorsToNode(node4, node2);
		DAGtree.addAncestorsToNode(node5, node3);
		DAGtree.addAncestorsToNode(node5, node4);
		DAGtree.addAncestorsToNode(node5, node2);
		DAGtree.addAncestorsToNode(node2, node1);
		DAGtree.addAncestorsToNode(node4, node7);

		assertEquals(5, DAGtree.findLCADAG(node6, node3, node4).data);
		assertEquals(4, DAGtree.findLCADAG(node6, node2, node7).data);
		assertEquals(2, DAGtree.findLCADAG(node6, node1, node2).data);
		assertEquals(6, DAGtree.findLCADAG(node6, node6, node6).data);
		assertEquals(4, DAGtree.findLCADAG(node6, node1, node7).data);
		assertEquals(5, DAGtree.findLCADAG(node6, node3, node7).data);
		assertEquals(6, DAGtree.findLCADAG(node6, node5, node6).data);
	}
}
