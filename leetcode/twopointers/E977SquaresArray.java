package twopointers;

public class E977SquaresArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int left = 0, right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int leftSqrt = nums[left] * nums[left];
            int rightSqrt = nums[right] * nums[right];
            if (leftSqrt > rightSqrt) {
                squares[i] = leftSqrt;
                left++;
            } else {
                squares[i] = rightSqrt;
                right--;
            }
        }
        return squares;
    }
}