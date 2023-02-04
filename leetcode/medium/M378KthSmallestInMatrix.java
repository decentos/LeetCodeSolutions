package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M378KthSmallestInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] row : matrix) {
            for (int i : row) {
                if (heap.size() < k) {
                    heap.offer(i);
                } else if (heap.peek() > i) {
                    heap.poll();
                    heap.offer(i);
                }
            }
        }
        return heap.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<>(Math.min(n, k), new MyHeapComparator());

        for (int r = 0; r < Math.min(n, k); r++) {
            minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
        }

        MyHeapNode element = minHeap.peek();
        while (k > 0) {
            element = minHeap.poll();
            int r = element.getRow(), c = element.getColumn();
            // If we have any new elements in the current row, add them
            if (c < n - 1) {
                minHeap.offer(new MyHeapNode(matrix[r][c + 1], r, c + 1));
            }
            k--;
        }
        return element.getValue();
    }

    static class MyHeapNode {
        private final int row;
        private final int column;
        private final int value;

        public MyHeapNode(int v, int r, int c) {
            this.value = v;
            this.row = r;
            this.column = c;
        }

        public int getValue() {
            return this.value;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }

    static class MyHeapComparator implements Comparator<MyHeapNode> {
        public int compare(MyHeapNode x, MyHeapNode y) {
            return x.value - y.value;
        }
    }
}
