package binarysearch;

public class E367ValidSquare {

    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int low = 1, high = num / 2;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int div = num / mid;
            if (div == mid && mid * mid == num) return true;
            else if (div > mid) low = mid + 1;
            else high = mid - 1;
            if (low == high && low * high == num) return true;
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num == 1) return true;
        long low = 1, high = num / 2;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long multiply = mid * mid;
            if (multiply == num) return true;
            else if (multiply < num) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
