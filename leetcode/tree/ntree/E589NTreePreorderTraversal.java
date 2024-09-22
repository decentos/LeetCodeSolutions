package tree.ntree;

import util.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class E589NTreePreorderTraversal {

    public List<Integer> preorder(NTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, NTreeNode node) {
        if (node == null) return;

        ans.add(node.val);
        for (NTreeNode next : node.children) {
            dfs(ans, next);
        }
    }
}
