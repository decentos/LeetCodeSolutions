package tree.binary;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M105ConstructTreePreorderInorder {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int val = preorder[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(val);

        int inIndex = map.get(val);
        node.left = helper(preorder, left, inIndex - 1);
        node.right = helper(preorder, inIndex + 1, right);

        return node;
    }
}
