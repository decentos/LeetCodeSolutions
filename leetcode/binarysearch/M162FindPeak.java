package binarysearch;

import java.util.List;
import java.util.Map;

public class M162FindPeak {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPeak(mid, nums)) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isPeak(int index, int[] nums) {
        return (index == 0 || nums[index] > nums[index - 1]) && (index == nums.length - 1 || nums[index] > nums[index + 1]);
    }

    private static final Map<Character, List<Character>> numToLettersMap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
}
