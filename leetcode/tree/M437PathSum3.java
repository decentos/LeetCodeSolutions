package tree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M437PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root, targetSum, 0)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode node, int targetSum, long currSum) {
        if (node == null) return 0;

        int count = 0;
        currSum += node.val;
        if (currSum == targetSum) count++;

        count += dfs(node.left, targetSum, currSum);
        count += dfs(node.right, targetSum, currSum);

        return count;
    }

// ===============================================================================

    public int pathSum2(TreeNode root, int targetSum) {
        return dfs(new HashMap<>(), root, targetSum, 0);
    }

    private int dfs(Map<Long, Integer> map, TreeNode node, int targetSum, long currSum) {
        if (node == null) return 0;

        int count = 0;
        currSum += node.val;
        if (targetSum == currSum) count++;
        count += map.getOrDefault(currSum - targetSum, 0);

        int freq = map.merge(currSum, 1, Integer::sum);
        count += dfs(map, node.left, targetSum, currSum);
        count += dfs(map, node.right, targetSum, currSum);
        map.replace(currSum, freq - 1);

        return count;
    }
}
