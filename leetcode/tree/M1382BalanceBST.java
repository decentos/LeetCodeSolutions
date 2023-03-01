package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M1382BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        return balance(list, 0, list.size() - 1);
    }

    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }

    private TreeNode balance(List<TreeNode> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = list.get(mid);
        node.left = balance(list, start, mid - 1);
        node.right = balance(list, mid + 1, end);
        return node;
    }
}
