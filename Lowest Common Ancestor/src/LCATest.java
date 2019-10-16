import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class LCATest {
	
	
	@Test
	public void testEmptyTree() {
		LCA tree = new LCA();
		assertEquals("LCA with empty tree: ", null, tree.findLCA(1, 2) );
	}
	
}
