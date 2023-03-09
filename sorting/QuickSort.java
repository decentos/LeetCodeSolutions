public class QuickSort {

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partition = partition(arr, left, right);
        sort(arr, left, partition - 1);
        sort(arr, partition + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) continue;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
}
