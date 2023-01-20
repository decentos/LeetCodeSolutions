package me.decentos.leetcode.sorting.based;

public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeap(arr, i, 0);
        }
    }

    private static void maxHeap(int[] arr, int size, int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        if (leftChild < size && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < size && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(arr, index, largest);
            maxHeap(arr, size, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
