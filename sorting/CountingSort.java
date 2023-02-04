public class CountingSort {

    // range from 0 to 100
    public static void countingSort(int[] arr) {
        int[] sorted = new int[arr.length];
        int[] count = new int[101];
        for (int i : arr) {
            count[i]++;
        }

        int startingIndex = 0;
        for (int i = 0; i < count.length; i++) {
            int curr = count[i];
            count[i] = startingIndex;
            startingIndex += curr;
        }

        for (int i : arr) {
            sorted[count[i]++] = i;
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }

    // range from -100 to 100
    public static void countingSortShift(int[] arr) {
        int[] sorted = new int[arr.length];
        int[] count = new int[201];
        int shift = 100;
        for (int i : arr) {
            count[i + shift]++;
        }

        int startingIndex = 0;
        for (int i = 0; i < count.length; i++) {
            int curr = count[i];
            count[i] = startingIndex;
            startingIndex += curr;
        }

        for (int i : arr) {
            sorted[count[i + shift]++] = i;
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
