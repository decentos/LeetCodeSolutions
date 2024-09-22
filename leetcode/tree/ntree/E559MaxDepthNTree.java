package tree.ntree;

import util.NTreeNode;

public class E559MaxDepthNTree {

    public int maxDepth(NTreeNode root) {
        if (root == null) return 0;
        int max = 0;
        for (NTreeNode next : root.children) {
            int currMax = maxDepth(next);
            max = Math.max(max, currMax);
        }
        return max + 1;
    }
}
