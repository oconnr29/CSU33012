public class LCA {
	class Node {
		int data;
		Node left, right;

		Node(int value) {
			data = value;
			left = right = null;
		}
	}
	Node root;

	Node findLCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	Node findLCA(Node node, int n1, int n2) {
		if (node == null)
			return null;
		return null;
	}
}