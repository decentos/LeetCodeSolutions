package graph.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H952LargestComponentByCommonFactor {

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> factorToRoot = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            List<Integer> factors = getFactors(nums[i]);
            for (int factor : factors) {
                if (!factorToRoot.containsKey(factor)) {
                    factorToRoot.put(factor, i);
                } else {
                    int root = factorToRoot.get(factor);
                    uf.union(root, i);
                }
            }
        }

        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            size[root]++;
        }

        int maxSize = 0;
        for (int curr : size) {
            maxSize = Math.max(maxSize, curr);
        }
        return maxSize;
    }

    private List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        if (num % 2 == 0) {
            factors.add(2);
            while (num % 2 == 0) {
                num /= 2;
            }
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 2) {
            factors.add(num);
        }
        return factors;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (root[node] == node) {
                return node;
            }
            return root[node] = find(root[node]);
        }

        public void union(int nodeX, int nodeY) {
            int rootX = find(nodeX);
            int rootY = find(nodeY);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
