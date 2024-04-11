package graph.unionfind;

import java.util.*;

public class M1202SmallestStringSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] result = new char[n];
        UnionFind uf = new UnionFind(n);

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> roots = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            roots.computeIfAbsent(root, val -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : roots.values()) {
            List<Character> letters = new ArrayList<>();
            for (int index : indices) {
                letters.add(s.charAt(index));
            }
            Collections.sort(letters);

            for (int i = 0; i < letters.size(); i++) {
                result[indices.get(i)] = letters.get(i);
            }
        }

        return String.valueOf(result);
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
