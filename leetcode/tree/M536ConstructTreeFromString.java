package tree;

import util.TreeNode;

public class M536ConstructTreeFromString {
    private int index = 0;

    public TreeNode str2tree(String s) {
        return dfs(s);
    }

    private TreeNode dfs(String s) {
        if (index >= s.length()) return null;
        if (s.charAt(index) == ')') {
            index++;
            return null;
        }

        int val = getVal(s);
        TreeNode node = new TreeNode(val);

        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            node.left = dfs(s);
        }
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            node.right = dfs(s);
        }

        index++;
        return node;
    }

    private int getVal(String s) {
        StringBuilder val = new StringBuilder();
        while (index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) {
            val.append(s.charAt(index));
            index++;
        }
        return Integer.parseInt(val.toString());
    }
}
