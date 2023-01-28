package me.decentos.leetcode.tree;

import me.decentos.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E257BinaryTreePaths {
    private final List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        findPath(root, new StringBuilder());
        return paths;
    }

    private void findPath(TreeNode node, StringBuilder path) {
        if (node == null) return;

        path.append(node.val);
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            findPath(node.left, new StringBuilder(path));
            findPath(node.right, new StringBuilder(path));
        }
    }
}
