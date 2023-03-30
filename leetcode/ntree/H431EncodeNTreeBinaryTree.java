package ntree;

import util.NTreeNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class H431EncodeNTreeBinaryTree {

    public TreeNode encode(NTreeNode root) {
        if (root == null) return null;

        TreeNode bRoot = new TreeNode(root.val);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, bRoot));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            NTreeNode nNode = pair.nNode;
            TreeNode bNode = pair.bNode;

            TreeNode head = null;
            TreeNode prev = null;
            for (NTreeNode child : nNode.children) {
                TreeNode curr = new TreeNode(child.val);

                if (prev == null) head = curr;
                else prev.right = curr;
                prev = curr;

                queue.offer(new Pair(child, curr));
            }
            bNode.left = head;
        }
        return bRoot;
    }

    public NTreeNode decode(TreeNode root) {
        if (root == null) return null;

        NTreeNode nRoot = new NTreeNode(root.val, new ArrayList<>());
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(nRoot, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            NTreeNode nNode = pair.nNode;
            TreeNode bNode = pair.bNode.left;
            while (bNode != null) {
                NTreeNode child = new NTreeNode(bNode.val, new ArrayList<>());
                nNode.children.add(child);
                queue.offer(new Pair(child, bNode));
                bNode = bNode.right;
            }
        }
        return nRoot;
    }

    private static class Pair {
        NTreeNode nNode;
        TreeNode bNode;

        public Pair(NTreeNode nNode, TreeNode bNode) {
            this.nNode = nNode;
            this.bNode = bNode;
        }
    }
}
