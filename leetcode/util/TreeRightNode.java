package util;

public class TreeRightNode {
    public int val;
    public TreeRightNode left;
    public TreeRightNode right;
    public TreeRightNode next;

    public TreeRightNode() {}

    public TreeRightNode(int val) {
        this.val = val;
    }

    public TreeRightNode(int val, TreeRightNode left, TreeRightNode right, TreeRightNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
