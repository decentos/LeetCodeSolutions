package tree.binary;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M106ConstructTreeInorderPostorder {
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postorderIndex = n - 1;
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(inorderMap, postorder, 0, n - 1);
    }

    private TreeNode arrayToTree(Map<Integer, Integer> inorderMap, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int val = postorder[postorderIndex--];
        TreeNode root = new TreeNode(val);
        int inorderIndex = inorderMap.get(val);

        root.right = arrayToTree(inorderMap, postorder, inorderIndex + 1, right);
        root.left = arrayToTree(inorderMap, postorder, left, inorderIndex - 1);

        return root;
    }
}
