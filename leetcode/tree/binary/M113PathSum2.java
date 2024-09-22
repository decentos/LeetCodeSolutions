package tree.binary;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M113PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, new ArrayList<>(), root, targetSum);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> curr, TreeNode node, int targetSum) {
        if (node == null) return;

        targetSum -= node.val;
        curr.add(node.val);
        if (node.left == null && node.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(curr));
        } else {
            generate(ans, curr, node.left, targetSum);
            generate(ans, curr, node.right, targetSum);
        }
        curr.remove(curr.size() - 1);
    }
}
