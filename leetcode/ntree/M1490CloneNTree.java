package ntree;

import util.NTreeNode;

import java.util.Stack;

public class M1490CloneNTree {

    public NTreeNode cloneTree(NTreeNode root) {
        if (root == null) return null;

        NTreeNode node = new NTreeNode(root.val);
        for (NTreeNode child : root.children) {
            node.children.add(cloneTree(child));
        }
        return node;
    }

    public NTreeNode cloneTree2(NTreeNode root) {
        if (root == null) return null;

        NTreeNode clone = new NTreeNode(root.val);
        Stack<NTreeNode[]> stack = new Stack<>();
        stack.push(new NTreeNode[]{root, clone});

        while (!stack.isEmpty()) {
            NTreeNode[] pair = stack.pop();
            NTreeNode original = pair[0];
            NTreeNode copy = pair[1];

            for (NTreeNode child : original.children) {
                NTreeNode copyChild = new NTreeNode(child.val);
                copy.children.add(copyChild);

                stack.push(new NTreeNode[]{child, copyChild});
            }
        }
        return clone;
    }
}
