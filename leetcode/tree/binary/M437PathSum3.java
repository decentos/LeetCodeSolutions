package tree.binary;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M437PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum, 0, new HashMap<>());
    }

    private int dfs(TreeNode node, int targetSum, long currSum, Map<Long, Integer> sum) {
        if (node == null) {
            return 0;
        }

        currSum += node.val;

        int count = sum.getOrDefault(currSum - targetSum, 0);
        if (currSum == targetSum) {
            count++;
        }

        sum.merge(currSum, 1, Integer::sum);
        count += dfs(node.left, targetSum, currSum, sum);
        count += dfs(node.right, targetSum, currSum, sum);
        sum.merge(currSum, -1, Integer::sum);
        return count;
    }
}
