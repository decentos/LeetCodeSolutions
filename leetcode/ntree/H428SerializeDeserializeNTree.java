package ntree;

import util.NTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class H428SerializeDeserializeNTree {

    public String serialize(NTreeNode root) {
        if (root == null) return null;

        StringBuilder serialize = new StringBuilder();
        Queue<NTreeNode> queue = new LinkedList<>();
        serialize.append(root.val);
        queue.offer(root);

        while (!queue.isEmpty()) {
            NTreeNode node = queue.poll();

            if (node.children.isEmpty()) {
                serialize.append(",").append("[]");
                continue;
            }

            serialize.append(",").append("[");
            for (NTreeNode child : node.children) {
                serialize.append(child.val).append("\s");
                queue.offer(child);
            }
            serialize.setCharAt(serialize.length() - 1, ']');
        }
        return serialize.toString();
    }

    public NTreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] splitted = data.split(",");
        NTreeNode root = new NTreeNode(Integer.parseInt(splitted[0]), new ArrayList<>());
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty()) {
            NTreeNode parent = queue.poll();
            String children = splitted[index].substring(1, splitted[index].length() - 1);
            index++;
            if (children.length() == 0) continue;

            String[] arr = children.split("\s");
            for (String child : arr) {
                NTreeNode childNode = new NTreeNode(Integer.parseInt(child), new ArrayList<>());
                parent.children.add(childNode);
                queue.offer(childNode);
            }
        }
        return root;
    }
}
