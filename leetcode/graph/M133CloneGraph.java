package graph;

import util.NTreeNode;

import java.util.HashMap;
import java.util.Map;

public class M133CloneGraph {

    public NTreeNode cloneGraph(NTreeNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, NTreeNode> copies = new HashMap<>();
        return clone(node, copies);
    }

    private NTreeNode clone(NTreeNode node, Map<Integer, NTreeNode> copies) {
        if (copies.containsKey(node.val)) {
            return copies.get(node.val);
        }

        NTreeNode copy = new NTreeNode(node.val);
        copies.put(node.val, copy);

        for (NTreeNode neighbor : node.children) {
            NTreeNode neighborCopy = clone(neighbor, copies);
            copy.children.add(neighborCopy);
        }
        return copy;
    }
}
