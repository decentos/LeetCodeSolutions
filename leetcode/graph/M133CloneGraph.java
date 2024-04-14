package graph;

import util.NTreeNode;

import java.util.HashMap;
import java.util.Map;

public class M133CloneGraph {

    public NTreeNode cloneGraph(NTreeNode node) {
        if (node == null) {
            return null;
        }
        return copy(node, new HashMap<>());
    }

    private NTreeNode copy(NTreeNode node, Map<Integer, NTreeNode> visited) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        NTreeNode copy = new NTreeNode(node.val);
        visited.put(node.val, copy);

        for (NTreeNode neighbor : node.children) {
            NTreeNode copyNeighbor = copy(neighbor, visited);
            copy.children.add(copyNeighbor);
        }
        return copy;
    }
}
