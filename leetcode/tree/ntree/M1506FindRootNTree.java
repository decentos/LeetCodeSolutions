package tree.ntree;

import util.NTreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M1506FindRootNTree {

    public NTreeNode findRoot(List<NTreeNode> tree) {
        Set<Integer> seen = new HashSet<>();
        for (NTreeNode node : tree) {
            for (NTreeNode next : node.children) {
                seen.add(next.val);
            }
        }

        for (NTreeNode node : tree) {
            if (!seen.contains(node.val)) return node;
        }
        return null;
    }

    public NTreeNode findRoot2(List<NTreeNode> tree) {
        int rootVal = 0;
        for (NTreeNode node : tree) {
            rootVal += node.val;
            for (NTreeNode next : node.children) {
                rootVal -= next.val;
            }
        }

        for (NTreeNode node : tree) {
            if (rootVal == node.val) return node;
        }
        return null;
    }
}
