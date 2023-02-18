package tree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M106ConstructTreeInorderPostorder {
    private final Map<Integer, Integer> map = new HashMap<>();
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;

        int val = postorder[index];
        index--;
        TreeNode node = new TreeNode(val);

        int inIndex = map.get(val);
        node.right = helper(postorder, inIndex + 1, right);
        node.left = helper(postorder, left, inIndex - 1);

        return node;
    }
}
