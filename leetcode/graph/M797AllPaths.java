package graph;

import java.util.ArrayList;
import java.util.List;

public class M797AllPaths {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(paths, new ArrayList<>(), graph, 0);
        return paths;
    }

    private void dfs(List<List<Integer>> paths, List<Integer> path, int[][] graph, int curr) {
        path.add(curr);

        if (curr == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int node : graph[curr]) {
            dfs(paths, path, graph, node);
            path.removeLast();
        }
    }
}
