package graph;

import util.NTreeNode;

import java.util.HashMap;
import java.util.Map;

public class M133CloneGraph {

    public NTreeNode cloneGraph(NTreeNode node) {
        return copy(node, new HashMap<>());
    }

    private NTreeNode copy(NTreeNode node, Map<NTreeNode, NTreeNode> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        NTreeNode copy = new NTreeNode(node.val);
        map.put(node, copy);

        for (NTreeNode child : node.children) {
            copy.children.add(copy(child, map));
        }
        return copy;
    }
}
