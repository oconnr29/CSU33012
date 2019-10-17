import java.util.ArrayList;

class DagNode {
	int data;
	DagNode left;
	DagNode right;
	ArrayList<DagNode> ancestors;

	DagNode(int value) {
		data = value;
		left = null;
		right = null;
		ancestors = null;
	}
}

public class DAG {
	
}