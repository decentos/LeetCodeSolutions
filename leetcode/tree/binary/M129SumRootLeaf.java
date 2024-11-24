package tree.binary;

import util.TreeNode;

public class M129SumRootLeaf {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int number) {
        if (node == null) {
            return 0;
        }

        number = number * 10 + node.val;

        if (node.left == null && node.right == null) {
            return number;
        }

        int leftSum = sum(node.left, number);
        int rightSum = sum(node.right, number);
        return leftSum + rightSum;
    }

// ===============================================================================

    // Morris Preorder Traversal
    public int sumNumbers2(TreeNode root) {
        TreeNode curr = root;
        TreeNode pred = null;
        int sum = 0, number = 0, step = 0;

        while (curr != null) {
            if (curr.left != null) {
                pred = curr.left;
                step = 1;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                    step++;
                }

                if (pred.right == null) {
                    number = number * 10 + curr.val;
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    if (pred.left == null) {
                        sum += number;
                    }

                    for (int i = 0; i < step; i++) {
                        number /= 10;
                    }

                    pred.right = null;
                    curr = curr.right;
                }

            } else {
                number = number * 10 + curr.val;
                if (curr.right == null) {
                    sum += number;
                }
                curr = curr.right;
            }
        }
        return sum;
    }
}
