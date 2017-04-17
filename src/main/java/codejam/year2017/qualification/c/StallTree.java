package codejam.year2017.qualification.c;

public class StallTree {
	public final Stall root;

	private StallTree(Stall rootStall) {
		root = rootStall;
	}
	// public void add(Node parent, Node left, Node right) {
	// parent.left = left;
	// parent.right = right;
	// }

	public static StallTree createForRootStall(Stall root) {
		return new StallTree(root);
	}
}
