package me.decentos.leetcode.sorting;

public class M912SortArray {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            balanceHeap(nums, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            balanceHeap(nums, i, 0);
        }
        return nums;
    }

    private void balanceHeap(int[] nums, int size, int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        if (leftChild < size && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }
        if (rightChild < size && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(nums, index, largest);
            balanceHeap(nums, size, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
