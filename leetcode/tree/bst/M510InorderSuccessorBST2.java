package tree.bst;

import util.TreeParentNode;

public class M510InorderSuccessorBST2 {

    public TreeParentNode inorderSuccessor(TreeParentNode node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return null;
    }
}
