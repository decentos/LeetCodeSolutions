package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E783MinDistanceNodes {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
