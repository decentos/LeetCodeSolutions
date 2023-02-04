package medium;

import java.util.HashMap;
import java.util.Map;

public class M2343KthSmallestTrimmed {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, String[]> sortedMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int pos = queries[i][0], trim = queries[i][1];
            int place = 1;

            String[] sorted;
            if (sortedMap.containsKey(trim)) {
                sorted = sortedMap.get(trim);
            } else {
                sorted = nums.clone();
                while (place <= trim) {
                    sorted = radixSort(sorted, nums[0].length() - place);
                    place++;
                }
                sortedMap.put(trim, sorted);
            }
            String answer = sorted[pos - 1];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == answer) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    private String[] radixSort(String[] nums, int place) {
        String[] sorted = new String[nums.length];
        int[] count = new int[10];
        for (String s : nums) {
            int curr = Character.getNumericValue(s.charAt(place));
            count[curr % 10]++;
        }

        int startIndex = 0;
        for (int i = 0; i < count.length; i++) {
            int curr = count[i];
            count[i] = startIndex;
            startIndex += curr;
        }

        for (String s : nums) {
            int curr = Character.getNumericValue(s.charAt(place));
            sorted[count[curr % 10]++] = s;
        }
        return sorted;
    }
}
