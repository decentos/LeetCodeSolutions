package sorting;

public class RadixSort {
    private static final int SIZE = 10;

    public static void lsdRadixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) max = Math.max(max, i);

        int place = 1;
        while (max / place > 0) {
            countingSort(arr, place);
            place *= 10;
        }
    }

    private static void countingSort(int[] arr, int place) {
        int[] sorted = new int[arr.length];
        int[] count = new int[SIZE];
        for (int i : arr) {
            int curr = i / place;
            count[curr % SIZE]++;
        }

        int startIndex = 0;
        for (int i = 0; i < count.length; i++) {
            int curr = count[i];
            count[i] = startIndex;
            startIndex += curr;
        }

        for (int i : arr) {
            int curr = i / place;
            sorted[count[curr % SIZE]++] = i;
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
