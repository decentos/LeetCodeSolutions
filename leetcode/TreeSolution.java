import tree.E94TreeInorderTraversal;
import util.TreeNode;

public class TreeSolution {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.newTree(1, null, 2);
        treeNode.right.left = new TreeNode(3);
//        TreeNode treeNode2 = TreeNode.newTree(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8);
//        System.out.println(E110BalancedTree.isBalanced(treeNode));
//        System.out.println(M450DeleteNode.deleteNode(treeNode, 3));
//        System.out.println(H124TreeMaximumSum.maxPathSum(treeNode));
//        System.out.println(E112PathSum.hasPathSum(treeNode, 22));
//        System.out.println(M1339MaxProductSplitted.maxProduct(treeNode));
//        System.out.println(M1026MaximumDifference.maxAncestorDiff(treeNode));
//        System.out.println(E872LeafSimilarTrees.leafSimilar(treeNode, treeNode2));
//        System.out.println(E938RangeSum.rangeSumBST(treeNode, 7, 15));
//        System.out.println(LowestCommonAncestor.lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4)));
//        System.out.println(ValidateBinaryTree.isValidBST(treeNode));
//        System.out.println(TreeOrderTraversal.levelOrder(treeNode));
//        ListNode head = ListNode.createList(-10,-3,0,5,9);
//        M109ConvertListToTree m109 = new M109ConvertListToTree();
//        m109.sortedListToBST(head);
        E94TreeInorderTraversal e94 = new E94TreeInorderTraversal();
        e94.inorderTraversal2(treeNode);
    }
}
