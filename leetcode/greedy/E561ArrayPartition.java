package greedy;

import java.util.Arrays;

public class E561ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    // Counting Sort
    public int arrayPairSum2(int[] nums) {
        int K = 10000;
        // Store the frequency of each element
        int[] elementToCount = new int[2 * K + 1];
        for (int element : nums) {
            // Add K to element to offset negative values
            elementToCount[element + K]++;
        }

        // Initialize sum to zero
        int maxSum = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element < elementToCount.length; element++) {
            while (elementToCount[element] > 0) {
                // Add element if it is at even position
                maxSum += (isEvenIndex ? element - K : 0);
                // Flip the value (one to zero or zero to one)
                isEvenIndex = !isEvenIndex;
                // Decrement the frequency count
                elementToCount[element]--;
            }
        }
        return maxSum;
    }
}
