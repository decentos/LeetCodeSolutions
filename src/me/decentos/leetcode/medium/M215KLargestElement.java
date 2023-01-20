package me.decentos.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M215KLargestElement {

    public int findKthLargestQueue(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int i : nums) {
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }
        return heap.poll();
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int kth) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right, left);

        if (kth == pivotIndex) return nums[kth];
        else if (kth > pivotIndex) return quickSelect(nums, pivotIndex + 1, right, kth);
        else return quickSelect(nums, left, pivotIndex - 1, kth);
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (pivot > nums[i]) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
