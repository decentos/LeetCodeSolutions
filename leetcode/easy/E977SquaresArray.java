package easy;

public class E977SquaresArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int l = 0, r = n - 1;

        for (int i = r; i >= 0; i--) {
            int left = nums[l], right = nums[r];
            if (Math.abs(left) > Math.abs(right)) {
                squares[i] = left * left;
                l++;
            } else {
                squares[i] = right * right;
                r--;
            }
        }
        return squares;
    }
}