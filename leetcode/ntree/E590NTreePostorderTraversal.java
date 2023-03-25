package ntree;

import util.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class E590NTreePostorderTraversal {

    public List<Integer> postorder(NTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, NTreeNode node) {
        if (node == null) return;

        for (NTreeNode next : node.children) {
            dfs(ans, next);
        }
        ans.add(node.val);
    }
}
