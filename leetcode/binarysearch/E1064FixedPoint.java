package binarysearch;

public class E1064FixedPoint {

    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1, answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == mid) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
