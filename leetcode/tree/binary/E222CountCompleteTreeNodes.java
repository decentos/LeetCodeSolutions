package tree.binary;

import util.TreeNode;

public class E222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if (left == right) {
            // return (int) Math.pow(2, left) - 1;
            return (1 << left) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
