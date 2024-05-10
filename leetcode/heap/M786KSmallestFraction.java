package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class M786KSmallestFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Queue<Fraction> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.offer(new Fraction(i, n - 1, (double) arr[i] / arr[n - 1]));
        }

        int smallest = 1;
        while (smallest < k) {
            Fraction curr = heap.poll();

            if (curr.rightIndex - 1 > curr.leftIndex) {
                curr.rightIndex--;
                curr.fraction = (double) arr[curr.leftIndex] / arr[curr.rightIndex];
                heap.offer(curr);
            }
            smallest++;
        }
        Fraction ans = heap.poll();
        return new int[]{arr[ans.leftIndex], arr[ans.rightIndex]};
    }

    private static class Fraction implements Comparable<Fraction> {
        int leftIndex;
        int rightIndex;
        double fraction;

        public Fraction(int leftIndex, int rightIndex, double fraction) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.fraction = fraction;
        }

        @Override
        public int compareTo(Fraction o) {
            return Double.compare(this.fraction, o.fraction);
        }
    }
}
