package util;

public class TreeParentNode {
    public int val;
    public TreeParentNode left;
    public TreeParentNode right;
    public TreeParentNode parent;

    public TreeParentNode() {}

    public TreeParentNode(int val) {
        this.val = val;
    }

    public TreeParentNode(int val, TreeParentNode left, TreeParentNode right, TreeParentNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
