package sorting;

public class QuickSelect {

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

        int insertIndex = left;
        for (int i = left; i <= right; i++) {
            if (pivot > nums[i]) {
                swap(nums, insertIndex, i);
                insertIndex++;
            }
        }
        swap(nums, insertIndex, right);
        return insertIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
