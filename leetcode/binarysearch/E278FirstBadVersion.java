package binarysearch;

public class E278FirstBadVersion {

    public static int firstBadVersion(int n, int target) {
        int low = 0;
        while (low <= n) {
            int mid = (low + n) / 2;
            if (target == mid) return mid;
            else low = mid + 1;
        }
        return -1;
    }
}
