package binarysearch;

public class E69Sqrt {

    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int low = 1, high = x / 2;

        while (low < high) {
            int mid = (low + (high - low) / 2) + 1;
            int div = x / mid;
            if (div == mid) return mid;
            else if (div > mid) low = mid;
            else high = mid - 1;
        }
        return low;
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;
        int low = 2, high = x / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long pow = (long) mid * mid;
            if (pow == x) return mid;
            else if (pow > x) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
}
