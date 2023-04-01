package sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;

        int pivot = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(arr, pivot, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            int leftCurr = left[leftIndex];
            int rightCurr = right[rightIndex];
            if (leftCurr < rightCurr) {
                merged[mergedIndex] = leftCurr;
                leftIndex++;
            } else {
                merged[mergedIndex] = rightCurr;
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < left.length) {
            merged[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < right.length) {
            merged[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

        return merged;
    }
}
