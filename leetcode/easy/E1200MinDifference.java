package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1200MinDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int currDiff = arr[i] - arr[i - 1];
            if (currDiff == minDiff) {
                result.add(List.of(arr[i - 1], arr[i]));
            } else if (currDiff < minDiff) {
                result = new ArrayList<>();
                result.add(List.of(arr[i - 1], arr[i]));
                minDiff = currDiff;
            }
        }
        return result;
    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int shift = 1_000_000;
        int[] count = new int[2 * shift + 1];
        for (int i : arr) {
            count[i + shift]++;
        }

        int prev = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int curr = 1; curr < count.length; curr++) {
            if (count[curr] == 0) continue;

            int currDiff = curr - prev;
            if (currDiff == minDiff) {
                result.add(List.of(prev - shift, curr - shift));
            } else if (currDiff < minDiff) {
                result = new ArrayList<>();
                result.add(List.of(prev - shift, curr - shift));
                minDiff = currDiff;
            }
            prev = curr;
        }
        return result;
    }
}
