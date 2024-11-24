package tree.binary;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M105ConstructTreePreorderInorder {
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0 ; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(inorderMap, preorder, 0, n - 1);
    }

    private TreeNode arrayToTree(Map<Integer, Integer> inorderMap, int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        int inorderIndex = inorderMap.get(val);

        root.left = arrayToTree(inorderMap, preorder, left, inorderIndex - 1);
        root.right = arrayToTree(inorderMap, preorder, inorderIndex + 1, right);

        return root;
    }
}
