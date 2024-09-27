package binarysearch;

public class E374GuessNumber {

    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessResult = guess(mid);

            if (guessResult == 0) {
                return mid;
            } else if (guessResult == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // LeetCode internal API
    private int guess(int guess) {
        return 0;
    }
}
