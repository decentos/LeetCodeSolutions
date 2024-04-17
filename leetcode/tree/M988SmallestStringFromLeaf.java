package tree;

import util.TreeNode;

public class M988SmallestStringFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = dfs(root, new StringBuilder(), new StringBuilder());
        return sb.toString();
    }

    private StringBuilder dfs(TreeNode node, StringBuilder min, StringBuilder curr) {
        if (node == null) {
            return min;
        }

        char currChar = (char) (node.val + 'a');
        curr.insert(0, currChar);

        if (node.left == null && node.right == null) {
            if (min.isEmpty() || min.compareTo(curr) > 0) {
                min = new StringBuilder(curr.toString());
            }
            curr.deleteCharAt(0);
            return min;
        }

        min = dfs(node.left, min, curr);
        min = dfs(node.right, min, curr);
        curr.deleteCharAt(0);
        return min;
    }
}
