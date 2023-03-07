package easy;

public class E1539KthMissingNumber {

    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) return k;
        k -= arr[0] - 1;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1] - 1;

            if (k > diff) k -= diff;
            else return arr[i - 1] + k;
        }
        return arr[arr.length - 1] + k;
    }

    public int findKthPositive2(int[] arr, int k) {
        if (arr[0] > k) return k;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - mid - 1;
            if (k > missing) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
