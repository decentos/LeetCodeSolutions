package tree.ntree;

import util.NTreeNode;

public class M1522DiameterNTree {
    private int diameter = 0;

    public int diameter(NTreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(NTreeNode node) {
        if (node == null) return 0;

        int max1 = 0, max2 = 0;
        for (NTreeNode child : node.children) {
            int curr = dfs(child);
            if (curr > max1) {
                max2 = max1;
                max1 = curr;
            } else if (curr > max2) {
                max2 = curr;
            }
        }
        diameter = Math.max(diameter, max1 + max2);
        return max1 + 1;
    }
}
