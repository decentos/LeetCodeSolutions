package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E1469FindLonelyNodes {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonely = new ArrayList<>();
        dfs(root, false, lonely);
        return lonely;
    }

    private void dfs(TreeNode curr, boolean isLonely, List<Integer> lonely) {
        if (curr == null) {
            return;
        }
        if (isLonely) {
            lonely.add(curr.val);
        }
        dfs(curr.left, curr.right == null, lonely);
        dfs(curr.right, curr.left == null, lonely);
    }
}
