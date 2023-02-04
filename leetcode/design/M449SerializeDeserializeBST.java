package design;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M449SerializeDeserializeBST {

    public String serialize(TreeNode root) {
        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                sb.append(",").append(curr.left.val);
                queue.offer(curr.left);
            } else {
                sb.append(",").append("null");
            }

            if (curr.right != null) {
                sb.append(",").append(curr.right.val);
                queue.offer(curr.right);
            } else {
                sb.append(",").append("null");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] splitted = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splitted[0]));
        queue.offer(root);
        int index = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index + 1 < splitted.length) {
                index++;
                String next = splitted[index];
                if (!next.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(next));
                    queue.offer(node.left);
                }
            }
            if (index + 1 < splitted.length) {
                index++;
                String next = splitted[index];
                if (!next.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(next));
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
