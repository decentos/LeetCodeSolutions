package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M652FindDuplicateSubtrees {
    private final Map<String, Integer> map = new HashMap<>();
    private final List<TreeNode> dup = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return dup;
    }

    private String dfs(TreeNode node) {
        if (node == null) return "null";
        String path = node.val + "->" + dfs(node.left) +  "->" + dfs(node.right);
        map.merge(path, 1, Integer::sum);
        if (map.get(path) == 2) dup.add(node);
        return path;
    }

    private final Map<String, Integer> toId = new HashMap<>();
    private final Map<Integer, Integer> dupMap = new HashMap<>();
    private final List<TreeNode> res = new ArrayList<>();
    public int traverse(TreeNode node) {
        if (node == null) return 0;

        String triplet = node.val + "->" + traverse(node.left) + "->" + traverse(node.right);
        if (!toId.containsKey(triplet)) {
            toId.put(triplet, toId.size() + 1);
        }
        int id = toId.get(triplet);
        dupMap.merge(id, 1, Integer::sum);
        if (dupMap.get(id) == 2) res.add(node);
        return id;
    }
}
