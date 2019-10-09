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
		else if (node.data == n1 || node.data == n2)
			return node;
		Node left = findLCA(node.left, n1, n2);
		Node right = findLCA(node.right, n1, n2);
		if (left != null && right != null)
			return node;
		else if (left != null)
			return left;
		else
			return right;
	}
}