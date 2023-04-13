package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M230KSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, k);
        return list.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> list, int k) {
        if (node == null || list.size() == k) return;
        dfs(node.left, list, k);
        list.add(node.val);
        dfs(node.right, list, k);
    }
}
