package tree.binary;

import util.TreeRightNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M117PopulatingNextRightPointers2 {

    public TreeRightNode connect(TreeRightNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeRightNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeRightNode curr = queue.poll();
                if (i < size - 1) {
                    curr.next = queue.peek();
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

// ===============================================================================

    public TreeRightNode connect2(TreeRightNode root) {
        if (root == null) {
            return null;
        }

        TreeRightNode treePointer = root;
        TreeRightNode dummyList = new TreeRightNode();
        TreeRightNode listPointer = dummyList;

        while (treePointer != null) {
            if (treePointer.left != null) {
                listPointer.next = treePointer.left;
                listPointer = listPointer.next;
            }
            if (treePointer.right != null) {
                listPointer.next = treePointer.right;
                listPointer = listPointer.next;
            }

            if (treePointer.next != null) {
                treePointer = treePointer.next;
            } else {
                treePointer = dummyList.next;
                dummyList.next = null;
                listPointer = dummyList;
            }
        }
        return root;
    }
}
