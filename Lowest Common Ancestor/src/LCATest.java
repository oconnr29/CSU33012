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
		assertEquals("LCA of 4 and 5: ", 1, tree.findLCA(2, 3).data);
		assertEquals("LCA of 6 and 7: ", 2, tree.findLCA(4, 5).data);
		assertEquals("LCA of 2 and 3: ", 3, tree.findLCA(6, 7).data);
		assertEquals("LCA of 4 and 6: ", 1, tree.findLCA(4, 6).data);
	}
}
