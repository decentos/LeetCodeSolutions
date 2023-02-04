public class SortingSolution {
    public static void main(String[] args) {
        SelectionSort.selectionSort(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1});
        BubbleSort.bubbleSortReverse(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1});
        InsertionSort.insertionSort(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1});
        HeapSort.heapSort(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1});
        CountingSort.countingSortShift(new int[]{-7, 3, -2, 5, 6, 10, 9, 8, 1});
        RadixSort.lsdRadixSort(new int[]{6, 12, 324, 11, 222, 98, 115, 4});
        BucketSort.bucketSort(new int[]{23, 25, 21, 12, 19, 17, 5, 7}, 5);
        QuickSelect.findKthLargest(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1, 4, 0}, 2);
    }
}
