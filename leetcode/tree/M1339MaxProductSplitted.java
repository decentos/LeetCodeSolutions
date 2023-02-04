package tree;

import util.TreeNode;

public class M1339MaxProductSplitted {
    private static long maxProduct = 0;
    private static int totalSum = 0;

    public static int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        findMaxProduct(root);
        return (int) (maxProduct % 1000000007);
    }

    private static int getSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return leftSum + rightSum + root.val;
    }

    private static int findMaxProduct(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findMaxProduct(root.left);
        int rightSum = findMaxProduct(root.right);
        int currentSum = leftSum + rightSum + root.val;
        long currentProduct = (long) (totalSum - currentSum) * currentSum;
        maxProduct = Math.max(maxProduct, currentProduct);
        return currentSum;
    }
}
