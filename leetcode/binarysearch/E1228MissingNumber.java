package binarysearch;

public class E1228MissingNumber {

    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        int expected = arr[0];

        for (int i : arr) {
            if (i != expected) return expected;
            expected += diff;
        }
        return expected;
    }

    public int missingNumber2(int[] arr) {
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[0] + diff * mid == arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[0] + diff * low;
    }
}
