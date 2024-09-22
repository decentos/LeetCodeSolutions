package tree.binary;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M889ConstructTreePreorderPostorder {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int val = preorder[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(val);

        if (left < right) {
            int leftVal = preorder[preIndex];
            int leftIndex = map.get(leftVal);
            node.left = helper(preorder, left, leftIndex);
            node.right = helper(preorder, leftIndex + 1, right - 1);
        }

        return node;
    }
}
