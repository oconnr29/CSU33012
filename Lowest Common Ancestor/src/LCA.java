import java.util.ArrayList;

class Node {
		int data;
		Node left, right;
		ArrayList<Node> ancestors;

		Node(int value) {
			data = value;
			left = right = null;
			ancestors = null;
			
		}
	}
public class LCA {
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
	
	Node findLCADAG(Node nodeA, Node nodeB) {
		return findLCADAG(root, nodeA, nodeB);
	}
	
	Node findLCADAG(Node root, Node nodeA, Node nodeB) {
		if (nodeA != null && nodeB != null)
			if (nodeA.ancestors != null && nodeB.ancestors != null) {
				for (int i = 0; i < nodeB.ancestors.size(); i++)
					for (int j = 0; j < nodeA.ancestors.size(); j++)
						if (nodeB.ancestors.get(i) == nodeA.ancestors.get(j))
							return nodeB.ancestors.get(i);
			} else
				return root;
		return null;
	}
}